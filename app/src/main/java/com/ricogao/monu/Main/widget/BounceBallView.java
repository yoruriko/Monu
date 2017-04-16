package com.ricogao.monu.Main.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.ricogao.monu.R;

/**
 * Created by ricogao on 04/05/2016.
 */
public class BounceBallView extends View {

    private final static String TAG = BounceBallView.class.getSimpleName();

    private final int colors[] = {ContextCompat.getColor(getContext(), R.color.background_light),
            ContextCompat.getColor(getContext(), R.color.background_color),
            ContextCompat.getColor(getContext(), R.color.background_dark),
            ContextCompat.getColor(getContext(), R.color.background_color)};

    private Path mPath;
    private Path textPath;
    private Paint curvePaint;
    private Paint textPaint;

    private float blackMagic = 0.551915024494f;
    private float mInterpolatedTime;
    private float radius = 50;
    private static final float MAX_STRETCH = 30;

    private int height;
    private int centreX;
    private int maxLength;

    private VPoint p1, p3;
    private HPoint p2, p4;

    private Rect textRect;
    private String text = getResources().getString(R.string.searching);

    private PointF textP1, textP2, textControl;

    private boolean isAnimating;

    private boolean skip;

    private int index;

    public BounceBallView(Context context) {
        this(context, null);
    }

    public BounceBallView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BounceBallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private class VPoint {
        float x, y;
        PointF left = new PointF();
        PointF right = new PointF();

        void setY(float y) {
            this.y = y;
            left.y = y;
            right.y = y;
        }

        void setX(float x, float offset) {
            this.x = x;
            left.x = x - offset;
            right.x = x + offset;
        }


    }

    private class HPoint {
        float x, y;
        PointF top = new PointF();
        PointF bottom = new PointF();

        void setX(float x) {
            this.x = x;
            top.x = x;
            bottom.x = x;
        }

        void setY(float y, float offset) {
            this.y = y;
            top.y = y - offset;
            bottom.y = y + offset;
        }
    }

    private class MoveAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            mInterpolatedTime = interpolatedTime;
            invalidate();
        }
    }

    private void init() {
        curvePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        curvePaint.setStrokeWidth(2);
        curvePaint.setColor(colors[0]);
        curvePaint.setDither(true);
        curvePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(ContextCompat.getColor(getContext(), R.color.font_light));
        textPaint.setTextSize(40);

        mPath = new Path();
        textPath = new Path();

        p1 = new VPoint();
        p2 = new HPoint();
        p3 = new VPoint();
        p4 = new HPoint();
        textP1 = new PointF();
        textP2 = new PointF();
        textControl = new PointF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = getHeight();
        centreX = getWidth() / 2;
        maxLength = Math.round(height - (2 * radius) - 100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (textRect == null) {
            textRect = new Rect();
            textPaint.getTextBounds(text, 0, text.length(), textRect);
        }

        if (mInterpolatedTime <= 0.8) {
            state1(mInterpolatedTime);
        } else {
            state2(mInterpolatedTime);
        }
        drawCurve(canvas);
        drawText(canvas);
    }

    private void state1(float time) {// Between 0.0~0.8  Interpolate Time
        float controlOffset = blackMagic * radius;
        float yOffset = maxLength * time / 0.8f;

        p1.setY(2 * radius + yOffset);
        p1.setX(centreX, controlOffset);

        p2.setX(centreX + radius);
        p2.setY(radius + yOffset, controlOffset);

        p3.setY(yOffset);
        p3.setX(centreX, controlOffset);

        p4.setX((centreX - radius));
        p4.setY(radius + yOffset, controlOffset);

        bounceText(0);
    }

    private void state2(float time) {// Between 0.8~1.0 Interpolate Time
        float hControlOffset = (1.8f - time) * blackMagic * radius;
        float vControlOffset = (0.2f + time) * blackMagic * radius;

        float dY = MAX_STRETCH * (time - 0.8f) / 0.2f;
        float dX = dY * 0.5f;

        p1.setY(maxLength + 2 * radius + dY);
        p1.setX(centreX, vControlOffset);

        p2.setX(centreX + radius + dX);
        p2.setY(maxLength + radius + dX + dY, hControlOffset);

        p3.setY(maxLength + 2 * dY);
        p3.setX(centreX, vControlOffset);

        p4.setX(centreX - radius - dX);
        p4.setY(maxLength + radius + dX + dY, hControlOffset);

        bounceText(dY);
    }

    public void bounceText(float dY) {// Between 0.8~1.0 Interpolate Time
        float xOffset = textRect.width() * 0.5f;
        float yOffset = height - 100 + textRect.height();

        textP1.x = centreX - xOffset;
        textP1.y = yOffset;

        textP2.x = centreX + xOffset;
        textP2.y = yOffset;

        textControl.x = centreX;
        textControl.y = yOffset + dY;

    }

    protected void drawCurve(Canvas canvas) {
        mPath.reset();

        mPath.moveTo(p1.x, p1.y);

        mPath.cubicTo(p1.right.x, p1.right.y, p2.bottom.x, p2.bottom.y, p2.x, p2.y);
        mPath.cubicTo(p2.top.x, p2.top.y, p3.right.x, p3.right.y, p3.x, p3.y);
        mPath.cubicTo(p3.left.x, p3.left.y, p4.top.x, p4.top.y, p4.x, p4.y);
        mPath.cubicTo(p4.bottom.x, p4.bottom.y, p1.left.x, p1.left.y, p1.x, p1.y);

        canvas.drawPath(mPath, curvePaint);
    }

    protected void drawText(Canvas canvas) {
        textPath.reset();
        textPath.moveTo(textP1.x, textP1.y);
        textPath.quadTo(textControl.x, textControl.y, textP2.x, textP2.y);

        canvas.drawTextOnPath(text, textPath, 0, 0, textPaint);
    }

    private void switchColor() {
        if (skip) {
            skip = false;
            return;
        }

        skip = true;
        index++;
        index = index % 4;
        curvePaint.setColor(colors[index]);
    }


    public void startAnim() {
        isAnimating = true;

        mInterpolatedTime = 0;
        MoveAnimation move = new MoveAnimation();
        move.setDuration(1000);
        move.setInterpolator(new AccelerateInterpolator());
        move.setRepeatCount(Animation.INFINITE);
        move.setRepeatMode(Animation.REVERSE);
        move.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                skip = false;
                index = 0;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                switchColor();
            }
        });
        startAnimation(move);
        Log.i(TAG, "Move Animation onStart()");
    }


    public void stopAnim() {
        isAnimating = false;

        clearAnimation();
        Log.i(TAG, "Move Animation onStop()");
    }

    public boolean isAnimating() {
        return isAnimating;
    }

}

