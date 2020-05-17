package com.example.birbsquaredics4u2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.graphics.Rect;
import java.util.HashMap;
import android.view.Display;
import android.util.TypedValue;

public class GameUI extends View {

    Bitmap bitmap;
    Bitmap pipeTop;
    Bitmap pipeMid;
    Bitmap pipeBot;

    Rect topRectOne;
    Rect topRectTwo;
    Rect birdRect;
    Rect midRect;
    Rect botRectOne;
    Rect botRectTwo;
    float changingY;
    float changingX;
    int i;
    boolean checkTap = false;
    boolean checkState = false;
    int height;
    int actionBar;
    int navigationBarHeight;
    int trueHeight;
    int gap = 77;
    int pipeOneHeight;

    //create bitmaps, Rects, and bird
    public GameUI(Context context)
    {


        super(context);
        Resources res = context.getResources();

        //create bitmaps
        bitmap = BitmapFactory.decodeResource(res, R.drawable.test_image_2);


        pipeTop = BitmapFactory.decodeResource(res, R.drawable.pipe_top);
        pipeTop = Bitmap.createScaledBitmap(pipeTop, 350, 450, false);


        pipeMid = BitmapFactory.decodeResource(res, R.drawable.pipe_middle);
        pipeMid = Bitmap.createScaledBitmap(pipeMid, 210, 200, false);

        pipeBot = BitmapFactory.decodeResource(res, R.drawable.pipe_bottom);
        pipeBot = Bitmap.createScaledBitmap(pipeBot, 350, 450, false);



        //get actual height of phone
        height = Resources.getSystem().getDisplayMetrics().heightPixels;
        actionBar = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        navigationBarHeight = getResources().getDimensionPixelSize(actionBar);
        Log.d("actionBar", Integer.toString(navigationBarHeight));
        trueHeight = height - navigationBarHeight;
        changingY = 0;
        changingX = 1000;
        i = 0;
        pipeOneHeight = trueHeight/4 - gap/2;
        //left top right bottom

        Log.d("trueHeight", Integer.toString(trueHeight/3));
    }

    //onDraw method that loops
    @Override
    protected void onDraw(Canvas canvas)
    {

        //topRectOne - topmost rectangle
        /*topRectOne = new Rect((int)changingX + 104, 0, (int)changingX + 246, pipeOneHeight);
        topRectTwo = new Rect((int)changingX + 68, pipeOneHeight, (int)changingX + 282, pipeOneHeight+gap);
        midRect = new Rect((int)changingX + 70, trueHeight/2 - gap/2, (int)changingX + 280, trueHeight/2 + gap + gap/2);
        botRectOne = new Rect((int)changingX + 68, )
        Log.d("pipeOneHeight", Integer.toString(pipeOneHeight));*/

        //draw pipes
        topRectOne = new Rect((int)changingX + 68, 373, (int)changingX + 282, 450);
        topRectTwo = new Rect((int)changingX + 104, 0, (int)changingX + 246, 373);
        birdRect = new Rect((int)getWidth()/2 + 5, (int)changingY, (int)getWidth()/2 + 69, (int)changingY + 69);
        midRect = new Rect((int)changingX + 70, 771, (int)(changingX + 280), 933);
        botRectOne = new Rect((int)changingX + 68, 1252, (int)changingX + 282, 1329);
        botRectTwo = new Rect((int)changingX + 104, 1329, (int)changingX + 246, 1710);

        //if true, collision happened
        if (checkState)
        {
            System.exit(0);
        }
        //if tapped, animate bird jump
        if (checkTap)
        {
            float temp = changingY;
            while (changingY > (temp - 130))
            {
                Log.d("changingY", Float.toString(changingY));
                canvas.drawBitmap(bitmap, (getWidth()/2), changingY, null);
                changingY -= 10;
                //checkState = checkState(topRect, birdRect, midRect, botRect, changingY);

                if (checkState)
                {

                    System.exit(0);
                }
            }
            checkTap = false;
        }

        Log.d("pipeHeight", Integer.toString((getHeight()/2) - 850));

        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, (getWidth()/2), changingY, null);
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);

        canvas.drawRect(birdRect, paint);
        canvas.drawRect(topRectOne, paint);
        canvas.drawRect(topRectTwo, paint);
        canvas.drawRect(midRect, paint);
        canvas.drawRect(botRectOne, paint);
        canvas.drawRect(botRectTwo, paint);

        canvas.drawBitmap(pipeTop, changingX, (float)(getHeight()/2 - 850), null);
        canvas.drawBitmap(pipeMid, changingX + 70, (float)(getHeight()/2) - 100, null);
        canvas.drawBitmap(pipeBot, changingX, (float)(getHeight()/2) + 400, null);

        if (changingY < trueHeight)
        {
            changingY +=10;
        }
        else
        {
            changingY = 0;
        }

        if (changingX > -500)
        {
            changingX -=10;
        }
        else
        {
            changingX = 1000;
        }

        checkState = checkState(topRectOne, topRectTwo, midRect, botRectOne, botRectTwo, birdRect, changingY, trueHeight);
        if (changingX == 460.0)
        {
            i++;
            Log.d("score3", Integer.toString(i));
        }
        invalidate();
    }

    //onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        checkTap = true;

        return super.onTouchEvent(event);
    }

    public boolean checkState(Rect topRectOne, Rect topRectTwo, Rect midRect, Rect botRectOne, Rect botRectTwo, Rect birdRect, float changingY, int trueHeight)
    {
        Log.d("trueheight1", Integer.toString(trueHeight));
        //if block touches the bottom, return true
        if (changingY == trueHeight - 2)
        {
            return true;
        }

        //if the block touches any pipes, return true
        if (Rect.intersects(topRectOne, birdRect))
        {
            return true;
        }
        else if (Rect.intersects(topRectTwo, birdRect))
        {
            return true;
        }
        else if (Rect.intersects(midRect, birdRect))
        {
            return true;
        }
        else if (Rect.intersects(botRectOne, birdRect))
        {
            return true;
        }
        else if (Rect.intersects(botRectTwo, birdRect))
        {
            return true;
        }


        return false;
    }

}
