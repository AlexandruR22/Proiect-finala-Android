package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;
    Bitmap tubeTop, tubeBottom;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background2);
        background = scaleImage(background);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.bird_frame4);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.tube_bottom);
    }

    // Return Tube-top Bitmap
    public Bitmap getTubeTop(){
        return tubeTop;
    }

    //Return Tube-Bottom Bitmap
    public Bitmap getTubeBottom(){
        return tubeBottom;
    }

    //Return Tube-width
    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    //Return Tube-height
    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    //Return bird bitmap of frame
    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public  int getBirdHeight(){
        return bird[0].getHeight();
    }

    //Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT,false);
    }
}
