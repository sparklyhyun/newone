package com.example.hyunjeong.district132;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

/**
 * Created by Jeslyn on 26/3/2017.
 */

public class AccountDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AccountDB.db";
    private static final String TABLE_ACCOUNTS = "Accounts";

    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public AccountDBHandler(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " +
                TABLE_ACCOUNTS + "("
                + COLUMN_USERNAME + " INTEGER PRIMARY KEY," + COLUMN_PASSWORD
                + " TEXT," + ")";
        db.execSQL(CREATE_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        onCreate(db);
    }

    public void addAccount(AccountDB account) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, account.getUsername());
        values.put(COLUMN_PASSWORD, account.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_ACCOUNTS, null, values);
        db.close();
    }

    public boolean findAccount(String username, String password) {
        String query1 = "Select * FROM " + TABLE_ACCOUNTS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor1 = db.rawQuery(query1, null);

        AccountDB account = new AccountDB(username, password);

        if (cursor1.getCount() == 0) {            //username does not exist
            db.close();
            cursor1.close();
            return false;
        } else {                                //username exist
            String query2 = "Select * FROM " + query1 + " WHERE " + COLUMN_PASSWORD + " =  \"" + password + "\"";
            Cursor cursor2 = db.rawQuery(query2, null);
            if (cursor2.getCount() == 0) {       //password is wrong
                db.close();
                cursor1.close();
                cursor2.close();
                return false;
            }  //else password correct, do nothing
            db.close();
            cursor1.close();
            cursor2.close();
            return true;
        }
    }
    public boolean checkExistingAccount(String username, String password) {
        String query1 = "Select * FROM " + TABLE_ACCOUNTS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor1 = db.rawQuery(query1, null);

        AccountDB account = new AccountDB(username, password);

        if (cursor1.getCount() == 0) {            //username does not exist
            addAccount(account);
            db.close();
            cursor1.close();
            return false;
        } else {                                   //username exist
            db.close();
            cursor1.close();
            return true;
        }
    }


    /*public boolean deleteProduct(String productname) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " =  \"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()) {
            product.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(product.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }*/

}
