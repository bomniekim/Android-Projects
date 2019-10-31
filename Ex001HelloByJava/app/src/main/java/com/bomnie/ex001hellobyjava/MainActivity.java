package com.bomnie.ex001hellobyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //view는 왠만하면 멤버변수로 만들기
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //화면에 보여질 View객체 생성하기!
        Button btn = new Button(this);
        btn.setText("button");
        //setContentView(btn);

        //글씨를 보여주는 view객체 생성
        //TextView tv = new TextView(this);
        tv = new TextView(this);
        tv.setText("Hello Android");
        tv.setTextSize(32); //32 pixel사이즈
        tv.setTextColor(Color.BLUE);
        //setContentView(tv);

        //Activity는 한 번에 1개의 View만 설정할 수 있음
        //그래서 ViewGroup을 1개 만들고 그 안에 View들을 추가
        //마치 JPanel에 Component를 전부 붙이고 그 패널을 JFrame에 붙이는 것처럼

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(btn);
        linearLayout.addView(tv);

        setContentView(linearLayout);

        //버튼 클릭 시 반응 추가 :  리스너 설정하기
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //텍스트뷰 글씨 변경하기
                tv.setText("Nice to meet you");
            }
        });


    }
}
