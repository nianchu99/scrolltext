# scrolltext

[![](https://jitpack.io/v/nianchu99/scrolltext.svg)](https://jitpack.io/#nianchu99/scrolltext)

## summary

Use ScrollText , you can simply scroll any text. It supports horizontal and vertical scrolling, and you can customize the text color, background color, scroll speed, font size, etc.

## Usage

### Step1. Add this to use java8

```xml
compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
```

### Step2. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories

```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step3. Add the dependency 

```java
dependencies {
// The latest version please see latest releases, it will be like this "v0.1.1"
	        implementation 'com.github.nianchu99:scrolltext:latest version'
	}
```



## Parameters

### xml

```xml
<attr name="scrollColor" format="reference|color"/>
        <attr name="scrollSize" format="integer"/>
        <attr name="scrollSpeed" format="integer"/>
        <attr name="scrollContent" format="string"/>
        <attr name="scrollBackColor" format="reference|color"/>
        <attr name="android:orientation">
```



### Java

```java
// Getter
int color: getmColor();
int color: getBackColor();
String content: getScrollString();
boolean isScroll: getIsScroll();
// (0 horizontal , 1 is vertical )
int orientation: getOrientation();
int textSize: getScrollSize();
int speed: getSpeed();
// Setter
setmColor(int color);
setBackColor(int color);
setScrollString(String content);
setIsScroll(boolean isScroll);
setOrientation(int orientation);
setScrollSize(int textSize);
setSpeed(int spee);
// action
start();
pause();
```



## Detail



### Use in xml

```xml
<space.nianchu.scrolltext.ScrollTextView
                   android:id="@+id/text4"
                   app:scrollColor="#00FF00"
                   app:scrollSize="100"
                   app:scrollSpeed="5"
                   app:scrollContent="Nice to meet you."
                   app:scrollBackColor="#000000"
                   android:orientation="vertical"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"/>
```

# 

### Use by java

```java
ScrollTextView horizontalText1 = new ScrollTextView(this);
        scrollTextAddByJavaLayout.addView(horizontalText1);
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) horizontalText1.getLayoutParams();
        params1.gravity = Gravity.CENTER_HORIZONTAL;
        params1.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        params1.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        horizontalText1.setLayoutParams(params1);
        horizontalText1.start();
```



### Notice:

**No attribute is required. If there is no setting, the default is:**



| Parameter       | Value                            |
| --------------- | -------------------------------- |
| scrollColor     | 0xFF000000                       |
| scrollSize      | 100                              |
| scrollSpeed     | 5                                |
| scrollContent   | Nice to meet you.                |
| scrollBackColor | 0xFFFFFFFF                       |
| orientation     | 1(0 horizontal , 1 is vertical ) |

## Screenshot of the effect

![scrollText1](https://tva1.sinaimg.cn/large/008i3skNly1gtgrcfjuqmg60860g24qf02.gif)



![scrollText2](https://tva1.sinaimg.cn/large/008i3skNly1gtgr0ywbzsg608c0hitsr02.gif)





**More info, please see demo.**

