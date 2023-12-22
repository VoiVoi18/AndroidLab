package com.example.android;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
public class HelloActivity extends Activity {
    private int count1 = 0;
    private int count2 = 0;
    TextView text1;
    TextView text2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count1++;
                button1.setText("нажато");
                String str1 = Integer.toString(count1);
                text1.setText(str1 + " раз");

            }
        });
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2++;
                button2.setText("тыкнуто");
                String str2 = Integer.toString(count2);
                text2.setText(str2 + " раз");

            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1 = 0;
                count2 = 0;
                String str1 = Integer.toString(count1);
                String str2 = Integer.toString(count2);
                text2.setText(str2 + " раз");
                text1.setText(str1 + " раз");

            }
        });
    }

}
