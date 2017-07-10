package com.example.admin.zuluapp10;

/**
 * Created by Admin on 7/5/2017.
 */

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class colours extends AppCompatActivity {

    //Handles playback of all sound files
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_list);

        //Creating an arrayList of type Word
        final ArrayList<Word> words = new ArrayList<>();

        //english ,zulu,audio,pic
        words.add(new Word("Green","luhlaza",R.raw.kuhlaza, R.drawable.green));
        words.add(new Word("Red","obomvu",R.raw.obomvu,R.drawable.red));
        words.add(new Word("White","omhlophe",R.raw.omhlophe,R.drawable.white));
        words.add(new Word("Black","omnyama",R.raw.omnyama,R.drawable.black));
        words.add(new Word("Brown","onsundu",R.raw.onsundu,R.drawable.brown));
        words.add(new Word("Yellow","ophuzi",R.raw.ophuzi,R.drawable.yellow));


        //Referencing the ListView of Greetings activity
        ListView listView = (ListView) findViewById(R.id.color_list);

        //Calling the constructor of the Adapter class
        WordAdapter itemsAdapter = new WordAdapter(this, words ); //family_category

        //The adapter add the content of the ArrayList data into the
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //Getting the index number of word clicked in the View
                Word word = words.get(position);

                // validate if a term doesn't have a not voice
                if (word.getmAudioResourceId() > 0) {
                    //Create and setup the MediaPlayer for the audio resource associate with the current  word object
                    mMediaPlayer = MediaPlayer.create(colours.this, word.getmAudioResourceId());

                    //Start the audio file
                    mMediaPlayer.start();

                } else {
                    Toast.makeText(colours.this, "no voice note", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
