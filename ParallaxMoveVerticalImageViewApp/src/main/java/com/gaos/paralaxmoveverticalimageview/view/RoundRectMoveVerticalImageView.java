package com.gaos.paralaxmoveverticalimageview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/13 10:36
 * versionCode:　1.0.0
 * 实现的圆角和上下移动。
 */

public class RoundRectMoveVerticalImageView extends ImageView {
    private static final String TAG = RoundRectMoveVerticalImageView.class.getSimpleName();
    private Path path;
    private float cornor_rasius = 20;
    private int newWidth;
    private int newHeight;
    private int newHeightHelf;
    private float downRawY;
    private float moveRawY;
    private int topY;

    public RoundRectMoveVerticalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

      /*clipPath with hardware acceleration is only supported in API level 18 and higher,
      on API levels from 11 to 17 it needs to be turned off.*/
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Rect bounds = getDrawable().copyBounds();
        float scaleFactor = bounds.width() * 1.0f / bounds.height();
        newWidth = MeasureSpec.getSize(widthMeasureSpec);
        newHeight = (int) (newWidth * 1.0f / scaleFactor);
        newHeightHelf = (int) (newHeight / 2.0f);
        setMeasuredDimension(this.newWidth, newHeightHelf);

        setPath();

    }

    private void setPath() {
        path = new Path();
        float[] radii = new float[8];
        for (int i = 0; i < 8; i++) {
            radii[i] = cornor_rasius;
        }
        path.addRoundRect(new RectF(0, 0, newWidth, newHeightHelf), radii, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = drawableToBitmap(getDrawable());
        Bitmap scaledBitmap = bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
        Bitmap newBitmap = Bitmap.createBitmap(scaledBitmap, 0, topY, newWidth, newHeightHelf);
        canvas.clipPath(path);
        canvas.drawBitmap(newBitmap, 0, 0, new Paint());
    }


    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: downRawY = " + event.getRawY());
                downRawY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveRawY = event.getRawY();
                float disY = downRawY - moveRawY + topY;
                downRawY = moveRawY;
                Log.i(TAG, "onTouchEvent: disY = " + disY);
                if (disY > 0 && disY <= newHeightHelf) {
                    topY = (int) disY;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        return true;
    }
}
