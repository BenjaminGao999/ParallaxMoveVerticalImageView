package com.gaos.paralaxmoveverticalimageview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/13 10:16
 * versionCode:　1.0.0
 * path编辑圆角矩形
 */

public class PathView extends View {

    private final Paint paint;

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(101, 101);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        float[] radii = new float[8];
        for (int i = 0; i < 8; i++) {
            radii[i] = 10;
        }
        path.addRoundRect(new RectF(0, 0, 100, 100), radii, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }
}
