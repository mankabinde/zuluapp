package com.example.admin.zuluapp10;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class family extends Activity {
    //Handles playback of all sound files
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_list);

        //Creating an arrayList of type Word
        final ArrayList<Word> words = new ArrayList<>();

        //english ,zulu,audio,pic
        words.add(new Word("father", "Ubaba", R.raw.ubaba, R.drawable.father));
        words.add(new Word("mother", "umama", R.raw.mama, R.drawable.mother));
        words.add(new Word("daugter", "indodakazi", R.raw.girly, R.drawable.daughter));
        words.add(new Word("son", "indodana", R.raw.indodana, R.drawable.son));
        words.add(new Word("uncle", "umalume", R.raw.malume, R.drawable.uncle));
        words.add(new Word("aunty", "umalumekazi", R.raw.umalumekazi, R.drawable.aunty));
        words.add(new Word("grandmother","ugogo",R.raw.ugogo,R.drawable.grandmother));
        words.add(new Word("grandfather","umkhulu",R.raw.mkhulu,R.drawable.grndfather));


        //Referencing the ListView of Greetings activity
        ListView listView = (ListView) findViewById(R.id.color_list);

        //Calling the constructor of the Adapter class
        WordAdapter itemsAdapter = new WordAdapter(this, words); //family_category

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
                    mMediaPlayer = MediaPlayer.create(family.this, word.getmAudioResourceId());

                    //Start the audio file
                    mMediaPlayer.start();

                } else {
                    Toast.makeText(family.this, "no voice note", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}







