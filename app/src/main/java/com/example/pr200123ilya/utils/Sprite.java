package com.example.pr200123ilya.utils;

import android.graphics.Canvas;

public abstract class Sprite {

    public float x, y;

    public abstract void onDraw(Canvas canvas);
    public abstract void init(int height, int width);

    public void update(int screenHeight, int screenWidth) {}
    public void onTouch(float x, float y, int screenHeight, int screenWidth){}
    
    public void checkBoundaryCollision() {}

    public void checkCollision(Sprite sprite) {
    }
}
