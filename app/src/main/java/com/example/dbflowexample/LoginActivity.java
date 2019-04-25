package com.example.dbflowexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view) {
        // Retrieve username and password from UI
        String username = ((TextView) findViewById(R.id.etUsername)).getText().toString();
        String password = ((TextView) findViewById(R.id.etPassword)).getText().toString();

        User user = User.getByUsernameAndPassword(username, password);
        if (user == null) {
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
            return;
        }

        // If user exists, show a toast and go back to current activity
        Toast.makeText(this, "Logged in succesfully!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
