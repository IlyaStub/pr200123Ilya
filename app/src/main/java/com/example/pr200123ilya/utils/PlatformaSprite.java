package com.example.pr200123ilya.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PlatformaSprite extends Sprite{
    private static final float HEIGHT = 60f;
    private static final float WIDTH = 220f;
    private static final Paint PAINT = new Paint();

    @Override
    public void onTouch(float x, float y, int screenHeight, int screenWidth) {
        if(x<WIDTH/2){
            this.x = WIDTH/2;
        } else if (x>=screenWidth-WIDTH/2) {
            this.x = screenWidth - WIDTH /2;
        } else {
            this.x = x;
        }
    }

    static {
        PAINT.setStyle(Paint.Style.FILL);
        PAINT.setColor(Color.BLUE);
    }
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(x-WIDTH/2
                ,y-HEIGHT/2
                ,x+WIDTH/2
                ,y+HEIGHT/2
                ,PAINT);
    }

    @Override
    public void init(int height, int width) {
        x = width / 2f;
        y = height - 70;
    }
}
