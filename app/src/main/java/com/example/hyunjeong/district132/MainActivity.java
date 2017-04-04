package com.example.hyunjeong.district132;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String loc;
    String hse;
    boolean sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UserSessionManager session = new UserSessionManager(getApplicationContext());

        final Button signInButton = (Button) findViewById(R.id.SignIn);
        final Button searchButton = (Button) findViewById(R.id.Search);
        signInButton.setOnClickListener(this);

        final Spinner location = (Spinner) findViewById(R.id.Location);
        final Spinner hseType = (Spinner) findViewById(R.id.Type);
        final Spinner saleLease = (Spinner) findViewById(R.id.SaleLease);

        loc = location.getSelectedItem().toString();
        hse = hseType.getSelectedItem().toString();

        String slease = saleLease.getSelectedItem().toString();

        if (slease == "Sale")
            sl = true;
        else if (slease == "Lease")
            sl = false;

        /*searchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toSearchResults = new Intent(MainActivity.this, SearchResults.class);
                toSearchResults.putExtra("location", loc);
                toSearchResults.putExtra("housetype", hse);
                toSearchResults.putExtra("purpose", sl);
                startActivity(toSearchResults);
            }
        });*/

        if(session.checkLoginMain()){
            Intent alrLoggedIn = new Intent(MainActivity.this, LoggedIn.class);
            startActivity(alrLoggedIn);
        }
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