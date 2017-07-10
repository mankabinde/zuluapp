package com.example.admin.zuluapp10;

/**
 * Created by Admin on 7/5/2017.
 */

public class Word {

    /**
     * states /data members
     */

    //stores the english translation
    private String mEnglishTranslation;

    //stores the pedi translation
    private String mZuluTranslation;

    //To store the Image ID
    private int mImageResourcedId ;

    //Audio resource ID for
    private int mAudioResourceId;


    /**
     * Constructor
     */

    public Word(String mEnglishTranslation, String mZuluTranslation, int mAudioResourceId, int mImageResourcedId)
    {
        this.mEnglishTranslation = mEnglishTranslation;
        this.mZuluTranslation = mZuluTranslation;
        this.mImageResourcedId = mImageResourcedId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mEnglishTranslation, String mZuluTranslation, int mAudioResourceId )
    {
        this.mEnglishTranslation = mEnglishTranslation;
        this.mZuluTranslation = mZuluTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     * Getters
     */

    //Returns the English Translation of the pedi term
    public String getmEnglishTranslation(){
        return mEnglishTranslation;
    }


    //Returns the Pedi Translation for the english term
    public String getmZuluTranslation(){
        return mZuluTranslation;
    }

    //Returns the image associated with the terms
    public int getmImageResourcedId()
    {
        return mImageResourcedId;
    }

    //Returns the sound associated with the terms
    public int getmAudioResourceId()
    {
        return mAudioResourceId;
    }
}
