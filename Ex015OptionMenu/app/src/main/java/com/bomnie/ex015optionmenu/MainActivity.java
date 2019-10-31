package com.bomnie.ex015optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int MENU_AAA = 1;
    final int MENU_BBB = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onCreate() 메소드가 실행된 후
    //자동으로 OptionMenu를 만드는 작업을 하는 콜백 메소드가 발동


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //매개변수로 전달된 Menu객체에게 MenuItem(메뉴항목) 추가

        //1. Java언어로 메뉴아이템 추가 (잘 사용하지 않음)
//        menu.add(0,1, 0, "aaa" ); //groupID, itemID, order, menuTitle
//        menu.add(0,2,0, "bbb");
        // java로 하면 세세한 설정작업이 번거로움
        //그래서 XML언어로 메뉴 항목을 설계


        //2. XML언어로 메뉴아이템 설계하고 추가
        //menu폴더에 있는 option.xml문서를 읽어와서
        //Menu객체로 만들어주는(Inflate: 부풀리다) 객체를 Context에게 얻어오기
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option, menu); //메뉴객체 menu에 붙이기


        return super.onCreateOptionsMenu(menu);
    }


    //OptionMenu의 메뉴항목(MenuItem)을
    //선택했을 때 자동으로 실행되는 콜백메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //매개변수로 전달된 MenuItem 객체가 선택된 메뉴항목 임.

        //선택된 MenuItem을 구분하기 위해
        //메뉴항목에 설정된 ID를 얻어오기
        int id= item.getItemId();

        switch (id){
            case R.id.menu_search:
                Toast t= Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
                t.show();
                break;

            case R.id.menu_add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

                case R.id.menu_help:
                    Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                    break;
        }
        return super.onOptionsItemSelected(item);
    }
}
