package com.example.miwok;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;


    // IT sets mImageResourceId to negative that if the arraylist send image as
    // argument then its set to their id otherwise it value sets to be negative
    private static final int NO_IMAGE =-1;
    private int mImageResourceId = NO_IMAGE;

    // It sets mAudioResourceId
    private int mAudioResouceId;

    // Constructor taking two value as parameter
    public word(String defaultTranslation,String miwokTranslation,int audioResouceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation =miwokTranslation;
        mAudioResouceId =audioResouceId;
    }
    // Constructor taking three values as parameter
    public word(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioResouceId)
    {
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
        mImageResourceId =imageResourceId;
        mAudioResouceId = audioResouceId;
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
    public int getAudioResouceId(){
        return mAudioResouceId;
    }


    // It checks that ArrayList can contains image or not
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "word{" + "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResouceId=" + mAudioResouceId + '}';
    }
}
