package com.example.pr200123ilya;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.pr200123ilya.utils.BallSprite;
import com.example.pr200123ilya.utils.PlatformaSprite;
import com.example.pr200123ilya.utils.Sprite;

public class GameView extends View {
    public GameView(Context context) {
        super(context);
    }

    private boolean isInit = false;
    private Sprite[] sprites = new Sprite[]{new BallSprite(), new PlatformaSprite()};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isInit) {
            isInit = true;
            for (Sprite sprite : sprites) {
                sprite.init(getHeight(), getWidth());
            }
        }
        for (Sprite sprite : sprites) {
            sprite.onDraw(canvas);
            sprite.update(getHeight(), getWidth());
        }
        for (Sprite sprite : sprites) {
            sprite.checkBoundaryCollision();
        }
        sprites[0].checkCollision(sprites[1]);

        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                for (Sprite sprite : sprites)
                    sprite.onTouch(event.getX()
                            , event.getY()
                            , getHeight()
                            , getWidth());
        }
        invalidate();
        return true;
    }
}
