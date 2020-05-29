package com.example.birbsquaredics4u2;

import java.util.Random;
import android.util.Log;

public class MathUI
{
    public void randomGenerator()
    {
        Random random = new Random();

        int num1 = random.nextInt(11);
        int num2 = random.nextInt(11);
        Log.d("number1", Integer.toString(num1));
        Log.d("number2", Integer.toString(num2));
    }


}
