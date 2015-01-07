package com.wordpress.dylanmatthew.funfacts;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;


//Class used to change fact by getting a random fact from an array
// or by cycling through with Next and Previous


public class FactBook {



    //Set up facts array

   public String[] facts= {
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built." };


    //Set up iterator

    public static int i = 0;


    String fact = "";

    public String getRandomFact() {


        //Randomly select a fact

        Random randomGen = new Random();  //Construct new Random number Generator

        int randomNum = randomGen.nextInt(facts.length);

        i = randomNum;


        //Select random fact from facts array

        fact = facts[randomNum];


        return fact;

    }

    public String getNextFact() {

        //Returns next fact in the array

        if(i<facts.length-1){       //Checks to see if iterator is at the end of array

            i++;

            fact = facts[i];        //Increment i and sets fact to next String in array

        }
        else
        {                           //If iterator is at the end, returns last (current) fact

            return facts[i];

        }

        return fact;

    }

    public String getPrevFact() {

        //Returns previous fact in the array

        if(i>0){                //Checks to see if iterator is at the start of array

            i--;

            fact = facts[i];    //Decrement i and sets fact to previous String in array

        }
        else
        {

            return facts[i];    //If iterator is at the start, returns first (current) fact
        }

        return fact;

    }
}
