package com.example.hyunjeong.district132;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }
    public void displayResults(Cursor posts){

    }

    public void noResultsFound(){

    }
}
