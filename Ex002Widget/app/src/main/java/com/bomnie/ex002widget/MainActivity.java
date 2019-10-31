package com.bomnie.ex002widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // XML에서 만든 TextView를 참조하여 제어하기
        //
        TextView tv= findViewById(R.id.tv);
        tv.setSelected(true);
    }
}
