package com.bomnie.mp02onetotwentyfive;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btnRetry;

    Button[] btns = new Button[25]; //Button 참조변수가 25개짜리인 배열객체

    //현재 눌러야 할 번호
    int num = 1;

    //버튼의 배경그림 객체 참조변수
    Drawable backDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btnRetry = findViewById(R.id.btn_retry);

        Random rnd = new Random();
        //중복되지 않는 랜덤 값 25개를 가진 배열 만들기
        int[] arr = new int[25];
        for (int i = 0; i < 25; i++) {
            arr[i] = rnd.nextInt(25) + 1; //1-25
            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    i--;
                    break; //중복제거
                }
            }
        }
        //Button 참조변수들에게 Button 객체들 참조시키기

        for (int i = 0; i < 25; i++) {
            btns[i] = findViewById(R.id.btn01 + i);
            btns[i].setText(arr[i] + "");
            btns[i].setTag(arr[i]); //작은 비밀금고를 설정

        }

        //버튼의 배경이미지 얻어오기
        backDrawable = btns[0].getBackground();

    }//onCreate Method

    //onClick 속성에 지정한 콜백메소드
    //onClick 속성으로 지정한 메소드가 자동 실행됨

    //1) 접근제한자 public
    //2) 리턴타입 void
    //3) 파라미터 1개 필수 : View 타입

    public void clickBtn (View v) {
        //매개변수로 전달된 View v가 현재 클릭한 뷰(버튼)

        //클릭된 버튼의 글씨를 얻어오기
        Button but = (Button)v; //다운캐스팅
       // String s = but.getText().toString();

        //버튼에 기록된 Tag 값을 얻어오기
        String s = but.getTag().toString();

        //얻어온 글씨를 int 형으로 변환
        int n = Integer.parseInt(s);

        //얻어온 번호와 현재 누를 번호(num)와 같은지 비교
        if(  n==num ) {
            //눌러야 할 번호를 잘 눌렀다!
            but.setText("OK"); //버튼의 글씨 변경
            //but.setTextColor(Color.RED);
            but.setTextColor(0xFFFF0000); // 자바에서는 ARGB : A는 알파값(투명도) FF는 완전불투명
            but.setBackgroundColor(Color.TRANSPARENT); //클릭 시 배경 투명

            //버튼을 안 보이도록 하려면
            //but.setVisibility(View.INVISIBLE);

            //눌러야 번호를 증가
            num++;

            if(num>25){
                tv.setText("CLEAR");
                btnRetry.setEnabled(true);
            }else {
                tv.setText(num+"");
            }
        }

    }//clickBtn Method

    //retry 버튼에 지정된 onClick 속성 콜백 메소드
    public void clickRetry (View v){

        Random rnd = new Random();

        int[] arr= new int[25];
        for(int i=0; i<arr.length; i++){
            arr[i]=rnd.nextInt(25)+1;

            //중복검사 작업///////////////////
            for(int k=0; k<i; k++){
                if (arr[i]==arr[k]){
                    i--;
                    break;
                }
            }//////////////////////////////////////
        }
        for(int i=0; i<btns.length; i++){
            btns[i].setText(arr[i]+"");
            btns[i].setTag(arr[i]);
            btns[i].setTextColor(Color.BLACK);
            btns[i].setBackground(backDrawable); //아까 얻어놓은 그 그림을 다시 얻어오기
        }

        num=1;
        tv.setText(num+"");
        btnRetry.setEnabled(false);
    }
}//MainActivity class
