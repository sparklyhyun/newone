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
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login extends AppCompatActivity {
    AccountDBHandler accHandler = new AccountDBHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edName = (EditText) findViewById(R.id.eduserName);
        final EditText edPass = (EditText) findViewById(R.id.edpassword);

        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final Button bSignIn = (Button) findViewById(R.id.bSignIn);

        //signin
        bSignIn.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           if (accHandler.findAccount(edName.getText().toString(), edPass.getText().toString())) {
                                               //if account exists and the password matches, true
                                               //link to other page
                                               Intent toLoggedIn = new Intent(Login.this, LoggedIn.class);
                                               startActivity(toLoggedIn);
                                           } else {
                                               if (edPass.getText().toString() == null) {
                                                   edPass.setError("Please enter password");
                                               } else if (edName.getText().toString() == null) {
                                                   edName.setError("Please enter username");
                                               } else {
                                                   edPass.setError("Password wrong, please re-enter");
                                               }
                                           }
                                       }
                                   }
        );


        //register
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUserName(edName.getText().toString())) {
                    edName.setError("Invalid Username: The username must be of at least 6 characters and less than 16 characters");
                    edName.requestFocus();
                } else if (accHandler.checkExistingAccount(edName.getText().toString(), edPass.getText().toString())) {
                    edName.setError("Usename already exists");
                    edName.requestFocus();
                } else if (!validatePass(edPass.getText().toString())) {
                    edPass.setError("Invalid Password:The password must be greater than 8 characters long and less than 16 characters, and should include at least 1 numerical digit.");
                    edPass.requestFocus();
                } else {
                    AccountDB acc = new AccountDB(edName.getText().toString(), edPass.getText().toString());
                    accHandler.addAccount(acc);
                    Toast.makeText(Login.this, "Registration Success", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    protected boolean validatePass(String password) {

        if (password != null && password.length() > 7 && password.length() < 17 && password.matches(".*\\d+.*")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean validateUserName(String userName) {
        if (userName != null && userName.length() > 5 && userName.length() < 17) {
            return true;
        } else {
            return false;
        }
    }

}












