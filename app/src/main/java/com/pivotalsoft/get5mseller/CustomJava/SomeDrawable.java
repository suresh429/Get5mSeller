package com.pivotalsoft.get5mseller.CustomJava;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by Gangadhar on 10/25/2017.
 */

public class SomeDrawable extends GradientDrawable {

    public SomeDrawable(int pStartColor, int pCenterColor, int pEndColor, int pStrokeWidth, int pStrokeColor, float cornerRadius) {
        super(Orientation.BOTTOM_TOP, new int[]{pStartColor, pCenterColor, pEndColor});
        setStroke(pStrokeWidth, pStrokeColor);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }
}
