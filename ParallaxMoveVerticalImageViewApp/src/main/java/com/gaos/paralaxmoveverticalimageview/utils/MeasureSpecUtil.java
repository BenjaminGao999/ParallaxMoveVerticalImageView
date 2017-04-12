package com.gaos.paralaxmoveverticalimageview.utils;

import android.util.Log;
import android.view.View;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/12 17:09
 * versionCode:　1.0.0
 * 打印MeasureSpec信息工具
 */

public class MeasureSpecUtil {

    /**
     * 打印MeasureSpec信息
     *
     * @param widthMeasureSpec
     * @param logName
     * @param heightMeasureSpec
     */
    public static void measureSpecInfo(int widthMeasureSpec, int heightMeasureSpec, String logName) {
        switch (View.MeasureSpec.getMode(widthMeasureSpec)) {
            case View.MeasureSpec.AT_MOST:
                Log.i(logName, "measureSpecInfo:widthMeasureSpec  mode = MeasureSpec.AT_MOST");
                break;
            case View.MeasureSpec.UNSPECIFIED:
                Log.i(logName, "measureSpecInfo:widthMeasureSpec  mode = MeasureSpec.UNSPECIFIED");
                break;
            case View.MeasureSpec.EXACTLY:
                Log.i(logName, "measureSpecInfo:widthMeasureSpec  mode = MeasureSpec.EXACTLY");
                break;
            default:
                break;
        }
        Log.i(logName, "measureSpecInfo: widthMeasureSpec size = " + View.MeasureSpec.getSize(widthMeasureSpec));

        switch (View.MeasureSpec.getMode(heightMeasureSpec)) {
            case View.MeasureSpec.AT_MOST:
                Log.i(logName, "measureSpecInfo:heightMeasureSpec  mode = MeasureSpec.AT_MOST");
                break;
            case View.MeasureSpec.UNSPECIFIED:
                Log.i(logName, "measureSpecInfo:heightMeasureSpec  mode = MeasureSpec.UNSPECIFIED");
                break;
            case View.MeasureSpec.EXACTLY:
                Log.i(logName, "measureSpecInfo:heightMeasureSpec  mode = MeasureSpec.EXACTLY");
                break;
            default:
                break;
        }
        Log.i(logName, "measureSpecInfo: heightMeasureSpec size = " + View.MeasureSpec.getSize(heightMeasureSpec));
    }
}
