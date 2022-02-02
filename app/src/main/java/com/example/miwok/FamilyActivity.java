package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListner = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            }
            }
    };

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
        setContentView(R.layout.activity_family);
        mAudioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<word> familyMemeber = new ArrayList<>();
        familyMemeber.add(new word("Father", "әpә",R.drawable.family_father,R.raw.family_father));
        familyMemeber.add(new word("Mother", "әta",R.drawable.family_mother,R.raw.family_mother));
        familyMemeber.add(new word("Son", "angsi",R.drawable.family_son,R.raw.family_son));
        familyMemeber.add(new word("Daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        familyMemeber.add(new word("Older Brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        familyMemeber.add(new word("Younger Brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        familyMemeber.add(new word("Older Sister", "tete",R.drawable.family_older_sister,R.raw.family_older_sister));
        familyMemeber.add(new word("Younger Sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        familyMemeber.add(new word("Grand Mother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        familyMemeber.add(new word("Grand Father", "pappa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemAdapter = new WordAdapter(this,familyMemeber,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list_family);

//        Button playButton = findViewById(R.id.play_button);
//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer music = MediaPlayer.create(getApplicationContext(),R.raw.family_mother);
//                music.start();
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                word wordss = familyMemeber.get(i);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListner,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                Log.v("FamilyActivity","Current Word"+ wordss);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,wordss.getAudioResouceId());
                    // Start the audio file
                mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }}
        });
        listView.setAdapter(itemAdapter);
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
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListner);
        }
    }
}