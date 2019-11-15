package com.bomnie.ex042viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    ArrayList<Integer> data;
    LayoutInflater inflater;

    //생성자를 만들어서 MainActivity 에 있는 ArrayList data 를 이 class 와 연결
    public MyAdapter(ArrayList<Integer> data, LayoutInflater inflater) {
        this.data = data; //매개변수로 받은 것을 멤버변수와 연결
        this.inflater = inflater;
    }

    //추상메소드 구현 (alt + insert)
    //총 page 수를 리턴
    @Override
    public int getCount() {
        return data.size();
    }

    // adapter 가 만들어 낼 Page(View) 객체를 생성하는 코드를 작성하는 메소드
    //추상메소드로 구현되어 있지 않기 때문에 직접 써야함

    @NonNull
    @Override
    // 이 메소드 한번에 한 페이지가 만들어짐
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View page = inflater.inflate(R.layout.page, null); // 지금 아무한테도 안 붙일거라서 null

        ImageView iv = page.findViewById(R.id.iv);
        iv.setImageResource(data.get(position));

        //만들어진 page(View)를 ViewPager 에 붙이기
        container.addView(page);

        //여기서 리턴한 View 객체가 아래에 있는  isViewFromObject() 에 전달됨
        return page;
    }

    //ViewPager 는 최대 3개까지만 만들어짐
    // ViewPager 에서 제거해야 할 page(View)를 제거할 때 자동 실행되는 메소드

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // ViewPager 에서 해당하는 page 객체를 제거
        container.removeView( (View)object );
    }

    //위 instantiateItem()가 실행된 후 만든 리턴된 page(View)가
    // ViewPager 에서 현재 보여질 아이템과 같은지 검증하는 메소드
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object ;

    }
}
