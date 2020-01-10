package com.example.imechatron;

public class ItemMycourses {
    private int mImageResource2;
    private String mText3;
    private String mText4;

    public ItemMycourses (int imageResource, String text3, String text4){
        mImageResource2 =imageResource;
        mText3 = text3;
        mText4 = text4;
    }

    public int getImageResource2(){
        return  mImageResource2;
    }

    public String getText3(){
        return mText3;
    }

    public String getText4(){
        return mText4;
    }

}
