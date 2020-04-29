package com.example.birbsquaredics4u2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.view.View.OnClickListener;

public class GameUI extends View{

    Bitmap bitmap;
    float changingY;

    public GameUI(Context context)
    {
        super(context);
        Resources res = context.getResources();

        bitmap = BitmapFactory.decodeResource(res, R.drawable.test_image_2);
        changingY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Log.d("afterScreenTap", Float.toString(changingY));
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, (canvas.getWidth()/2), changingY, null);

        if (changingY < canvas.getHeight())
        {
            changingY +=10;
        }
        else
        {
            changingY = 0;
        }
        Log.d("changingY", Float.toString(changingY));
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Log.d("screenTapped", "true");
        changingY += -200;

        return super.onTouchEvent(event);
    }

    /*Paint paint = new Paint();
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.test_image_2);

        bitmap = Bitmap.createBitmap(bitmap);

        Canvas canvas = new Canvas(bitmap.copy(Bitmap.Config.ARGB_8888, true));
        canvas.drawBitmap(bitmap, 0f, 0f, null);*/

}
