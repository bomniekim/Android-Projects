package com.bomnie.ex024listviewcustomizing;

public class Member {

    int imgID;     //R.drawable.korea
    String name;   //"전현무"
    String nation; //"대한민국"

    //생성(new)할때 자동으로 실행되는 메소드
    //생성자메소드
    public Member(int imgID, String name, String nation){
        //멤버변수에 값 대입
        this.imgID= imgID;
        this.name= name;
        this.nation= nation;
    }

}
