package com.example.miwok;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;


    // IT sets mImageResourceId to negative that if the arraylist send image as
    // argument then its set to their id otherwise it value sets to be negative
    private static final int NO_IMAGE =-1;
    private int mImageResourceId = NO_IMAGE;

    // Constructor taking two value as parameter
    public word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation =miwokTranslation;
    }
    // Constructor taking three values as parameter
    public word(String defaultTranslation,String miwokTranslation,int imageResourceId)
    {
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
        mImageResourceId =imageResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }


    // It checks that ArrayList can contains image or not
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE;
    }
}
