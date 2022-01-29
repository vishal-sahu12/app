package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        //ArrayList
        ArrayList<word> words = new ArrayList<word>();

        words.add(new word("One","Lutti",R.drawable.number_one));
        words.add(new word("Two","otiiko",R.drawable.number_two));
        words.add(new word("Three","tolookosu",R.drawable.number_three));
        words.add(new word("Four","oyyisa",R.drawable.number_four));
        words.add(new word("Five","massoka",R.drawable.number_five));
        words.add(new word("Six","temmoka",R.drawable.number_six));
        words.add(new word("Seven","kenekaku",R.drawable.number_seven));
        words.add(new word("Eight","kawinta",R.drawable.number_eight));
        words.add(new word("Nine","wo'e",R.drawable.number_nine));
        words.add(new word("Ten","na'aacha",R.drawable.number_ten
        ));




// Making LinearLayot In Java Code
//        LinearLayout rootView =(LinearLayout) findViewById(R.id.rootview);

        WordAdapter itemAdapter = new WordAdapter(this,words,R.color.category_numbers);
       ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
       //ListView
        // ListView listView =findViewById(R.id.list);
       // listView.setAdapter(itemAdapter);


// For Loops used to iterate and display number on the screen using linearlayout
//        for (int index =0;index<words.size();index++)
//        {
//            TextView wordView = new TextView(this);
//        wordView.setText(words.get(index));
//        rootView.addView(wordView);
//        }


        //Array
//        String [] words = new String[10];
//        words[0]="One";
//        words[1] ="Two";
//        words[2] ="Three";
//        words[3] ="Four";
//        words[4] ="Five";
//        words[5] ="Six";
//        words[6] ="Seven";
//        words[7] ="Eight";
//        words[8] ="Nine";
//        words[9] ="Ten";


// This Is used for display the value in the logcat
//        Log.i("NumberActivity","Words at index 0:"+words.get(0));
//        Log.v("NumberActivity","Words at index 1:"+words.get(1));
//        Log.e("NumberActivity","Words at index 2:"+words.get(2));
//        Log.d("NumberActivity","Words at index 3:"+words.get(3));
//        Log.w("NumberActivity","Words at index 4:"+words.get(4));
//        Log.v("NumberActivity","Words at index 5:"+words.get(5));
//        Log.v("NumberActivity","Words at index 6:"+words.get(6));
//        Log.v("NumberActivity","Words at index 7:"+words.get(7));
//        Log.v("NumberActivity","Words at index 8:"+words.get(8));
//        Log.e("NumberActivity","Words at index 9:"+words.get(9));

    }

}