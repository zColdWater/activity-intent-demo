package com.example.button.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.button.R;

public class IntentActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_two);
        getSupportActionBar().setTitle("Intent 显式Intent跳转 携带参数");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (null != bundle) {
            String name = bundle.getString("name");
            Toast.makeText(this, String.format("Name is %s",name), Toast.LENGTH_SHORT).show();
        }
    }
}
