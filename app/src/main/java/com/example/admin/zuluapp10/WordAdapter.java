package com.example.admin.zuluapp10;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 7/5/2017.
 */


public class WordAdapter extends ArrayAdapter<Word> {


    //Resource ID for the background color for this list words
    private int mColorResourceId;

    //the WordAdapter takes the contex ,ArrayList of type Word and the layout color of each class
    public WordAdapter(Context context, ArrayList<Word> words ) {
        super(context, 0, words);
        this.mColorResourceId = mColorResourceId;
    }

    //This method is called when the List view is trying display a list of items in a given position
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        //Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.number_list,parent,false);
            //to inflate means to create a new list layout  from the xml resource
        }

        //Get the current position of the item in the  ArrayAdapter
        Word getPosition = getItem(position);

        //Find the TextView in the number_list.xml for pedi
        TextView pedi_text_view = (TextView)listItemView.findViewById(R.id.pedi_text_view);

        //Getting the name of the item selected in the listView
        //on a given position
        pedi_text_view.setText(getPosition.getmZuluTranslation());


        //Referencing the TextView for the english Term
        //Find the TextView in number_list.xml for the english translated term
        TextView english_text_view = (TextView) listItemView.findViewById(R.id.english_text_view);

        //Getting the name of the item selected in the listView
        //on a given position
        english_text_view.setText(getPosition.getmEnglishTranslation());


        //referencing the  image
        ImageView image = (ImageView)listItemView.findViewById(R.id.image);

        //Getting the image from the number_list.xml
        image.setImageResource(getPosition.getmImageResourcedId());

        //Referecing the View name number_list.xml
        View  textContainer = listItemView.findViewById(R.id.text_container);

        //Storing the catergory color
     // int catergory_color = ContextCompat.getColor(getContext(),mColorResourceId);

      //Setting category set
  //  textContainer.setBackgroundColor(catergory_color);

        //Return the whole Number_list.xml layout (contain 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
