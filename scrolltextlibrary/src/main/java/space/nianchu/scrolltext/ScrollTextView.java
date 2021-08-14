package space.nianchu.scrolltext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;


public class ScrollTextView extends View implements View.OnLongClickListener {
    private static final String TAG = "ScrollTextView";
    private boolean isScroll = false;
    private Paint.FontMetricsInt fontMetricsInt;
    private int mColor;
    private int backColor;
    private Paint mPaint;
    private Paint mBackPaint;
    private int scrollSpeed;
    private int scrollSize;
    private String scrollString;
    private int textHeight;
    private int textWidth;
    private int mWidth;
    private int mHeight;
    private int baselineWidth;
    private int currentX = 10;
    private Timer timer;
    private TimerTask timerTask;
    private int orientation;
    public ScrollTextView(Context context) {
        super(context);
        mPaint = new Paint();
        mBackPaint = new Paint();
        replaceInitAttrs();
        init();
        // Set onLongClickListener
//        setOnLongClickListener(this::onLongClick);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBackPaint = new Paint();
        initAttrs(attrs);
        init();
        // Set onLongClickListener
//        setOnLongClickListener(this::onLongClick);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Log.d(TAG, "onMeasure: paddingTop" + getPaddingTop());
//        Log.d(TAG, "onMeasure: top" + getTop());
//        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
//        setMeasuredDimension(wm.getDefaultDisplay().getWidth(), wm.getDefaultDisplay().getHeight());
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        measureWidth(widthMode, width);
        measureHeight(heightMode, height);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        Set the background
        Rect rect = new Rect(0, 0, getWidth(),  getHeight());
        canvas.drawRect(rect,mBackPaint);

        if (orientation == 1){
            canvas.rotate(90);
            canvas.save();
            canvas.drawText(scrollString, currentX, 0 - getWidth() / 2 + baselineWidth / 4,mPaint);
            canvas.restore();
        }
        else if (orientation == 0){
            canvas.drawText(scrollString, currentX, 0 + getHeight() / 2 + baselineWidth / 4,mPaint);
        }

    }

    protected void initAttrs(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = null;
            try {
                typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ScrollText);
                mColor = typedArray.getColor(R.styleable.ScrollText_scrollColor, Color.BLACK);
                if(typedArray.hasValue(R.styleable.ScrollText_scrollContent)){
                    scrollString = typedArray.getString(R.styleable.ScrollText_scrollContent);
                }else {
                    scrollString = "Nice to meet you.";
                }
                scrollSize = typedArray.getInt(R.styleable.ScrollText_scrollSize, 100);
                scrollSpeed = typedArray.getInt(R.styleable.ScrollText_scrollSpeed, 5);
                backColor = typedArray.getColor(R.styleable.ScrollText_scrollBackColor, Color.WHITE);
                orientation = typedArray.getInt(R.styleable.ScrollText_android_orientation, 1);
            }
            finally {
                if (typedArray != null){
                    typedArray.recycle();
                }
            }
        }
    }
    public void init(){
        mPaint.setColor(mColor);
//        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setTextSize(scrollSize);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mBackPaint.setColor(backColor);
        mBackPaint.setStyle(Paint.Style.FILL);
        mBackPaint.setAntiAlias(true);
        mBackPaint.setDither(true);
        fontMetricsInt = mPaint.getFontMetricsInt();
        textWidth = (int) mPaint.measureText(scrollString);
        textHeight = fontMetricsInt.descent - fontMetricsInt.ascent;
        if (orientation == 1){
            mWidth = textHeight;
            mHeight = textWidth;
        }else if (orientation == 0)
        {
            mWidth = textWidth;
            mHeight = textHeight;
        }

        baselineWidth = fontMetricsInt.leading - fontMetricsInt.ascent;
    }
    protected void replaceInitAttrs(){
        mColor = Color.BLACK;
        scrollString = "Nice to meet you.";
        scrollSize = 100;
        scrollSpeed = 5;
        backColor = Color.WHITE;
        orientation = 0;
    }
    public void start(){
        init();
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                currentX -= scrollSpeed;
                invalidate();
                if (orientation == 1){
                if (currentX < textWidth * -1){
                    currentX = getHeight();
                }}else if (orientation == 0){
                    if (currentX < textWidth * -1){
                        currentX = textWidth;
                    }
                }
            }
        };
        timer.schedule(timerTask, 0, 100);
        isScroll = true;
    }
    public void pause(){
        if (timer != null){
        timer.cancel();
        }
        isScroll = false;
    }
    public int getmColor(){
        return mColor;
    }
    public boolean getIsScroll(){
        return isScroll;
    }
    public void setOrientation(int orientation){
        this.orientation = orientation;
    }
    public void setScrollSpeed(int speed){
        this.scrollSpeed = speed;
        pause();
        start();
    }
    public void setScrollSize(int size){
        this.scrollSize = size;
    }
    public void setScrollString(String content){
        this.scrollString = content;
    }
    public void setmColor(int newColor){
        this.mColor = newColor;
    }
    public void setBackColor(int backColor){
        this.backColor = backColor;
    }
    public void setIsScroll(boolean isScroll){
        this.isScroll = isScroll;
    }
    private void measureWidth(int mode, int width){
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
                case MeasureSpec.EXACTLY:
                    if (orientation == 1){
                    if (width > mWidth){
                        mWidth =width;
                    }}else if (orientation == 0){
                        mWidth =width;
                    }
                    break;
        }
    }
    private void measureHeight(int mode, int height){
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                if (orientation == 0){
                    if (height > mHeight){
                        mHeight = height;
                    }}else if (orientation == 1){
                    mHeight = height;
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Log.d(TAG, "onLongClick: ");
        if (isScroll){
            pause();
        }else {
            start();
        }

        return true;
    }
}
