package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
//            Toast msg = Toast.makeText(getBaseContext(),"Completed",Toast.LENGTH_SHORT);
//            msg.show();
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        phrases.add(new word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrases.add(new word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        phrases.add(new word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrases.add(new word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        phrases.add(new word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrases.add(new word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrases.add(new word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        phrases.add(new word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        phrases.add(new word("Come here.", "әnni'nem",R.raw.phrase_come_here));

        WordAdapter itemAdapter = new WordAdapter(this,phrases,R.color.category_phrases);
        ListView listView = findViewById(R.id.list_phrases);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word phrasesWord = phrases.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,phrasesWord.getAudioResouceId());
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