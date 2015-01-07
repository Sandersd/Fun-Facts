package com.wordpress.dylanmatthew.funfacts;


import android.graphics.Color;

import java.util.Random;

//Class used to change background and text color by getting a random color from an array

public class ColorWheel {

    //Set up colors array

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };


    //Prepares return variable

    String color = "";

    public int getRandomColor() {       //Returns an int so we can use setBackgroundColor(int color)


        //Randomly select a Color

        Random randomGen = new Random();  //Construct new Random number Generator

        int randomNum = randomGen.nextInt(mColors.length);


        //Select random fact from facts array

        color = mColors[randomNum];

        //Changes string value to int representing color

        int colorInt = Color.parseColor(color);

        return colorInt;

    }


}
