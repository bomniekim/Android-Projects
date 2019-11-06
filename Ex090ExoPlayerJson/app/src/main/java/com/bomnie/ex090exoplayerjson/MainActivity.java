package com.bomnie.ex090exoplayerjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.res.AssetManager;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 세 개는 언제나 한 쌍!
    RecyclerView recyclerView;
    VideoAdapter adapter;
    ArrayList<VideoItem> videoItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        adapter= new VideoAdapter(this, videoItems);
        recyclerView.setAdapter(adapter);

        // 대량의 비디오 정보들을 로딩해오기(json 파일)
        loadData();
    }

    void loadData(){

        new Thread(){
            @Override
            public void run() {

                //assets 폴더 안에 있는 파일을  읽어오기 위해 매니저 소환 (창고관리자)
                AssetManager assetManager = getAssets();

                //assets/jsons/video|Url.json 파일을 읽기 위한 InputStream
                try {
                    InputStream is = assetManager.open("jsons/videoUrl.json");
                    InputStreamReader isr = new InputStreamReader(is); // 바이트 단위를 문자 단위로 읽음
                    BufferedReader reader = new BufferedReader(isr); // 한 줄 단위로 읽기 위해 기다려

                    StringBuffer buffer= new StringBuffer();
                    String line = reader.readLine();
                    while(line!=null){
                        buffer.append(line+"\n");
                        line= reader.readLine();
                    }

                    final String jsonData =buffer.toString();

                    // 잘 나오는지 확인만 우선
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            new AlertDialog.Builder(MainActivity.this).setMessage(jsonData).create().show();
//                        }
//                    });

                    // JSON 파싱
                    JSONObject jsonObject = new JSONObject(jsonData);

                    JSONArray categoriesArray= jsonObject.getJSONArray("categories");
                    JSONObject object = categoriesArray.getJSONObject(0); // categories 안에 배열 하나

                    JSONArray videosArray= object.getJSONArray("videos");

                    for(int i=0; i<videosArray.length(); i++){
                        JSONObject videoData= videosArray.getJSONObject(i);

                        final String title = videoData.getString("title");
                        final String subTitle= videoData.getString("subtitle");
                        final String desc= videoData.getString("description");

                        String sources = videoData.getString("sources");
                        sources= sources.replace("[\"",""); // [" -> 공백으로 바꾸는 작업
                        sources= sources.replace("\"]",""); // "] -> 공백으로 바꾸는 작업
                        sources= sources.replace("\\/","/"); // / \/ -> / 로 바꾸는 작업

                        final String videoUrl = sources;

                        final String thumb= videoData.getString("thumb");

                        // 리사이클러 에 보여줄 대량의 데이터 (videoItems)에 추가하기
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                videoItems.add(new VideoItem(title, subTitle, desc, videoUrl, thumb));
                                // 이너클래스 안에서는 지역변수를 사용할 수 없기 때문에 자동완성으로 변수 앞에 final
                                adapter.notifyItemInserted(videoItems.size()-1); // 아이템 사이즈에서 하나 뺀 번째에 추가
                            }
                        });

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }
}
