package com.bomnie.ex046navigationdrawer;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout= findViewById(R.id.layout_drawer);
        navigationView= findViewById(R.id.nav);
        //item icon 색조를 적용하지 않도록... 설정안하면 회색 색조
        navigationView.setItemIconTintList(null);

        //네비게이션뷰의 아이템을 클릭했을때..
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch ( item.getItemId() ){
                    case R.id.menu_gallery:
                        Toast.makeText(MainActivity.this, "Gallery", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_send:
                        Toast.makeText(MainActivity.this, "Send", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_aa:
                        Toast.makeText(MainActivity.this, "aa", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_bb:
                        Toast.makeText(MainActivity.this, "bb", Toast.LENGTH_SHORT).show();
                        break;
                }

                //Drawer를 닫기...
                drawerLayout.closeDrawer(navigationView);

                return false;
            }
        });


        //Drawer 조절용 토글버튼 객체 생성
        drawerToggle= new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name );

        //ActionBar(제목줄)의 홈or업버튼의 위치에 토글아이콘이 보이게끔...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //삼선아이콘 모양으로 보이도록
        //토글버튼의 동기를 맞추기
        drawerToggle.syncState();

        //삼선아이콘과 화살표아이콘이 자동으로 변환되도록..
        drawerLayout.addDrawerListener(drawerToggle);

    }//onCreate method..

    //액션바의 메뉴를 클릭하는 이벤트를 듣는
    //메소드를 통해서 클릭상황을 전달하도록..
    //토글버튼이 클릭상황을 인지하도록..
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        drawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
