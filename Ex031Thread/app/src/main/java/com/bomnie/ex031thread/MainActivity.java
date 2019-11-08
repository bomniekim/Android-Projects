package com.bomnie.ex031thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //오래걸리는 작업(ex. Network... file IO...)
        //별도의 Thread를 사용하지 않았으므로 Main Thread가 처리함
        for(int i=0; i<20; i++){

            num++;
            tv.setText(num+"");

            //0.5초간 대기
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for
    }//clickBtn method

    public void clickBtn2(View view) {
        //오래 걸리는 작업을 수행하는 직원 객체 생성 (MyThread) 및 실행
        MyThread t = new MyThread();
        t.start();  //자동으로 run() 실행

    }

    //inner class: 오래걸리는 작업을 수행하는 thread 설계
    class MyThread extends Thread {
        @Override
        public void run() {
            //이 직원 객체가 해야할 작업을 코딩

            //오래 걸리는 작업 수행
            for(int i =0; i<20; i++){

                num++;

                //화면에 num 값 출력
                // UI 변경작업은 반드시 Main Thread 만 할 수 있음
                //안드로이드에서는 Main Thread 를 UI Thread 라고도 함
                // but 실행하는 디바이스의 android 버전이 pie ㅏ,버전 (api 29)부터는  UI 변경 가능

                //별도 Thread 에서 UI 변경 작업을 하려면 반드시 MainThread 에게 변경을 요청해야함

                // 방법 1. Handler 를 이용하는 방법
//                handler.sendEmptyMessage(0); //메세지의 식별번호
                //보낼 메세지 num 이 MainActivity 의 멤버변수 이므로 빈 메세지를 보내도 괜찮음

                //방법 2. MainActivity class 의 메소드인 runOnUiThread() 를 이용
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 이 Runnable Thread 는 Main Thread 의 위임장을 받았기에 UI 변경이 가능
                        tv.setText(num);
                    }
                });

                tv.setText(num);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                    }
    }//MyThread class

    //MainActivity 의 멤버변수
    Handler  handler = new Handler(){
        //sendEmptyMessage()가 호출되면 자동으로 실행되는 메소드
        //이 메소드 안에서 UI 변경작업이 가능함
        @Override
        public void handleMessage(@NonNull Message msg) {
            tv.setText(num+"");
        }
    };

}//MainActivity class
