package com.bomnie.ex018searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Option Menu를 만드는 메소드
    //onCreate() 실행 후 자동으로 실행됨

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //xml에서 만든 메뉴를 Menu 객체로 만들어 붙이기 (inflater 사용)
        getMenuInflater().inflate(R.menu.actionbar, menu);

        //SearchView에 써 있는 글씨 얻어오기
        //SearchView에 의해 올라온 소프트 키보드의 검색버튼(돋보기모양)을 클릭하는 것을 듣는 리스너 생성

      
        return super.onCreateOptionsMenu(menu);
    }
}
