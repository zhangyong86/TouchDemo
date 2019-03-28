package com.example.sidashidai.touchdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by zhangyong on 2018/12/12.
 */

public class MyTextView extends TextView {

    //clickable设置为true即可消费onTouchEvent事件-return true

    private static final String TAG = "Touch";

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.e(TAG, "MyTextView dispatchTouchEvent: " + event.getAction() + "  " + super.dispatchTouchEvent(event));
//        return super.dispatchTouchEvent(event);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(TAG, "MyTextView onTouchEvent: " + event.getAction() + "  " + super.onTouchEvent(event));
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
//        Log.e(TAG, "MyTextView onTouchEvent: " + event.getAction() + "  " + super.onTouchEvent(event));
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyTextView onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "MyTextView onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyTextView onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyTextView dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "MyTextView dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyTextView dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

}
