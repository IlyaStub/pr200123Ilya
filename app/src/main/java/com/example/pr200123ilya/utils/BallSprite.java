package com.example.pr200123ilya.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BallSprite extends Sprite {
    private static final float RADIUS = 25f;
    private static final Paint PAINT = new Paint();

    static {
        PAINT.setStyle(Paint.Style.FILL);
        PAINT.setColor(Color.RED);
    }

    private float vx, vy;

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, RADIUS, PAINT);
    }

    @Override
    public void init(int height, int width) {
        x = width / 2f;
        y = height -132;
        vx =5.5f;
        vy = -5.5f;
    }

    @Override
    public void update(int screenHeight, int screenWidth) {
        super.update(screenHeight, screenWidth);
        x += vx;
        y += vy;
        if(x<= RADIUS || x >= screenHeight - RADIUS) vx=-vx;
        if(y<= RADIUS || y >= screenHeight - RADIUS) vy=-vy;
    }

    @Override
    public void onTouch(float x, float y, int screenHeight, int screenWidth) {
        super.onTouch(x, y, screenHeight, screenWidth);
    }

    @Override
    public void checkBoundaryCollision() {
        super.checkBoundaryCollision();
    }

    @Override
    public void checkCollision(Sprite sprite) {
        super.checkCollision(sprite);
    }
}
