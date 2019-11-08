package com.bomnie.ex030activity6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 내 앱 안에서 다른 앱(전화, 갤러리 등)을 실행하는 기법
    public void clickDial(View view) {

        Intent intent = new Intent();
        //intent.setAction("android.intent.action.DIAL"); //시스템 자체에 지정되어 있음 (묵시적 intent 사용)
        intent.setAction(Intent.ACTION_DIAL);

        Uri uri = Uri.parse("tel:01012345678");
        intent.setData(uri);

        startActivity(intent);
    }

    public void clickSMS(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:01012345678, 01051562475"));

        //메세지를 추가적으로 미리 써놓을 때
        intent.putExtra("sms_body", "Hello.. Nice to Meet You");
        startActivity(intent);

    }

    public void clickWeb(View view) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
        startActivity(intent);
    }

    public void clickGallery(View view) {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivity(intent);
    }

    public void clickCam(View view) {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
