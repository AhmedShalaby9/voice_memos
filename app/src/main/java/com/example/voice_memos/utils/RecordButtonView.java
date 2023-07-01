package com.example.voice_memos.utils;


import android.content.Context;
 import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RecordButtonView extends View implements View.OnClickListener {
    private Paint mPaint;
    private Bitmap mAvatarBitmap;
    private int mAvatarSize;
    private int mAvatarBorderWidth;
    private int mAvatarBorderColor;
    private int mBackgroundColor;
    private int mCornerRadius;
    private int mBorderWidth;
    private int mBorderColor;

    public RecordButtonView(Context context) {
        super(context);
        init();
    }

    public RecordButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecordButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mAvatarSize = 100;
        mAvatarBorderWidth = 4;
        mAvatarBorderColor = Color.WHITE;
        mBackgroundColor = Color.GRAY;
        mCornerRadius = 0;
        mBorderWidth = 1;
        mBorderColor = Color.WHITE;
        setOnClickListener(this);
    }

    public void setAvatarBitmap(Bitmap avatarBitmap) {
        mAvatarBitmap = avatarBitmap;
        invalidate();
    }

    public void setAvatarSize(int avatarSize) {
        mAvatarSize = avatarSize;
        requestLayout();
        invalidate();
    }

    public void setAvatarBorderWidth(int avatarBorderWidth) {
        mAvatarBorderWidth = avatarBorderWidth;
        invalidate();
    }

    public void setAvatarBorderColor(int avatarBorderColor) {
        mAvatarBorderColor = avatarBorderColor;
        invalidate();
    }

    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        invalidate();
    }

    public void setCornerRadius(int cornerRadius) {
        mCornerRadius = cornerRadius;
        invalidate();
    }

    public void setBorderWidth(int borderWidth) {
        mBorderWidth = borderWidth;
        invalidate();
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // Set the size of the view to be the size of the avatar
        int size = Math.min(mAvatarSize, Math.min(getMeasuredWidth(), getMeasuredHeight()));
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Calculate the radius of the circle
        float radius = getWidth() / 2f;

        // Draw the background
        mPaint.setColor(mBackgroundColor);
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), mCornerRadius, mCornerRadius, mPaint);

        // Draw the border
        mPaint.setColor(mBorderColor);
        mPaint.setStrokeWidth(mBorderWidth);
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), mCornerRadius, mCornerRadius, mPaint);

        // Draw the avatar image
        if (mAvatarBitmap != null) {
            // Draw a circle around the avatar
            mPaint.setColor(mAvatarBorderColor);
            mPaint.setStrokeWidth(mAvatarBorderWidth);
            canvas.drawCircle(radius, radius, radius - mAvatarBorderWidth / 2f, mPaint);

            // Draw the avatar image
            RectF rect = new RectF(mAvatarBorderWidth, mAvatarBorderWidth, getWidth() - mAvatarBorderWidth, getHeight() - mAvatarBorderWidth);
            canvas.drawBitmap(mAvatarBitmap, null, rect, null);
        }
    }

    @Override
    public void onClick(View v) {
        // Handle the click event here
        // For example, launch a new activity or show a dialog box
    }
}