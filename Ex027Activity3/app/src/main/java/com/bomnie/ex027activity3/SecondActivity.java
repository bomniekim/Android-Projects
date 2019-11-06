package com.bomnie.ex027activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et= findViewById(R.id.et);
    }

    public void clickBtn(View view) {
        //완료버튼을 누르면
        //EditText에 써있는 글씨를 얻어와서
        //Intent에게 추가시키고 Activity 종료

        String str= et.getText().toString();

        //데이터를 복귀할 Intent에게 추가하기
        Intent intent= getIntent();
        intent.putExtra("data", str);
        intent.putExtra("Age", 15);

        //이 액티비티의 결과라고 설정!!
        setResult( RESULT_OK, intent);

        //액티비티종료
        finish();
    }
}
