package com.example.a23lab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ContactsActivity extends Activity {
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Bundle arguments = getIntent().getExtras();
        String str = arguments.get("hello").toString();
        Toast.makeText(ContactsActivity.this, str, Toast.LENGTH_SHORT).show();
        Bundle getEmail = getIntent().getExtras();
        String user = getEmail.get("user").toString();

        Button delete = findViewById(R.id.DeleteButton);
        Button add = findViewById(R.id.AddButton);;


        ArrayList<String> myStringArray = new ArrayList<String>();
        myStringArray.add(user);
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
}