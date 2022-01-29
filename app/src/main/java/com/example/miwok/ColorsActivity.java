package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<word> colors = new ArrayList<>();
       colors .add(new word("Red", "Weṭeṭṭi",R.drawable.color_red));
       colors.add(new word("Green", "Chokokki",R.drawable.color_green));
        colors.add(new word("Brown", "Takaakki",R.drawable.color_brown));
        colors.add(new word("Gray", "Topoppi",R.drawable.color_gray));
        colors.add(new word("Black", "Kululli",R.drawable.color_black));
        colors.add(new word("White", "Kelelli",R.drawable.color_white));
        colors.add(new word("Dusty Yellow", "Topiisә",R.drawable.color_dusty_yellow));
        colors.add(new word("Mustard Yellow", "Chiwiiṭә",R.drawable.color_mustard_yellow));


        WordAdapter itemAdapter = new WordAdapter(this,colors,R.color.category_colors);
        ListView listView = findViewById(R.id.list_colors);
        listView.setAdapter(itemAdapter);
    }
}