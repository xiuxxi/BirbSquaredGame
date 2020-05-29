package com.example.birbsquaredics4u2;

import android.os.Bundle;
import android.app.Activity;

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


}