package com.gaos.paralaxmoveverticalimageview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/13 10:36
 * versionCode:　1.0.0
 * 实现了圆角。
 */

public class RoundRectImageView extends ImageView {
    private final Paint paint;
    private int intrinsicWidth;
    private int intrinsicHeight;
    private Path path;
    private float cornor_rasius = 20;

    public RoundRectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
         /*clipPath with hardware acceleration is only supported in API level 18 and higher,
      on API levels from 11 to 17 it needs to be turned off.*/
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
        paint = new Paint();
        paint.setColor(0x00ffffff);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        intrinsicWidth = getDrawable().getIntrinsicWidth();
        intrinsicHeight = getDrawable().getIntrinsicHeight();
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);

        path = new Path();
        float[] radii = new float[8];
        for (int i = 0; i < 8; i++) {
            radii[i] = cornor_rasius;
        }
        path.addRoundRect(new RectF(0, 0, intrinsicWidth, intrinsicHeight), radii, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.clipPath(path);
        getDrawable().draw(canvas);
    }
}
