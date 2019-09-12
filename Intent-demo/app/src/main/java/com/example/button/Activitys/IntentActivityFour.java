package com.example.button.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.button.Models.Staff;
import com.example.button.R;

public class IntentActivityFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_four);
        getSupportActionBar().setTitle("显式Intent跳转 携带Model数据结构参数");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Staff staff = (Staff)bundle.getSerializable("staff");
        Toast.makeText(this, String.format("staff name:%s",staff.name), Toast.LENGTH_SHORT).show();
    }
}
