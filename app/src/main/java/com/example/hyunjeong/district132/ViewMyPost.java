package com.example.hyunjeong.district132;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewMyPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_post);
        final UserSessionManager session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String username = user.get(UserSessionManager.KEY_NAME);
        String password = user.get(UserSessionManager.KEY_PASSWORD);

        session.checkLogin();

        final Intent intent=getIntent();
        String name=intent.getStringExtra("user");

        Toast.makeText(ViewMyPost.this, name, Toast.LENGTH_LONG).show();
        final PostDBHandler db = new PostDBHandler(this, null, null, 1);
        final Cursor cursor = db.getpostbyusername(name);
        if(cursor.getCount()>0){
            Toast.makeText(ViewMyPost.this, "Cursor not empty", Toast.LENGTH_LONG).show();
        }


        if(cursor.moveToFirst()){

            //Toast.makeText(this,str, Toast.LENGTH_LONG).show();
            final ListView list = (ListView) findViewById(R.id.list);
            final PostResultCursorAdapter todoAdapter = new PostResultCursorAdapter(this, cursor);
            list.setAdapter(todoAdapter);

            list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                                @Override
                                                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Displaydetails d;
                                                    String postid = ((TextView) view.findViewById(R.id.postID)).getText().toString();
                                                    db.deletePost(postid);
                                                    return false;
                                                }
                                            });


        }
        cursor.close();

    }
      
}

