package com.bomnie.ex090exoplayerjson;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<VideoItem> videoItems;

    ProgressiveMediaSource.Factory mediaFactory; // 소매 공장 (4가지 중 하나)
    DataSource.Factory factory; // 도매 공장

    // 생성자 자동완성
    public VideoAdapter(Context context, ArrayList<VideoItem> videoItems) {
        this.context = context;
        this.videoItems = videoItems;

        factory = new DefaultDataSourceFactory(context, "Ex090ExoPlayerJson"); // 도매 공장 이름
        mediaFactory = new ProgressiveMediaSource.Factory(factory); // 도매 공장에서 소매 공장으로 넘어가는 과정
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false); // 붙이지 마세요
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;

        VideoItem videoItem= videoItems.get(position);
        vh.tvTitle.setText(videoItem.getTitle());
        vh.tvSubtitle.setText(videoItem.getSubTitle());
        vh.tvDesc.setText(videoItem.getDesc());

        // 플레이어가 실행할 비디오데이터 소스 객체 생성 (CD나 LP판 같은) from 미디어 공장(소매 공장)
        ProgressiveMediaSource mediaSource = mediaFactory.createMediaSource(Uri.parse(videoItem.videoUrl)); // String 을 Uri 파스 -> Uri 로 만듦
        // 위에서 만든 비디오데이터 소스를 플레이어에게 로딩하도록
        vh.player.prepare(mediaSource); // 플레이어에게 CD를 주는 작업

    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    //이너클래스
    class VH extends RecyclerView.ViewHolder{

        TextView tvTitle, tvSubtitle, tvDesc;

        PlayerView pv;
        SimpleExoPlayer player;

        Button btnFull;

        // 생성자 자동완성
        public VH(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
            tvDesc= itemView.findViewById(R.id.tv_desc);

            pv = itemView.findViewById(R.id.pv);
            player = ExoPlayerFactory.newSimpleInstance(context, new DefaultTrackSelector());
            pv.setPlayer(player); // PlayerView 와 SimpleExoPlayer 를 연결

            btnFull= itemView.findViewById(R.id.btn_full);
            btnFull.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    VideoItem videoItem = videoItems.get(getLayoutPosition()); // 클릭된 것이 몇번째 인지 알 수 있음
                    String videoUrl= videoItem.getVideoUrl();
                    long currentPos= player.getCurrentPosition();

                    // 전체 화면 액티비티로 전환
                    Intent intent= new Intent(context, FullScreenActivity.class);
                    intent.putExtra("videoUrl", videoUrl); // 키 값과 변수 이름
                    intent.putExtra("currentPos", currentPos);


                    context.startActivity(intent);
                }
            });
        }
    }

    // 아이템 뷰가 화면에서 보이지 않을 때 자동으로 실행되는 메소드
    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        VH vh=(VH)holder; // 다운캐스팅

        vh.player.setPlayWhenReady(false); // 일시정지- 준비가 되면 실행하라는 것의 반대 (pause 가 따로 있는 것이 아님)
    }

    // 화면에 보여질 때 자동으로 실행
    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        VH vh=(VH)holder; // 다운캐스팅
       //vh.player.setPlayWhenReady(true); // 화면에 보이는 뷰는 다 재생하라는 의미


    }
}
