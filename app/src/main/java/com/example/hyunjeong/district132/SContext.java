package com.example.hyunjeong.district132;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//Strategy Pattern Context Class
public class SContext {
    private SortPost spost;
    private Context context;
    private Object factory;
    private String name;
    private int version;
    private Cursor c;
    private String loc;
    private String type;
    private  String purpose;



    public SContext(SortPost post){
        this.spost=post;

    }
    public Cursor executeSort(String loc,String type,String purpose){
        Cursor cursor=spost.sort(loc,type,purpose);
        return cursor;
   

    }


}
