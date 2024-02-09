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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
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
                List<User> userList = db.getAllUsers();
                User currentUser;
                boolean access = false;
                for (User usr : userList) {
                    String log = "Id: "+usr.getID()+" ,Login: " + usr.getLogin() + " ,Password: " + usr.getPass();
                    Log.v("Loading...", log);
                }

                for (int i = 0; i < userList.size(); i++)
                {
                   currentUser = userList.get(i);
                    if (editEmail.getText().toString().equals(currentUser.getLogin())
                         && editPassword.getText().toString().equals(currentUser.getPass())){
                        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                        intent.putExtra("account", currentUser.getID());
                        finish();
                        startActivity(intent);
                        access = true;
                    }
                }
                if (!access)
                {
                    Toast.makeText(MainActivity.this, "Неверный пароль или логин", Toast.LENGTH_SHORT).show();
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