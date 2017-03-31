package com.example.hyunjeong.district132;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login extends AppCompatActivity {
    EditText edName, edPass;
    Button bRegister, bSignIn;
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        edName = (EditText) findViewById(R.id.eduserName);
        edPass = (EditText) findViewById(R.id.edpassword);

        bRegister = (Button) findViewById(R.id.bRegister);
        bSignIn = (Button) findViewById(R.id.bSignIn);

        //signin
        bSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = edName.getText().toString();
                String password = edPass.getText().toString();
                String storedPassword = loginDatabaseAdapter.getSinlgeEntry(username);
                if (password.equals(storedPassword)) {
                    Toast.makeText(Login.this, "login Successful", Toast.LENGTH_LONG).show();

                    Intent toSignin = new Intent(Login.this, LoggedIn.class);
                    startActivity(toSignin);
                } else {
                    edPass.setError("Password incorrect");
                    edPass.requestFocus();
                }
            }
        });


        //register
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edName.getText().toString();
                String password = edPass.getText().toString();

                if (username.equals(" ")) {
                    edName.setError("Please enter username");
                    edName.requestFocus();
                    return;
                } else if (password.equals(" ")) {
                    edPass.setError("Please enter password");
                    edPass.requestFocus();
                    return;
                } else {
                    loginDatabaseAdapter.insertEntry(username, password);
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();

                }
            }


        });
    }
}









