package com.jpinto.a2dslash.characters;

/*
 * Created by JPinto on 11/9/2017.
 */

import android.graphics.Bitmap;

import java.util.ArrayList;

public interface KnightsActions {


    void iddle(Bitmap bitmap);
    void walkToRight(ArrayList<Bitmap> bitmap);
    void walkToLeft(ArrayList<Bitmap> bitmap);
    void attackToRight(ArrayList<Bitmap> bitmap);
    void attackToLeft(ArrayList<Bitmap> bitmap);
    void jumpToRight(ArrayList<Bitmap> bitmap);
    void jumpToLeft(ArrayList<Bitmap> bitmap);
    void dieToRight(ArrayList<Bitmap> bitmap);
    void dieToLeft(ArrayList<Bitmap> bitmap);
}
