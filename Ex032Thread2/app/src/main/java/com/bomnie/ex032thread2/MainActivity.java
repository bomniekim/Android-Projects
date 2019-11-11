package com.bomnie.ex032thread2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //멤버변수
    MyThread my_thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //이 액티비티가 화면에서 안보이기 시작할때 자동 실행
    @Override
    protected void onPause() {
        super.onPause();
    }

    //이 액티비티가 아예 화면에서 안보이면
    @Override
    protected void onStop() {
        if(my_thread!=null){
            my_thread.stopThread();
        }

        super.onStop();
    }

    //이 액티비티가 메모리에 없어지면
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //뒤로가기 버튼을 눌렀을 때 발동하는 메소드
    @Override
    public void onBackPressed() {
        //Thread 멈추기!!- run method를 끝내면 스레드가 종료됨
        //이 예제에서는 run메소드 안에 while문에 의해 무한반복중이라서..
        //while을 break해야 run메소드가 종료됨
        //thread.isRun= false;
//        if(thread!=null){
//            thread.stopThread();
//        }

        super.onBackPressed();
    }

    public void clickBtn(View view) {
        //5초에 한번씩 현재시간을 Toast 로 출력
        my_thread = new MyThread();
        my_thread.start();

    }
    //inner class
    class MyThread extends Thread {

        boolean isRun=true;

        @Override
        public void run() {
            while (true){

                //현재시간
                Date now = new Date();
                final String time = now.toString(); //현재시간을 글씨로 보여줌

//                Toast.makeText(MainActivity.this).show(); //MyThread 는 UI를 바꿀 수 없음

                runOnUiThread(new Runnable() { //위임장을 받은 객체
                    @Override
                    public void run() {
                        // 이 안에서는 UI 변경 가능
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();
                    }
                });

                //5초간격
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }//while
        }//run method

        void stopThread(){
            isRun=false;
        }
    }//MyThread class
}//MainActivity class
