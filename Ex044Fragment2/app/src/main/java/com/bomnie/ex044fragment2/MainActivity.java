package com.bomnie.ex044fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //id가 container 인 녀석에 MyFragment 를 추가

        //Fragment 관리자를 소환
        FragmentManager fragmentManager= getSupportFragmentManager();

        //프레그먼트이 동적추가, 삭제, 재배치 작업을 시작
        FragmentTransaction ft= fragmentManager.beginTransaction(); //작업자 리턴

        MyFragment fragment= new MyFragment();

        //프레그먼트에 데이터를 전송하는 기능
        Bundle bundle= new Bundle(); //보따리 객체
        bundle.putString("Name", "sam");
        bundle.putInt("Age", 20);

        fragment.setArguments(bundle);

        //begin 과 commit 사이에 작업을 코딩
        ft.add(R.id.container, fragment);

        //백스택에 넣지 않고 뒤로가기를 누르면 액티비티가 바로 꺼짐 (Fragment 가 스택에 저장되지 않으므로)
        //프레그먼트를 백스택에 추가시키기
        ft.addToBackStack(null);

        //transaction 작업이 완료되었다고 명령
        ft.commit();

    }
}
