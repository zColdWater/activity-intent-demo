package com.example.button.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.button.MainActivity;
import com.example.button.R;

public class IntentActivityTree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_tree);
        getSupportActionBar().setTitle("显式Intent跳转 携带参数 并且 回调参数");

        Button callback = findViewById(R.id.resultbutton);
        callback.setText("回调参数!");
        callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //数据是使用Intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("name", "Henry");
                //设置返回数据
                IntentActivityTree.this.setResult(1, intent);
                //关闭Activity
                IntentActivityTree.this.finish();
            }
        });
    }
}
