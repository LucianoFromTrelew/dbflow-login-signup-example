package com.example.dbflowexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginClick(View view) {
        Intent loginIntent = new Intent(
                this,
                LoginActivity.class
        );
        startActivity(loginIntent);
    }

    public void onSignUpClick(View view) {
        Intent signUpIntent = new Intent(
                this,
                SignUpActivity.class
        );
        startActivity(signUpIntent);
    }
}
