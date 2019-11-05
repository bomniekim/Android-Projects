package com.bomnie.ex024listviewcustomizing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//BaseAdapter 클래스는 추상메소드를 보유하고 있음.
public class MyAdapter extends BaseAdapter {

    //멤버변수
    ArrayList<Member> members;
    LayoutInflater inflater;

    //생성자메소드
    public MyAdapter(ArrayList<Member> members, LayoutInflater inflater){
        this.members= members;
        this.inflater= inflater;

    }


    // Adapter 객체가 만들어낼 View 객체의 개수를 리턴
    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //리스트 뷰에 보여질 항목 하나의 View를 만들어내는 메소드
    //getView가 제일 중요함
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //position: 몇 번째 것을 연결할 것인가

        //xml 로 View 모양을 설계하고 이를 객체로 만들어서 리턴

        //listview_item.xml 문서를 읽어와서 View 로 만들어주는 (inflate) 객체를 이용하여 View 객체 생성

        // xml -> View 객체로 부풀려주는 LayoutInflater

        //1. new View
        // 재활용할 View가 없는가?
        if(view == null){
            view  = inflater.inflate(R.layout.listview_item, null); //null 이면 새로 참조해
        }

        //2. bind View (만들어진 View 와 Data 를 연결하는 작업)
        //현재번째 ( position번째 ) View 에 보여줄 데이터 얻어오기
        Member member = members.get(position);

        ImageView iv = view.findViewById(R.id.item_iv);
        TextView tvName = view.findViewById(R.id.item_tv_name);
        TextView tvNation = view.findViewById(R.id.item_tv_nation);

        iv.setImageResource(member.imgID);
        tvName.setText(member.name);
        tvNation.setText(member.nation);

        //만들어진 뷰를 리턴하면 리스트뷰가 화면에 보여짐
        return view;
    }
}
