package com.example.birbsquaredics4u2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import android.view.ViewPropertyAnimator;
import android.animation.ObjectAnimator;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.PathInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.graphics.Path;
import android.view.SurfaceHolder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;

import android.view.animation.AnimationUtils;

import android.graphics.Color;
import android.graphics.PorterDuff;

import android.view.SurfaceView;

import android.view.Display;
import android.graphics.Point;

import android.graphics.Paint;

import android.content.res.Resources;

import android.content.Context;
public class MainActivity extends Activity {

    GameUI ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourView = new GameUI(this);
        setContentView(ourView);




        //Drawable test = getResources().getDrawable(R.drawable.test_image, null);
        //test.setBounds(10, 10, 10, 10);
        //test.draw(canvas);



    }


    public void pathTest(View view)
    {

    }

    public void testAnimation(View view)
    {

        //surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        //surfaceHolder = surfaceView.getHolder();





        //Animation testAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_anim);
        //view.startAnimation(testAnimation);

                //bottomOfScreen is where you want to animate to

        //view.animate().translationY(bottomOfScreen).setDuration(5000);
    }


    public void screenTapped(View view) {

        testAnimation(null);
    }

}


//ImageView testImage = findViewById(R.id.imageView);


        /*ImageView testImage2 = findViewById(R.id.imageView2);
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(testImage, "translationX", -1500f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(testImage2, "translationX", -1500f);
        animation1.setDuration(12000);
        animation2.setDuration(12000);
        animation1.start();
        animation2.start();
        animation1.setRepeatCount(Animation.INFINITE);
        animation2.setRepeatCount(Animation.INFINITE);*/