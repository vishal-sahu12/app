package com.example.miwok;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation =miwokTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
