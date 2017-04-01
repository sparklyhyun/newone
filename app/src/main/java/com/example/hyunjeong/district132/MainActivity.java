package com.example.hyunjeong.district132;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Spinner;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String loc;
    String hse;
    Boolean sl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button signInButton = (Button) findViewById(R.id.SignIn);
        final Button searchButton = (Button) findViewById(R.id.Search);
        signInButton.setOnClickListener(this);

        searchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Spinner location = (Spinner) findViewById(R.id.Location);
                final Spinner hseType = (Spinner) findViewById(R.id.Type);
                final Spinner saleLease = (Spinner) findViewById(R.id.SaleLease);

                String loc = location.getSelectedItem().toString();
                String hse = hseType.getSelectedItem().toString();
                String slease = saleLease.getSelectedItem().toString();

                if (slease == "Sale")
                    sl = true;
                else if (slease == "Lease")
                    sl = false;

                //searchResults(View view); // ???

                //move to search results activity
                //Intent toSearchResults = new Intent(MainActivity.this, SearchResults.class);
                //startActivity(toSearchResults);
            }

        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignIn: {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                break;
            }
        }
    }

    public void searchResults(View view) {
        PostDBHandler dbHandler = new PostDBHandler(this, null, null, 1);

        Cursor posts = dbHandler.searchPost(loc, hse, sl);

        SearchResults results = new SearchResults();

        if (posts != null)
            results.displayResults(posts);
        else
            results.noResultsFound();
    }
}