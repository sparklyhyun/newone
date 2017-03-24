package com.example.hyunjeong.district132;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LoggedIn extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        final TextView welcomeMsg = (TextView) findViewById(R.id.welcome);
        final EditText edName = (EditText) findViewById(R.id.eduserName);

        final Button bcreateNewPost = (Button) findViewById(R.id.bcreateNewPost);
        final Button bviewMyPost = (Button) findViewById(R.id.bViewPost);
        final Button searchButton = (Button) findViewById(R.id.Search);

        final Spinner location = (Spinner) findViewById(R.id.Location);
        final Spinner hseType = (Spinner) findViewById(R.id.Type);
        final Spinner saleLease = (Spinner) findViewById(R.id.SaleLease);

        String loc = location.getSelectedItem().toString();
        String hse = hseType.getSelectedItem().toString();
        String slease = saleLease.getSelectedItem().toString();

        bcreateNewPost.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignIn: {
                Intent intent = new Intent(getApplicationContext(), CreatePost.class);
                startActivity(intent);
                break;
            }
        }
    }
}
