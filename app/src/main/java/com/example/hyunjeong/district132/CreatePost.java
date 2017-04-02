package com.example.hyunjeong.district132;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;


public class CreatePost extends AppCompatActivity {
    int id, no_of_rooms;
    String username, location, housetype, facilities, desc;
    double price, size;
    boolean purpose, furnishing;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        final UserSessionManager session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String username = user.get(UserSessionManager.KEY_NAME);
        String password = user.get(UserSessionManager.KEY_PASSWORD);

        session.checkLogin();

    }
    public void newPost(View view) {
        PostDBHandler dbHandler = new PostDBHandler(this, null, null, 1);

        //get data from user

        PostDB Post = new PostDB(id, username, location, housetype, purpose, price, no_of_rooms,
                furnishing, facilities, desc, size);

        dbHandler.addPost(Post);
    }
}

//public PostDB(int post_id, String username, String location, String housetype, boolean purpose, double price,
//int no_of_rooms, boolean furnishing, String facilities, String desc, double size) {

