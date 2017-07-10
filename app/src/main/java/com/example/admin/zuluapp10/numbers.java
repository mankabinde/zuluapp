package com.example.admin.zuluapp10;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class numbers extends AppCompatActivity {
    //Handles playback of all sound files
    MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_list);

        //Creating an arrayList of type Word
        final ArrayList<Word> words = new ArrayList<>();

        //english ,zulu,audio,pic
        words.add(new Word("one","kunye",R.raw.kunye, R.drawable.number1));
        words.add(new Word("two","kubili",R.raw.kubili,R.drawable.number2));
        words.add(new Word("three","kuthathu",R.raw.kuthathu,R.drawable.number3));
        words.add(new Word("four","kune",R.raw.kune,R.drawable.number4));
        words.add(new Word("five","kuhlanu",R.raw.kuhlanu,R.drawable.number5));
        words.add(new Word("six","isthupha",R.raw.isthupha,R.drawable.number6));
        words.add(new Word("seven","kune",R.raw.kune,R.drawable.number7));
        words.add(new Word("eight","isishiyagalombili",R.raw.lombili,R.drawable.number8));
        words.add(new Word("nine","isishiyagalolunye",R.raw.lolunye,R.drawable.number9));
        words.add(new Word("ten","yishumi",R.raw.yishumi,R.drawable.number10));


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
                    mMediaPlayer = MediaPlayer.create(numbers.this, word.getmAudioResourceId());

                    //Start the audio file
                    mMediaPlayer.start();

                } else {
                    Toast.makeText(numbers.this, "no voice note", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

