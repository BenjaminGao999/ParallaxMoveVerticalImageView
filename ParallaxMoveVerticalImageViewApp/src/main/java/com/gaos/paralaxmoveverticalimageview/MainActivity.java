package com.gaos.paralaxmoveverticalimageview;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.gaos.paralaxmoveverticalimageview.view.WidthMatchParentImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        resetImageViewSize();
    }


    private void resetImageViewSize() {
        WidthMatchParentImageView matchParentImageView = (WidthMatchParentImageView) findViewById(R.id.wmpiv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) matchParentImageView.getLayoutParams();
        int width = (int) (getResources().getDisplayMetrics().widthPixels - 2 * getResources().getDimension(R.dimen.activity_horizontal_margin));
        layoutParams.width = width;
        int intrinsicWidth = matchParentImageView.getDrawable().getIntrinsicWidth();
        int intrinsicHeight = matchParentImageView.getDrawable().getIntrinsicHeight();
        Log.i(TAG, "resetImageViewSize: intrinsicWidth = " + intrinsicWidth);
        Log.i(TAG, "resetImageViewSize: intrisicHeight = " + intrinsicHeight);
        float scaleFractor = intrinsicWidth * 1.0f / intrinsicHeight;
        int newHeight = (int) (width / scaleFractor);
        layoutParams.height = newHeight;
        matchParentImageView.setLayoutParams(layoutParams);
    }

}
