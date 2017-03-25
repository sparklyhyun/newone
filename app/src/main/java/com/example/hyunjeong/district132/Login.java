package com.example.hyunjeong.district132;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edName = (EditText) findViewById(R.id.eduserName);
        final EditText edPass = (EditText) findViewById(R.id.edpassword);

        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final Button bSignIn = (Button) findViewById(R.id.bSignIn);

        bSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toLoggedIn = new Intent(Login.this, LoggedIn.class);
                startActivity(toLoggedIn);
            }
                                   }
        );


        /*
        bRegister.setOnClickListener(new View.OnClickListener(){
                String name = edName.getText().toString();
                String pass = edPass.getText().toString();

                //this is register part
                boolean hasUppercase = !pass.equals(pass.toLowerCase());
                boolean hasNumber = false;

                if(pass.matches(".*\\d.*")){
                    hasNumber = true;}

                if(name.matches("")){
                    edName.setError("You need to enter the user name");}
                else if(name.length()<6){
                    edName.setError("The username must be more at least 6 letters");
                }
                else{
                   //db request here?
                }

                if(pass.matches("")){
                    edPass.setError("You need to enter password");
                }
                else if(!hasUppercase && !hasNumber &&(pass.length()<8 || pass.length()>16)){
                    edPass.setError("Password should have at least 1 uppercase letter,1 numerical number, and it should be between 8 and 16 characters");
                }
                else{
                    //db request here?

                }
                    return;
                }

            */
            }

/*
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bSignIn: {
                Intent intent = new Intent(getApplicationContext(), LoggedIn.class);
                startActivity(intent);
                break;
            }
        }
    }
    */

        }













