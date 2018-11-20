package com.teammanagement.adminapp.View.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import com.teammanagement.adminapp.Helper.Util;

public class CurvedBottomNavigationView extends BottomNavigationView {

    private Path mPath;
    private Paint mPaint;

    /** the CURVE_CIRCLE_RADIUS represent the radius of the fab button */
    private int CURVE_CIRCLE_RADIUS;
    // the coordinates of the first curve
    private Point mFirstCurveStartPoint = new Point();
    private Point mFirstCurveEndPoint = new Point();
    private Point mFirstCurveControlPoint1 = new Point();
    private Point mFirstCurveControlPoint2 = new Point();

    //the coordinates of the second curve
    @SuppressWarnings("FieldCanBeLocal")
    private Point mSecondCurveStartPoint = new Point();
    private Point mSecondCurveEndPoint = new Point();
    private Point mSecondCurveControlPoint1 = new Point();
    private Point mSecondCurveControlPoint2 = new Point();

    private int mNavigationBarWidth;
    private int mNavigationBarHeight;

    public CurvedBottomNavigationView(Context context) {
        super(context);
        setCubicCircleRadius(context);
        init();
    }

    public CurvedBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCubicCircleRadius(context);
        init();
    }

    public CurvedBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCubicCircleRadius(context);
        init();
    }

    private void setCubicCircleRadius(Context context) {

    /*    switch (context.getResources().getDisplayMetrics().densityDpi) {

            case DisplayMetrics.DENSITY_LOW:
                CURVE_CIRCLE_RADIUS = 60 / 2;
                *//*+ " ldpi"*//*
                ;
                break;

            case DisplayMetrics.DENSITY_MEDIUM:
                CURVE_CIRCLE_RADIUS = 60 / 2;
                *//*+ " mdpi"*//*
                ;
                break;

            case DisplayMetrics.DENSITY_HIGH:
                CURVE_CIRCLE_RADIUS = 90 / 2;
                *//*+ " hdpi"*//*
                ;
                break;

            case DisplayMetrics.DENSITY_XHIGH:

                CURVE_CIRCLE_RADIUS = 120 / 2;
                *//*+ " xhdpi"*//*
                ;
                break;

            case DisplayMetrics.DENSITY_XXHIGH:

                CURVE_CIRCLE_RADIUS = 180 / 2;
                *//*+ " xxhdpi"*//*
                ;
                break;

            case DisplayMetrics.DENSITY_XXXHIGH:
                CURVE_CIRCLE_RADIUS = 240 / 2;
                *//*+ " xxxhdpi"*//*
                ;
                break;

            default:

        }*/

        CURVE_CIRCLE_RADIUS = (60 * context.getResources().getDisplayMetrics().densityDpi) / 320;

    }

    private void init() {

        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.WHITE);
        setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        mNavigationBarWidth = getWidth();
        mNavigationBarHeight = getHeight();
        // the coordinates (x,y) of the start point before curve
        mFirstCurveStartPoint.set((mNavigationBarWidth / 2) - (CURVE_CIRCLE_RADIUS * 2) - (CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        mFirstCurveEndPoint.set(mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        mSecondCurveStartPoint = mFirstCurveEndPoint;
        mSecondCurveEndPoint.set((mNavigationBarWidth / 2) + (CURVE_CIRCLE_RADIUS * 2) + (CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
        mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);

        mPath.reset();
        mPath.moveTo(0, 0);
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y);

        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);

        mPath.lineTo(mNavigationBarWidth, 0);
        mPath.lineTo(mNavigationBarWidth, mNavigationBarHeight);
        mPath.lineTo(0, mNavigationBarHeight);
        mPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }


}
