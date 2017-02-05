package com.lionmobi.fonticonview.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lionmobi.fonticonview.BaseApplication;

/**
 * Created by ChenR on 2017/2/5.
 */

public class IconView extends TextView {

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setTypeface(BaseApplication.getInstance().getIconFace());
    }
}
