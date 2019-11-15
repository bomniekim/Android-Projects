package com.bomnie.ex043fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    TextView tv;
    Button btn;
    Button btn2;

    //프레그먼트가 보여줄 View(화면)을 만들어 내는 작업을 하는 메소드
    //마치 Activity 의 onCreate()같은 역할
    //화면에 보여질 때 자동으로 실행되는 콜백메소드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //보여줄 뷰객체를 생성(부풀리다)
        View view= inflater.inflate(R.layout.fragment_my, container, false);

        tv= view.findViewById(R.id.tv);
        btn= view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("aaadsfasdf");
            }
        });

        btn2= view.findViewById(R.id.btn2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //MainActivity 의 TextView 의 글씨 변경
//
//                //이 프레그먼트를 보여주는 Activity를
//                //얻어와서 참조하기
//                MainActivity activity= (MainActivity)getActivity();
//                activity.tv.setText("!!!!!!!");
//
//            }
//        });


        //생성된 뷰를 리턴해주면 Activity 에 보여짐
        return view;
    }

}

