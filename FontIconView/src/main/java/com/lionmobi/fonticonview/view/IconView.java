package com.lionmobi.fonticonview.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lionmobi.fonticonview.BaseApplication;

/**
 * Created by ChenR on 2017/2/5.
 *
 * 最简单的字体图标使用,
 * 1. 首先在创建的Application类中初始化Typeface(Android 的字体支持类???)(Android 初始化界面需要16ms,为节约时间将初始化放到Application中)
 *      加载Typeface可以使用系统字体,也可以使用"XXX.ttf"文件的自定义字体,一般使用字体图标时都需要将图标加载到ttf文件中,然后在使用时加载,
 *      一般制作FontIconView的网站: https://icomoon.io/app/#/select(需要翻墙), 还有一些离线可制作FontIconView的软件;
 * 2. 创建自定义的的图标视图类(IconView)(继承自TextView);
 * 3. 创建icon的String字符串集(XXX.xml)(一般为 16 进制的字符串);
 * 4. 在布局文件中引用自定义的FontIconView, text属性设置为icon的字符串即可;
 */

public class IconView extends TextView {

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setTypeface(BaseApplication.getInstance().getIconFace());
    }
}
