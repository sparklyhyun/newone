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
}
