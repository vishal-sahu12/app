package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView number,family,colors,phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Here In this NumberClickListner class implements OnClickListener interface is created in
        NumberClickListner file. And We Override the Onclick Method..
        *

        NumberClickListner clickListner = new NumberClickListner(); // object of  NumberClickListner class
        number =(TextView) findViewById(R.id.numbers);
        number.setOnClickListener(clickListner);
        */
        // For Numbers
        number = (TextView) findViewById(R.id.numbers);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(getBaseContext(),NumbersActivity.class);
                startActivity(numberIntent);
            }
        });
        // For FAMILY
        family =(TextView) findViewById(R.id.family);

        // Creating OnClickListner In the MainActivity Class
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(getBaseContext(),FamilyActivity.class);
                startActivity(numberIntent);
            }
        });
        // For COLORS
        colors =(TextView) findViewById(R.id.colors);

        // Creating OnClickListner In the MainActivity Class
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(getBaseContext(),ColorsActivity.class);
                startActivity(numberIntent);
            }
        });
        // For PHRASES
        phrases =(TextView) findViewById(R.id.phrases);

        // Creating OnClickListner In the MainActivity Class
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(getBaseContext(),PhrasesActivity.class);
                startActivity(numberIntent);
            }
        });
    }
//    public void numberlist(View view){
//        Intent number = new Intent(this,NumbersActivity.class);
//        startActivity(number);
//    }
}