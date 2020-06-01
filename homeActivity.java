package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class homeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
ImageButton button = (ImageButton) findViewById(R.id.startgame);
button.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
openstartgame();
    }



        });

    }public void openstartgame(){
        Intent intent= new Intent(this, startgame.class);
        startActivity(intent);
    }

}


