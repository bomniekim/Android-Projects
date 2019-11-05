package com.bomnie.ex023gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayAdapter adapter;

    //대량의 데이터 참조변수
    ArrayList<String> data= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 Data
        data.add("aaa");
        data.add("bbb");
        data.add("ccc");
        data.add("ddd");
        data.add("eee");
        data.add("fff");

        gridView= findViewById(R.id.gridview);

        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        gridView.setAdapter(adapter);
    }
}
