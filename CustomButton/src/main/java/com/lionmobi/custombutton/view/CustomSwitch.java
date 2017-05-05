package com.lionmobi.custombutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;

import com.lionmobi.custombutton.utils.Utils;

/**
 * Created by ChenR on 2017/3/30.
 */

public class CustomSwitch extends CompoundButton {

    private int mWidth, mHeight;
    private int mMinWidth, mMinHeight;
    private float denity;

    private Paint mPaint1, mPaint2;

    public CustomSwitch(Context context) {
        this(context, null);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        denity = metrics.density;
        mMinWidth = (int) (60 * denity);
        mMinHeight = mMinWidth / 2;

        setBackgroundColor(0x00000000);

        initBitmap();
    }

    private Bitmap bitmap;
    private void initBitmap() {
        int o = mMinHeight / 2;
        bitmap = Bitmap.createBitmap(mMinHeight, mMinHeight, Bitmap.Config.ARGB_4444);
        Canvas mCanvas = new Canvas(bitmap);
        mPaint2.setColor(0xffffffff);
        mCanvas.drawCircle(o, o, o-4, mPaint2);   // drawCircle(float cx, float cy, float radius, @NonNull Paint paint)
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

    private float l = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = 0, top = 0, right = mMinWidth, bottom = mMinHeight;
        int roundPx = mMinHeight / 2;
        mPaint1.setColor(0x44888888);
        canvas.drawRoundRect(new RectF(left, top, right, bottom), roundPx, roundPx, mPaint1);
        canvas.save();
        mPaint1.setColor(0xffffffff);
        canvas.drawBitmap(bitmap, l, 0, mPaint1);
    }

    private float downX;
    private float downL;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downL = l;
                break;
            case MotionEvent.ACTION_MOVE:
                float dist = event.getX() - downX;
                int maxDist = mMinWidth - mMinHeight;

                if (downL == maxDist) {
                    if (dist < 0) {
                        if (dist > -maxDist) {
                            l = dist + maxDist;
                        } else {
                            l = 0;
                        }
                    } else {
                        l = maxDist;
                    }
                } else if (downL == 0) {
                    if (dist > 0) {
                        if (dist < maxDist) {
                            l = dist;
                        } else {
                            l = maxDist;
                        }
                    } else {
                        l = 0;
                    }
                }
                Utils.logD("dist: " + dist);
                Utils.logD("l: " + l);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                int i = mMinWidth - mMinHeight;
                if (l < i/2) {
                    l = 0;
                } else {
                    l = i;
                }
                invalidate();
                break;
        }

        return true;
    }
}
