package com.bomnie.ex035xmlresourceparsing;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //Resources 폴더 안에 있는 xml 문서를 읽어와서 분석(parse)하는 작업 수행

        //res 폴더 창고관리자 객체 소환
        Resources res = getResources();

        //창고관리자로부터 분석가(parser) 객체 얻어오기
        XmlResourceParser xrp = res.getXml(R.xml.movies);

        StringBuffer buffer = new StringBuffer();

//        buffer.append("aaa");
//        buffer.append("bbb");
//        buffer.append("bbc");
//
//        String s = buffer.toString();

        //xml 파서에게 xml 문서를 분석하도록 코딩

        try {
            xrp.next();
           int eventType = xrp.getEventType();

           String tagName; //태그명
           String text; //내용 글씨

           while(eventType!=XmlResourceParser.END_DOCUMENT){

               switch (eventType){
                   case XmlResourceParser.START_DOCUMENT:
                       buffer.append("xml parsing start!\n\n");
                       break;

                   case XmlResourceParser.START_TAG:
                       tagName = xrp.getName(); //태그문의 이름 얻어오기

                       if(tagName.equals("no")){
                           buffer.append("번호: ");
                       }else if(tagName.equals("title")){
                           buffer.append("제목: ");
                       }else if(tagName.equals("genre")){
                           buffer.append("장르: ");
                       }
                       break;

                   case XmlResourceParser.TEXT:
                       text = xrp.getText();
                       buffer.append(text);
                       break;

                   case XmlResourceParser.END_TAG:
                       tagName = xrp.getName();
                       if(tagName.equals("no")){
                           buffer.append("\n");
                       }else if(tagName.equals("title")){
                           buffer.append("\n");
                       }else if(tagName.equals("genre")){
                           buffer.append("\n");
                       }else if(tagName.equals("item")){
                           buffer.append("\n");
                       }
                       break;

                   case XmlResourceParser.END_DOCUMENT:

                       break;

               }//switch

//               xrp.next();
//               eventType = xrp.getEventType();
               eventType = xrp.next();
           }//while

            buffer.append("parsing end..");

           tv.setText(buffer.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


    }
}
