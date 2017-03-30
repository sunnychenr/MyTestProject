package com.lionmobi.custombutton.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;

/**
 * Created by ChenR on 2017/3/30.
 */

public class CustomSwitch extends CompoundButton{

    private int mWidth, mHeight;
    private int mMinWidth, mMinHeight;
    private float denity;

    private Paint mPaint;

    public CustomSwitch(Context context) {
        this(context, null);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        denity = metrics.density;
        mMinWidth = (int) (60 * denity);
        mMinHeight = mMinWidth / 2;

        setBackgroundColor(0x00000000);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();

        if (mWidth <= 0) {
            mWidth = getRight() - getLeft();
        }
        if (mHeight <= 0) {
            mHeight = getBottom() - getTop();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = (mMinWidth - mMinHeight) / 2, top = 0, right = mMinWidth - left, bottom = mMinHeight;
        mPaint.setColor(0x44888888);
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
