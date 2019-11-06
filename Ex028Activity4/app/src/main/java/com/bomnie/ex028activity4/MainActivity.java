package com.bomnie.ex028activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {

        //묵시적(implicit) Intent를 통해 SecondActivity 실행

        Intent intent = new Intent();
        intent.setAction("abc"); // abc 라는 action 을 intent 에 부여
        startActivity(intent); // 폰의 모든 프로그램에 보내 'abc'는

//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

    }
}
