package com.gaos.paralaxmoveverticalimageview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.gaos.paralaxmoveverticalimageview.utils.MeasureSpecUtil;


/**
 * Author:　Created by benjamin
 * DATE :  2017/4/12 15:59
 * versionCode:　1.0.0
 * 手动指定ImageView的宽度。
 */

public class WidthMatchParentImageView extends ImageView {
    private static final String TAG = WidthMatchParentImageView.class.getSimpleName();

    public WidthMatchParentImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        MeasureSpecUtil.measureSpecInfo(widthMeasureSpec, heightMeasureSpec, TAG);
////        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
//        Rect bounds = getDrawable().copyBounds();
//        Log.i(TAG, "onMeasure: bounds width =" + bounds.width());
//        Log.i(TAG, "onMeasure: bounds height =" + bounds.height());
//        float scaleFactor = bounds.width() * 1.0f / bounds.height();
//        float newHeight = MeasureSpec.getSize(widthMeasureSpec) * 1.0f / scaleFactor;
//        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), (int) newHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
