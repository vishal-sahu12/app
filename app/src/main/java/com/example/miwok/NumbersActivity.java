package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
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

    // Handles audioFocus when Playing a Sound File
    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListner = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };
    /**
     * This listener gets triggered when the {MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        mAudioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

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
                releaseMediaPlayer();
                word wordss = words.get(i);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListner, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.
                    Log.v("NumbersActivity", "Current Word: " + wordss);

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, wordss.getAudioResouceId());

                    //Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListner);
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



