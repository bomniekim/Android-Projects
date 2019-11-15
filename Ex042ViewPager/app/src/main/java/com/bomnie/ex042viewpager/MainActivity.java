package com.bomnie.ex042viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    MyAdapter adapter;

    //1. 대량의 데이터들
    ArrayList<Integer> data = new ArrayList<>();
    //ArrayList 는 참조형 변수만 끌고 다닐 수 있으므로 정수형을 끌고 싶을 때는 Integer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 대량의 데이터 추가
        data.add( R.drawable.gametitle_01 );
        data.add( R.drawable.gametitle_02 );
        data.add( R.drawable.gametitle_03 );
        data.add( R.drawable.gametitle_04 );
        data.add( R.drawable.gametitle_05 );
        data.add( R.drawable.gametitle_06 );
        data.add( R.drawable.gametitle_07 );
        data.add( R.drawable.gametitle_08 );
        data.add( R.drawable.gametitle_09 );
        data.add( R.drawable.gametitle_10 );

        pager = findViewById(R.id.pager);
        adapter = new MyAdapter(data, getLayoutInflater());
        pager.setAdapter(adapter);

        //심화
        // page 를 조금이라도 움직일 때마다 자동으로 발동하는 메소드를 보유한 리스너 추가
        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                //어떤 뷰든 이게 전부 다 된다
                page.setRotationY(position*90);
                page.setScaleX( 1-Math.abs(position/2+0.5f));
                page.setScaleY( 1-Math.abs(position/2+0.5f));
                page.setAlpha(1- Math.abs(position) );
            }
        });


    }

    public void clickPrev(View view) {
        //현재 pager 가 보여주는 페이지 index
        int index = pager.getCurrentItem();

        // 이전 페이지로 이동
        pager.setCurrentItem(index-1, true);
    }

    public void clickNext(View view) {
        int index = pager.getCurrentItem();

        // 다음 페이지로 이동
        pager.setCurrentItem(index+1, false);
    }
}
