package com.example.admin.zuluapp10;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class phrases extends Activity {
    //Handles playback of all sound files
    MediaPlayer mMediaPlayer;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.color_list);

            //Creating an arrayList of type Word
            final ArrayList<Word> words = new ArrayList<>();

            //english ,zulu,audio,pic
            words.add(new Word("my child's name is amahle", "igama lomtwana wami nguAmahle", R.raw.amahle,R.drawable.phrases));
            words.add(new Word("children are eating", "izingane ziyadla", R.raw.eating,R.drawable.phrases));
            words.add(new Word("my surname is ntombela", "isibongo sami uNtombela", R.raw.ntombela,R.drawable.phrases));
            words.add(new Word("how are you feeling", "uzizwa unjani", R.raw.uzizwa,R.drawable.phrases));
            words.add(new Word("where are you going?", "ulibangisephi", R.raw.uyaphi,R.drawable.phrases));
            words.add(new Word("my grandmother is sick", "ugogo wami uyagula", R.raw.sickgogo,R.drawable.phrases));
            words.add(new Word("the pastor is preaching","umfundisi uyashumayela",R.raw.umfundisi,R.drawable.phrases));
            words.add(new Word("my mother is going to work","umama uya emsebenzini",R.raw.mamawork,R.drawable.phrases));
            words.add(new Word("todays date is 03 january 2017","namuhla umhlaka 03 masingane 2017",R.raw.masingane,R.drawable.phrases));


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
                        mMediaPlayer = MediaPlayer.create(phrases.this, word.getmAudioResourceId());

                        //Start the audio file
                        mMediaPlayer.start();

                    } else {
                        Toast.makeText(phrases.this, "no voice note", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }










