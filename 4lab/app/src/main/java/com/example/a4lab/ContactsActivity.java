package com.example.a4lab;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactsActivity extends Activity {
    int index = 0;
    SharedPreferences sharedPreferences;
    ArrayList<String> myStringArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        for (int i = 0; i < sharedPreferences.getInt("size", 0); i++) {
            myStringArray.add(sharedPreferences.getString("text" + i, "" + i));
        }
        Bundle arguments = getIntent().getExtras();
        String hello = arguments.get("hello").toString();
        Toast.makeText(ContactsActivity.this, hello, Toast.LENGTH_SHORT).show();
        Bundle getEmail = getIntent().getExtras();
        String user = getEmail.get("user").toString();
        myStringArray.add(user);

        Button delete = findViewById(R.id.DeleteButton);
        Button add = findViewById(R.id.AddButton);;

        ArrayAdapter<String> TextAdapter =
                new ArrayAdapter(this, android.R.layout.simple_list_item_1, myStringArray);
        ListView textList = findViewById(R.id.textList);

        textList.setAdapter(TextAdapter);
        EditText editText = findViewById(R.id.EditText);
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }

        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myStringArray.isEmpty())
                {
                    myStringArray.remove(index);
                }
                index = 0;

                TextAdapter.notifyDataSetChanged();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStringArray.add(editText.getText().toString());
                editText.setText("");
                TextAdapter.notifyDataSetChanged();
            }
        });

    }
    @Override
    protected void onDestroy() {
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < myStringArray.size(); i++)
        {
            editor.putString("text" + i, myStringArray.get(i).toString());
            Log.i("Add", myStringArray.get(i).toString());
            editor.apply();
        }
        editor.putInt("size", myStringArray.size());
        Log.i("size", String.valueOf(myStringArray.size()));
        editor.apply();

        super.onDestroy();
    }
}