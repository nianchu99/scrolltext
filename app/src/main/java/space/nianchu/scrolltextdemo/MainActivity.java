package space.nianchu.scrolltextdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import space.nianchu.scrolltext.ScrollTextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.scroll_text_title1)
    TextView scrollTextTitle1;
    @BindView(R.id.text1)
    ScrollTextView text1;
    @BindView(R.id.text2)
    ScrollTextView text2;
    @BindView(R.id.text3)
    ScrollTextView text3;
    @BindView(R.id.text4)
    ScrollTextView text4;
    @BindView(R.id.text5)
    ScrollTextView text5;
    @BindView(R.id.text6)
    ScrollTextView text6;
    @BindView(R.id.text7)
    ScrollTextView text7;
    @BindView(R.id.scroll_text_add_by_java_layout)
    LinearLayout scrollTextAddByJavaLayout;
    @BindView(R.id.scroll_text_title2)
    TextView scrollTextTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Get scroll text from xml and start to scroll in .java
        text1.start();
        text2.start();
        text3.start();
        text4.start();
        text5.start();
        text6.start();
        text7.start();
//      Create and set scrollTextView in activity
//        1
        ScrollTextView horizontalText1 = new ScrollTextView(this);
        scrollTextAddByJavaLayout.addView(horizontalText1);
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) horizontalText1.getLayoutParams();
        params1.gravity = Gravity.CENTER_HORIZONTAL;
        params1.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        params1.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        horizontalText1.setLayoutParams(params1);
        horizontalText1.start();
//        2
        ScrollTextView horizontalText2 = new ScrollTextView(this);
        horizontalText2.setBackColor(Color.BLACK);
        horizontalText2.setmColor(Color.WHITE);
        scrollTextAddByJavaLayout.addView(horizontalText2);
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) horizontalText2.getLayoutParams();
        params2.gravity = Gravity.CENTER_HORIZONTAL;
        params2.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params2.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        horizontalText2.setLayoutParams(params2);
        horizontalText2.start();
//          3
        ScrollTextView horizontalText3 = new ScrollTextView(this);
        horizontalText3.setBackColor(Color.RED);
        horizontalText3.setmColor(Color.WHITE);
        scrollTextAddByJavaLayout.addView(horizontalText3);
        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) horizontalText3.getLayoutParams();
        params3.gravity = Gravity.CENTER_HORIZONTAL;
        params3.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params3.height = 600;
        horizontalText3.setLayoutParams(params3);
        horizontalText3.start();
//        The largest scrollTextView
        TextView title3 = new TextView(this);
        scrollTextAddByJavaLayout.addView(title3);
        title3.setTextSize(30);
        title3.setText("Scroll Text3");
        title3.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams title3Params = (LinearLayout.LayoutParams) title3.getLayoutParams();
        title3Params.gravity = Gravity.CENTER;
        title3Params.topMargin = 10;
        title3Params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        title3Params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        title3.setLayoutParams(title3Params);
        ScrollTextView largestScrollText = new ScrollTextView(this);
        largestScrollText.setBackColor(Color.GREEN);
        largestScrollText.setmColor(Color.WHITE);
        largestScrollText.setOrientation(1);
        largestScrollText.setScrollSize(300);
        scrollTextAddByJavaLayout.addView(largestScrollText);
        LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) largestScrollText.getLayoutParams();
        params4.gravity = Gravity.CENTER_HORIZONTAL;
        params4.width = LinearLayout.LayoutParams.MATCH_PARENT;
        WindowManager windowManager = this.getWindowManager();
        params4.height = windowManager.getDefaultDisplay().getHeight();
        largestScrollText.setLayoutParams(params4);
        largestScrollText.start();
    }


}
