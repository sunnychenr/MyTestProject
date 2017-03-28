package com.lionmobi.cardviewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by ChenR on 2017/3/28.
 */

public class ElevationView extends TextView {
    private Paint mPaint;
    private int mWidth, mHeight;

    private int mTextColor;
    private float mTextSize;
    private CharSequence text;

    public ElevationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        text = getText();
        mTextColor = getCurrentTextColor();
        mTextSize = getTextSize();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        setGravity(Gravity.CENTER);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getWidth();
        mHeight = getHeight();

        if (mWidth <= 0) {
            mWidth = Math.abs(getLeft() - getRight());
        }
        if (mHeight <= 0) {
            mHeight = Math.abs(getBottom() - getTop());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("chenr", "width: " + mWidth + ",  height: " + mHeight);

        float roundWidth = (mWidth - 10);
        mPaint.setColor(0xff008bfb);
        mPaint.setShadowLayer(10.0f, 6, 4, 0x22000000);
        canvas.drawRoundRect(new RectF(5, 3, roundWidth, roundWidth), roundWidth / 2, roundWidth / 2, mPaint);

        mPaint.clearShadowLayer();
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
        canvas.drawText(text, 0, text.length(), mWidth / 2, mHeight / 2, mPaint);

        mPaint.setColor(0xff000000);
        canvas.drawPoint(mWidth / 2, mHeight / 2, mPaint);
    }
}
