package com.example.sidashidai.touchdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by zhangyong on 2018/12/12.
 */

public class MyViewGroup extends LinearLayout {

    private static final String TAG = "Touch";

    public MyViewGroup(Context context) {
        super(context);
    }

    //自定义view必须添加
    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    //一般不重写dispatchTouchEvent
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TAG, "MyViewGroup dispatchTouchEvent: " + ev.getAction() + "  " + super.dispatchTouchEvent(ev));
        int action = ev.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MyViewGroup dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "MyViewGroup dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MyViewGroup dispatchTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.i(TAG, "MyViewGroup onTouchEvent: " + event.getAction() + "  " + super.onTouchEvent(event));
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MyViewGroup onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "MyViewGroup onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MyViewGroup onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.i(TAG, "MyViewGroup onInterceptTouchEvent: " + ev.getAction() + "  " + super.onInterceptTouchEvent(ev));
        int action = ev.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MyViewGroup onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "MyViewGroup onInterceptTouchEvent ACTION_MOVE");
                return true;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MyViewGroup onInterceptTouchEvent ACTION_UP");
                return true;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
//        return true;
    }


}
