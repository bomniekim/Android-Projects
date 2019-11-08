package com.bomnie.ex033threadnetimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);

    }

    public void clickBtn(View view) {
        //Network 상에 있는 이미지를 읽어와서 ImageView 에 보여주기

        // 안드로이드에서는 Network 작업은 오래 걸리는 작업으로 인지하므로
        //Main Thread 에서는 작업 수행 불가 (하면 Error)
        // 별도의 Thread 를 생성하서 네트워크 작업을 수행하도록
        new Thread(){
            @Override
            public void run() {
                //이미지의 경로
                String imgUrl = "https://i.pinimg.com/originals/d9/82/f4/d982f4ec7d06f6910539472634e1f9b1.png";

                // Stream 을 열 수 있는 헤임달 객체 (URL) 생성
                try {
                    URL url = new URL(imgUrl);

                    //무지개로드 (Stream) 을 얻어오기
                    InputStream is = url.openStream();

                    //스트림을 통해 이미지를 읽어와서 이미지뷰에 설정하기

                    //이미지뷰는 액자와 같은 것
                    //bitmap 은 한번에 하나의 이미지만 가질 수 있음
                    //drawable 은 그런 bitmap 을 여러 장 소유할 수 있고
                    //이미지 뷰에 drawable 을 붙여서 이미지를 보여주는 것
                    //삼중구조

                    //비트맵은 객체를 만들 필요가 없고 BitmapFactory 를 사용
                    final Bitmap bm = BitmapFactory.decodeStream(is);

                    //UI 변경(이미지변경)은 Main Thread 만 할 수 있음
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start(); // 만들면서 바로 start
    }
}
