package com.bomnie.ex040sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        tv = findViewById(R.id.tv);

    }

    public void clickSAVE(View view) {
        String name = etName.getText().toString();
        int age;
        try{
            age= Integer.parseInt(etAge.getText().toString());
        }catch (Exception e){
            age=0;
        }
//         Integer.parseInt(etAge.getText().toString()); //int 형을 String 형으로 가져오기

        //Data.xml 파일에 데이터를 저장하기 위해 SharedPreferences 객체 소환하기
        SharedPreferences pref; // SharedPreferences 는 이미 MainActivity 에 소속되어 있음
        //Preferences 를 쓰면 다른 Activity 에서 사용 불가
        pref = this.getSharedPreferences("Data", MODE_PRIVATE); //파일명만 쓰면 자동으로 xml 파일로 생성
        // append 모드가 없어서 덮어쓰기만 가능

        //문서 작성을 시작한다는 메소드를
        //실행하면 문서에 글 작성을 해주는 Editor 객체가 리턴됨
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("Name", name); // 키(식별자) 값, 벨류 값
        editor.putInt("Age", age);

        //문서 작성이 끝났다라는 메소드를 실행
        editor.commit();

    }

    public void clickLOAD(View view) {

        SharedPreferences pref = this.getSharedPreferences("Data", MODE_PRIVATE);
        String name = pref.getString("Name", "no name"); // 키(식별자) 값, Default 값

        int age = pref.getInt("Age", 0);

        tv.setText(name+" ,  "+age);

    }
}
