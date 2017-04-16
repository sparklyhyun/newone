package com.example.hyunjeong.district132;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String loc;
    String hse;
    String sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UserSessionManager session = new UserSessionManager(getApplicationContext());

        final Button signInButton = (Button) findViewById(R.id.SignIn);
        final Button searchButton = (Button) findViewById(R.id.Search);
        signInButton.setOnClickListener(this);

        if(session.checkLoginMain()){
            Intent alrLoggedIn = new Intent(MainActivity.this, LoggedIn.class);
            startActivity(alrLoggedIn);
        }
    }

    public void search(View view) {
        // collect user input to search for post

        final Spinner location = (Spinner) findViewById(R.id.Location);
        final Spinner hseType = (Spinner) findViewById(R.id.Type);
        final Spinner saleLease = (Spinner) findViewById(R.id.SaleLease);
        loc = location.getSelectedItem().toString();
        hse = hseType.getSelectedItem().toString();
        sl = saleLease.getSelectedItem().toString();

        String[] values = new String[3];
        values[0]=loc;
        values[1]=hse;
        values[2]=sl;

        Intent intent = new Intent(this, SearchResults.class);
        intent.putExtra("array", values);
        startActivity(intent);
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
}
