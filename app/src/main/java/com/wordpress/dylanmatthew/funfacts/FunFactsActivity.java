package com.wordpress.dylanmatthew.funfacts;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.wordpress.dylanmatthew.funfacts.FactBook.*;

//Main Activity

public class FunFactsActivity extends ActionBarActivity {


    //Setting up the member variables from the different classes
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    //Declare private TextView, RelativeLayout, and Button variables

    private TextView factLabel;

    private RelativeLayout background;

    private Button randFactBtn;
    private Button nextFactBtn;
    private Button prevFactBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);



        //Setting values to variables


        background = (RelativeLayout) findViewById(R.id.background);
        factLabel = (TextView) findViewById(R.id.ffTextView);
        randFactBtn = (Button) findViewById(R.id.randffBtn);
        nextFactBtn = (Button) findViewById(R.id.nextffBtn);
        prevFactBtn = (Button) findViewById(R.id.prevffBtn);



        //OnClickListeners

        View.OnClickListener randlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Update factLabel with new random fact

                randomFact();           //1st Method

                //Set background and text colors to random color

                changeColor();          //4th Method
            }
        };

        View.OnClickListener nextlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Update factLabel with new next fact

                nextFact();             //2nd Method

                //Set background and text colors to random color

                changeColor();          //4th Method

                //if iterator is at the end of the array (screen displays last fact),
                //display Toast that tells user they have reached the end

                if(mFactBook.i == mFactBook.facts.length-1)
                    Toast.makeText(FunFactsActivity.this, "Patience young Padawan,\nMore facts coming soon!", Toast.LENGTH_LONG).show();
            }
        };


        View.OnClickListener prevlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Update factLabel with new previous fact

                prevFact();             //3rd Method

                //Set background and text colors to random color

                changeColor();          //4th Method

                //if iterator is at the start of the array (screen displays first fact),
                //display Toast that tells user they have reached the start

                if(mFactBook.i == 0)
                    Toast.makeText(FunFactsActivity.this, "Ya can't go back Jack,\nTry next or Random", Toast.LENGTH_LONG).show();
            }
        };


        //Add Listeners to buttons
        randFactBtn.setOnClickListener(randlistener);
        nextFactBtn.setOnClickListener(nextlistener);
        prevFactBtn.setOnClickListener(prevlistener);


    }

    public void randomFact(){   //1st Method


        //Update factLabel with random fact

        String fact = mFactBook.getRandomFact();

        factLabel.setText(fact);


    }


    public void nextFact() {    //2nd Method

        //Update factLabel with next fact

        String fact = mFactBook.getNextFact();

        factLabel.setText(fact);


    }


    public void prevFact() { //3rd Method

        //Update factLabel with previous

        String fact = mFactBook.getPrevFact();

        factLabel.setText(fact);


    }

    public void changeColor() { //4th Method

        //Set background and text colors to random color
        int color = mColorWheel.getRandomColor();
        background.setBackgroundColor(color);

        randFactBtn.setTextColor(color);
        nextFactBtn.setTextColor(color);
        prevFactBtn.setTextColor(color);

    }


}
