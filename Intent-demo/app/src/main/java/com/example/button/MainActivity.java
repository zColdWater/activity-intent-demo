package com.example.button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.button.Activitys.IntentActivityFour;
import com.example.button.Activitys.IntentActivityOne;
import com.example.button.Activitys.IntentActivityTree;
import com.example.button.Activitys.IntentActivityTwo;
import com.example.button.Models.Staff;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("ACTIVITY INTENT DEMO");

        // 显式Intent跳转
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,IntentActivityOne.class);
                startActivity(intent);
            }
        });

        // 显式Intent跳转 携带参数
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentActivityTwo.class);
                intent.putExtra("name","henry");
                startActivity(intent);
            }
        });

        // 显式Intent跳转 携带参数 并且 回调参数
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentActivityTree.class);
                intent.putExtra("name","henry");
                startActivityForResult(intent,1);
            }
        });

        // 显式Intent跳转 携带Model数据结构参数
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Staff staff = new Staff();
                staff.setName("Henry");
                Intent intent = new Intent(MainActivity.this, IntentActivityFour.class);
                intent.putExtra("staff",staff);
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 携带Action
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Activity 标签的 IntentFliter 除了添加指定的Action还必须要有Category默认的Default值
                Intent intent = new Intent("action_intent_activity");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 携带Action+Category
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Activity 标签的 IntentFliter 除了添加指定的Action还必须要有Category默认的Default值
                Intent intent = new Intent("action_intent_activity1");
                // add的Category(android.intent.custom) 不是必须参数,即使没有添加这个类别也是可以跳转的。
                intent.addCategory("android.intent.custom");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 使用Data模式
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //创建一个隐式的 Intent 对象，方法四：Date 数据
                Intent intent = new Intent();
                Uri uri = Uri.parse("content://com.example.intentdemo：8080/abc.pdf");
                //注：setData、setDataAndType、setType 这三种方法只能单独使用，不可共用
                //单独以 setData 方法设置 URI
                //intent.setData(uri);
                //单独以 seType 方法设置 Type
                //intent.setType("text/plain");
                //上面分步骤设置是错误的，要么以 setDataAndType 方法设置 URI 及 mime type
                intent.setDataAndType(uri, "text/plain");
                startActivity(intent);
            }
        });


        // 隐式Intent跳转 系统应用 浏览器网页
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //web浏览器
                Uri uri= Uri.parse("http://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 地图
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //打开地图查看经纬度
                Uri uri = Uri.parse("geo:38.899533,-77.036476");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用电话拨号（不需要拨号权限）
        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:10086");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);//注意区别于下面4.4的action
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用电话直接拨号（需要拨号权限）
        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:15980665805");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);//注意区别于上面4.3的aciton
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用短信程序（无需发送短信权限，接收者自填）
        Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body", "这里写短信内容");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用短信程序（无需发送短信权限）
        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:10086");//指定接收者
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "你这个黑心运营商");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用邮件程序
        Button button14 = findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:xxx@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
                intent.putExtra(Intent.EXTRA_TEXT, "这是内容");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用音乐播放器
        Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Uri uri = Uri.parse("file:///sdcard/xiong_it.mp4");
                Uri uri = Uri.parse("file:///sdcard/xiong_it.mp3");
                intent.setDataAndType(uri, "audio/mp3");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用视频播放器
        Button button16 = findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Uri uri = Uri.parse("file:///sdcard/xiong_it.mp3");
                Uri uri = Uri.parse("file:///sdcard/xiong_it.mp4");
                intent.setDataAndType(uri, "video/mp4");
                startActivity(intent);
            }
        });

        // 隐式Intent跳转 系统应用 调用搜索
        Button button17 = findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "android");
                startActivity(intent);
            }
        });
    }

    // 接收其他Intent的回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Activity","onActivityResult");
        switch (resultCode) {
            case 1:
                Toast.makeText(this, String.format("接收到回调参数:%s",data.getStringExtra("name")), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
