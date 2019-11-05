package com.bomnie.ex026activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //이 SecondActivity를 실행시켜준 Intent를 소환하기
        Intent intent= getIntent();

        String str= intent.getStringExtra("Name");
        int age= intent.getIntExtra("Age", 0);

        tv= findViewById(R.id.tv);
        tv.setText(str +" , "+ age);

    }
}
