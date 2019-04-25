package com.example.dbflowexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dbflow5.config.DBFlowDatabase;
import com.dbflow5.config.FlowManager;
import com.dbflow5.database.SQLiteException;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    public void onSignUpClick(View view) {
        // Retrieve username, password, and repeated password
        String username = ((TextView) findViewById(R.id.etUsername)).getText().toString();
        String password = ((TextView) findViewById(R.id.etPassword)).getText().toString();
        String repeatPassword = ((TextView) findViewById(R.id.etRepeatPassword)).getText().toString();

        if (!password.equals(repeatPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            // Try to create a new user - if an user with same username exists already, SQLiteException will be thrown
            DBFlowDatabase db = FlowManager.getDatabase(AppDatabase.class);
            User newUser = new User(username, password);
            newUser.insert(db);
            Toast.makeText(this, "User created successfully!", Toast.LENGTH_SHORT).show();
            finish();
        }
         catch(SQLiteException e){
            Toast.makeText(this, "Username already taken", Toast.LENGTH_SHORT).show();
            Log.w("FlowManager", e.toString());
        }
    }
}
