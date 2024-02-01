package com.example.a4lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String email = "user";
    String password = "12345";
    Boolean switchStatus;
    SharedPreferences sharedPref;

    private EditText user_name,user_surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = findViewById(R.id.authorization);

        Switch switch_color = findViewById(R.id.switch_color);

        Button buttonAuthorization = findViewById(R.id.buttonAuthorization);
        EditText editEmail = findViewById(R.id.editTextEmail);
        EditText editPassword = findViewById(R.id.editTextPassword);


        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        switchStatus = sharedPref.getBoolean("switchStatus", false);

        if (switchStatus)
        {
            int green = Color.rgb(40,82,65);
            relativeLayout.setBackgroundColor(green);
        }
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this, "Create", Toast.LENGTH_SHORT).show();

        switch_color.setChecked(switchStatus);
        switch_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int green;
                if (switch_color.isChecked())
                {
                    switchStatus = true;
                    green = Color.rgb(40,82,65);
                    relativeLayout.setBackgroundColor(green);
                }
                else
                {
                    switchStatus = false;
                    green = Color.WHITE;
                    relativeLayout.setBackgroundColor(green);
                }
            }
        });

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

        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
        super.onStart();
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
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean("switchStatus", switchStatus);
        editor.apply();
        Log.i("State", "Destroy");
        Toast.makeText(MainActivity.this, "Destroy", Toast.LENGTH_SHORT).show();

    }
}