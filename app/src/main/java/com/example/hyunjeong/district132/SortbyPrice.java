package com.example.hyunjeong.district132;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.widget.TextView;

//Concrete class which implements the interface SortPost (Strategy Pattern)
public class SortbyPrice extends SQLiteOpenHelper implements SortPost{

 
    Context context;
    private Object factory;
    private Cursor cursor;

    public SortbyPrice(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //retrieves database entries according to chosen location,housetype and purpose and orders them by price.
    public Cursor sort(String location,String housetype,String purpose){
        String query = "Select " + COLUMN_POST_ID+ " AS _id,* FROM "  + TABLE_POSTS +
                " WHERE " + COLUMN_LOCATION + " = \"" + location + "\"" +
                " AND " + COLUMN_HOUSETYPE + " = \"" + housetype + "\"" +
                " AND " + COLUMN_PURPOSE + " = \"" + purpose + "\"" + " ORDER BY " + COLUMN_PRICE;
     
        SQLiteDatabase db = this.getWritableDatabase();
        
        Cursor cursor = db.rawQuery(query, null);
      
        return cursor;
    }

}
