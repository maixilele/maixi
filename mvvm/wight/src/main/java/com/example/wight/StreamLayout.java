package com.example.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class StreamLayout extends ViewGroup {

    /**
     *  x y 的起始坐标位置
     */
    private int x,y=0;

    /**
     * xy的间距
     */
    private int xSpace,ySpace = 0;

    //每次y移动的高度
    private int yStep = 50;

    /**
     * 当前viewGroup
     */
    private int layoutWidth,layoutHeight = 0;


    public StreamLayout(Context context) {
        super(context);
    }

    public StreamLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StreamLayout);
        xSpace = typedArray.getInteger(R.styleable.StreamLayout_xSpace,0);
        ySpace = typedArray.getInteger(R.styleable.StreamLayout_ySpace,0);
        typedArray.recycle();

//        setBackgroundColor(Color.BLUE);
//        setWillNotDraw(false);
    }

    public StreamLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        layoutWidth=w;
        layoutHeight=h;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        //获取当前viewGroup中的子控件个数
        int childCount = getChildCount();
        for (int j = 0; j < childCount; j++) {
            //根据索引获取具体的view
            View view = getChildAt(j);
            //layout 方法传递4个参数左上右下
            int viewHeight = view.getMeasuredHeight();
            int viewWidth = view.getMeasuredWidth();
            //如果当前的x不大于viewGroup的宽 那就x累加 否则 x=0 y累计
            if ((x+viewWidth+xSpace)>layoutWidth){
                x=0;
                y=y+viewHeight+ySpace;
            }
            view.layout(x+xSpace,y+ySpace,x+viewWidth+xSpace,y+viewHeight+ySpace);
            x=x+viewWidth+xSpace;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量子控件 必不可少
        measureChildren(widthMeasureSpec,heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
