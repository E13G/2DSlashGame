package com.jpinto.a2dslash.Data;

/*
 * Created by JPinto on 11/29/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;

import com.jpinto.a2dslash.R;

import java.util.ArrayList;
import java.util.List;

import stanford.androidlib.SimpleBitmap;

public class DataAssets {

    private Context context;
    private float knightHeight;

    public DataAssets(Context context, float knightHeight ) {
        this.context      = context;
        this.knightHeight = knightHeight;
    }

    private final List<Bitmap> inverseArcherDying = new ArrayList<Bitmap>(){{
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_0, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_1, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_2, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_3, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_4, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_5, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_6, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_7, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_8, knightHeight));
        add(SimpleBitmap.with(context)
                .scaleToHeight(R.drawable.archer_iv_die_9, knightHeight));

    }};


}
