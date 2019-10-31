package com.bomnie.ex013toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //멤버변수
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickBtn(View view) {

        if(t!=null){
            t.cancel();
            t=null;
        }

        //Toast 보이기
//        String str= new String("aaa");
//
//        //Toast객체 생성
//        t= Toast.makeText(this, R.string.text, Toast.LENGTH_SHORT);
//        //토스트의 위치 지정
//        t.setGravity(Gravity.CENTER, 0, -200);
//
//        t.show();


        //토스트의 모양을 원하는 모양으로 만들기
        //토스트는 기본적으로 Text를 보여주지만
        //이미지를 보여줄 수도 있음.

        //일단, 토스트 객체는 있어야함.
//        t= Toast.makeText(this, "", Toast.LENGTH_SHORT);
//        //토스트안에 이미지를 보여줄 이미지뷰객체 생성
//        ImageView iv= new ImageView(this);
//        iv.setImageResource(android.R.drawable.ic_lock_silent_mode);
//
//        //토스트안에 보여질 텍스트뷰객체 생성
//        TextView tv= new TextView(this);
//        tv.setText("음소거");
//
//        //토스트에게 이미지뷰, 텍스트뷰 객체 세팅
////        t.setView(iv);
////        t.setView(tv);
//        // 토스트는 한번에 1개의 뷰만 설정 가능함.
//
//        // 뷰들을 가질 수 있는 ViewGroup객체 생성
////        LinearLayout linearLayout= new LinearLayout(this);
////        linearLayout.setOrientation(LinearLayout.VERTICAL);
////
//        linearLayout.addView(iv);
//        linearLayout.addView(tv);
//
//        t.setView(linearLayout);
//
//        //토스트를 화면에 보여라!!
//        t.setGravity(Gravity.CENTER, 0, 0);
//        t.show();

        //위 방식은 Java언어로 뷰들을 만들기 때문에
        //가독성 떨어짐.

        //XML언어로 뷰의 레이아웃을 만들면 더 쉽게
        //화면을 꾸밀 수 있음.

        //위 이미지뷰, 텍스트뷰, LinearLayout을
        //XML언어로 만들어서 Toast에 설정하기!![ 이 방식을 권장 ]


        //XML로 View객체를 생성하고 적용하기///

        t= Toast.makeText(this, "", Toast.LENGTH_LONG);

        //Layout폴더 안에 있는 toast.xml이라는 문서를 읽어서
        //View객체로 만들어(부풀려주는 inflate)주는 능력을 가진 객체를 Context로 부터 얻어오기
        LayoutInflater inflater= getLayoutInflater();
        View v= inflater.inflate(R.layout.toast, null);

        t.setView(v);

        t.setGravity(Gravity.CENTER, 0,0);
        t.show();






    }
}
