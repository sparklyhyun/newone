package com.example.hyunjeong.district132;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }

    public void displayResults(Cursor posts){
        // Find ListView to populate
        ListView lvItems = (ListView) findViewById(R.id.postID);

        // Setup cursor adapter using cursor from last step
        PostResultCursorAdapter todoAdapter = new PostResultCursorAdapter(this, posts);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(todoAdapter);
    }

    public void noResultsFound(){
        TextView noResultsView = (TextView) findViewById(R.id.noResults);
        noResultsView.setText("No Reults Found");
    }
}
