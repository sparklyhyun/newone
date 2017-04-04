/*package com.example.hyunjeong.district132;

/*import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;*/

/*public class SearchResults extends AppCompatActivity {

    String location;
    String housetype;
    boolean purpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        if (null != intent) {
            location = intent.getStringExtra("location");
            housetype = intent.getStringExtra("housetype");
            purpose = intent.getBooleanExtra("purpose", false);
        }
        searchResults(location, housetype, purpose);
    }

    public void searchResults(String location, String housetype, Boolean purpose) {
        PostDBHandler dbHandler = new PostDBHandler(this, null, null, 1);

        Cursor posts = dbHandler.searchPost(location, housetype, purpose);

        if (!(posts.moveToFirst()) || posts.getCount() == 0)
            noResultsFound();
        else
            displayResults(posts);
    }

    public void displayResults(Cursor posts){
        // Find ListView to populate
        //ListView lvItems = (ListView) findViewById(R.id.postID);

        // Setup cursor adapter using cursor from last step
       // PostResultCursorAdapter todoAdapter = new PostResultCursorAdapter(this, posts);

        // Attach cursor adapter to the ListView
       // lvItems.setAdapter(todoAdapter);
    }

    public void noResultsFound(){
        TextView noResultsView = (TextView) findViewById(R.id.noResults);
        noResultsView.setText("No Reults Found");
    }
}*/
