package com.example.hyunjeong.district132;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Spinner;
import android.content.Context;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class SearchResults extends AppCompatActivity {

    String location;
    String type;
    String purpose;
   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        final String[] stringArray = intent.getStringArrayExtra("array");


        location = stringArray[0];
        type = stringArray[1];
        purpose = stringArray[2];
      

        final Intent intent1;

        intent1 = new Intent(SearchResults.this, ImplementSPattern.class);
        String[] array = {location, type, purpose};
        intent1.putExtra("array", array);

        Button spricebtn = (Button) findViewById(R.id.button);
        Button ssizebtn = (Button) findViewById(R.id.button2);

        spricebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String s = "Sort by price";
                intent1.putExtra("sort", s);
                String[] array1 = {location, type, purpose};
                intent1.putExtra("array1", array1);
                startActivity(intent1);
            }

        });
        ssizebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String s = "Sort by size";
                intent1.putExtra("sort", s);
                startActivity(intent1);
            }

        });


        PostDBHandler dbHandler = new PostDBHandler(this, null, null, 1);

        Cursor posts = dbHandler.searchPost(location, type, purpose);

        // Find ListView to populate
        final ListView list = (ListView) findViewById(R.id.list);

        // Setup cursor adapter using cursor from last step
        final PostResultCursorAdapter todoAdapter = new PostResultCursorAdapter(this, posts);


        list.setAdapter(todoAdapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()

        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Displaydetails d;
                String postid = ((TextView) view.findViewById(R.id.postID)).getText().toString();
                Intent intent = new Intent(SearchResults.this, Displaydetails.class);
                intent.putExtra("id",postid);
                startActivity(intent);
                return false;

            }
        });
    }
}
