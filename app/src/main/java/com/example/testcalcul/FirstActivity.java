package com.example.testcalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    TextView textView;
    String resultOfOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView = findViewById(R.id.txt);

        Intent intent = getIntent();
        if (intent != null) {
            resultOfOperation = intent.getStringExtra("key");
            if (resultOfOperation != null) {
                textView.setText(resultOfOperation);
            } else {


            }
        }
    }
        public void onClickOpenCalc (View view){
            Intent intent2 = new Intent(FirstActivity.this, MainActivity.class);
            startActivity(intent2);
        }

}