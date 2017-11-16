package com.jpinto.a2dslash.characters;

import android.graphics.Bitmap;
import java.util.ArrayList;
import stanford.androidlib.graphics.GSprite;

/*
 * Created by JPinto on 11/9/2017.
 */

public class Knight extends GSprite implements KnightsActions {

    private static final int GRAVITY_ACCELERATION = 1;

    public Knight() {
    }

    @Override
    public void iddle(Bitmap knightIddle){
        this.setVelocityX(0);
        this.setBitmap(knightIddle);
    }

    @Override
    public void walkToRight(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(5);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(true);
    }

    @Override
    public void walkToLeft(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(-5);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(true);
    }

    @Override
    public void attackToRight(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(0);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(false);
    }

    @Override
    public void attackToLeft(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(0);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(false);
    }

    @Override
    public void jumpToRight(ArrayList<Bitmap> bitmap) {

        this.setVelocityX(5);
        this.setVelocityY(-15);
        this.setAccelerationY(GRAVITY_ACCELERATION);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(4);
        this.setLoopBitmaps(true);
    }

    @Override
    public void jumpToLeft(ArrayList<Bitmap> bitmap) {

        this.setVelocityX(-5);
        this.setVelocityY(-15);
        this.setAccelerationY(GRAVITY_ACCELERATION);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(4);
        this.setLoopBitmaps(true);
    }

    @Override
    public void dieToRight(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(0);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(false);
    }

    @Override
    public void dieToLeft(ArrayList<Bitmap> bitmap) {
        this.setVelocityX(0);
        this.setBitmaps(bitmap);
        this.setFramesPerBitmap(2);
        this.setLoopBitmaps(false);
    }
}
