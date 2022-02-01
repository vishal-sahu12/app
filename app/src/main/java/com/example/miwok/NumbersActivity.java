package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new word("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new word("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        words.add(new word("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        words.add(new word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new word("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        words.add(new word("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        words.add(new word("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("nine", "wo’e", R.drawable.number_nine,R.raw.number_nine));
        words.add(new word("ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word wordss = words.get(i);
                Log.v("NumbersActivity","Current Word: " +wordss);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,wordss.getAudioResouceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

//public class NumbersActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.words_list);
//        //ArrayList
//        ArrayList<word> words = new ArrayList<word>();
//
//        words.add(new word("One","Lutti",R.drawable.number_one));
//        words.add(new word("Two","otiiko",R.drawable.number_two));
//        words.add(new word("Three","tolookosu",R.drawable.number_three));
//        words.add(new word("Four","oyyisa",R.drawable.number_four));
//        words.add(new word("Five","massoka",R.drawable.number_five));
//        words.add(new word("Six","temmoka",R.drawable.number_six));
//        words.add(new word("Seven","kenekaku",R.drawable.number_seven));
//        words.add(new word("Eight","kawinta",R.drawable.number_eight));
//        words.add(new word("Nine","wo'e",R.drawable.number_nine));
//        words.add(new word("Ten","na'aacha",R.drawable.number_ten
//        ));
//
//
//
//
//// Making LinearLayot In Java Code
////        LinearLayout rootView =(LinearLayout) findViewById(R.id.rootview);
//
//        WordAdapter itemAdapter = new WordAdapter(this,words,R.color.category_numbers);
//       ListView listView = findViewById(R.id.list);
//        listView.setAdapter(itemAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast mes = Toast.makeText(NumbersActivity.this,"playing",Toast.LENGTH_SHORT);
//                mes.show();
//            }
//        });
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



