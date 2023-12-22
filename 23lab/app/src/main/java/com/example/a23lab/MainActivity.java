package com.example.a23lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String email = "userOne";
    String password = "12345";

    private EditText user_name,user_surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this, "Create", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAuthorization = findViewById(R.id.buttonAuthorization);
        EditText editEmail = findViewById(R.id.editTextEmail);
        EditText editPassword = findViewById(R.id.editTextPassword);

        buttonAuthorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editEmail.getText().toString().equals(email)
                        && editPassword.getText().toString().equals(password))
                {
                    Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                    intent.putExtra("hello", "Hello from FirstActivity");
                    startActivity(intent);

                    intent.putExtra("user", email);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("State", "Destroy");
        Toast.makeText(MainActivity.this, "Destroy", Toast.LENGTH_SHORT).show();

    }
}