package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.MarkerItem;

import io.realm.Realm;

public class TitleActivity extends AppCompatActivity {


    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;
    Button menu_bt4;
    Button hidden_bt;
    Button my_info_bt;

    private Realm realm = Realm.getDefaultInstance();

    View.OnClickListener hidden_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), GMPage.class);
            startActivity(i);
            finish();
        }
    };



    View.OnClickListener info_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i = new Intent(getApplicationContext(),InfopopupActivity.class);
            startActivity(i);
        }
    };


    View.OnClickListener menu1_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(i);
            finish();
        }
    };


    View.OnClickListener menu2_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener home_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), TitleActivity.class);
            startActivity(i);
            finish();
        }
    };


    View.OnClickListener menu4_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), RecommendActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener menu5_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MyActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);



        menu_bt1 = (Button) findViewById(R.id.menu_bt1);
        menu_bt2 = (Button) findViewById(R.id.menu_bt2);
        home_bt2 = (Button) findViewById(R.id.menu_bt3);
        menu_bt4 = (Button) findViewById(R.id.menu_bt4);
        menu_bt5 = (Button) findViewById(R.id.menu_bt5);
        my_info_bt = (Button) findViewById(R.id.my_info_bt);
        hidden_bt = (Button) findViewById(R.id.hidden_bt);

        hidden_bt.setOnClickListener(hidden_click);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        String nnn = sp.getString("m_name","");

        Toast.makeText(getApplicationContext(), nnn+"님 환영합니다.",Toast.LENGTH_SHORT).show();


        menu_bt1.setOnClickListener(menu1_click);
        menu_bt2.setOnClickListener(menu2_click);
        home_bt2.setOnClickListener(home_click);
        menu_bt4.setOnClickListener(menu4_click);
        menu_bt5.setOnClickListener(menu5_click);
        my_info_bt.setOnClickListener(info_click);


        SharedPreferences pref = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);
        boolean first = pref.getBoolean("isFirst", false);


        if(first==false){
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("isFirst",true);
            editor.commit();

            realm.beginTransaction();
            MarkerItem place = realm.createObject(MarkerItem.class);
            place.setTitle("석기정 안양점");
            place.setAdd("경기도 안양시 만안구 안양1동 674-48");
            place.setPhone_num("031-444-6426");
            place.setLat(37.399928);
            place.setLon(126.921276);

            MarkerItem place1 = realm.createObject(MarkerItem.class);
            place1.setTitle("청사초롱");
            place1.setAdd("경기도 안양시 만안구 안양1동 674-91");
            place1.setPhone_num("031-442-1144");
            place1.setLat(37.399964);
            place1.setLon(126.922786);

            MarkerItem place2 = realm.createObject(MarkerItem.class);
            place2.setTitle("N서울타워");
            place2.setAdd("서울특별시 용산구 용산2가동 남산공원길 105");
            place2.setPhone_num("02-3455-9277");
            place2.setLat(37.551185);
            place2.setLon(126.988232);


            MarkerItem place3 = realm.createObject(MarkerItem.class);
            place3.setTitle("경복궁");
            place3.setAdd("서울특별시 종로구 세종로 사직로 161");
            place3.setPhone_num("02-3700-3900");
            place3.setLat(37.579668);
            place3.setLon(126.977041);


            MarkerItem place4 = realm.createObject(MarkerItem.class);
            place4.setTitle("청계천");
            place4.setAdd("서울특별시 종로구 용신동 청계천로");
            place4.setPhone_num("02-2290-7111");
            place4.setLat(37.571403);
            place4.setLon(127.024606);


            MarkerItem place5 = realm.createObject(MarkerItem.class);
            place5.setTitle("수원 화성");
            place5.setAdd("경기도 수원시 팔달구 장안동 1-2");
            place5.setPhone_num("");
            place5.setLat(37.288532);
            place5.setLon(127.013939);


            MarkerItem place6 = realm.createObject(MarkerItem.class);
            place6.setTitle("롯데월드");
            place6.setAdd("서울특별시 송파구 잠실동 올림픽로 240");
            place6.setPhone_num("1661-2000");
            place6.setLat(37.511158);
            place6.setLon(127.098178);

            MarkerItem place7 = realm.createObject(MarkerItem.class);
            place7.setTitle("낙산공원");
            place7.setAdd("서울특별시 종로구 이화동 낙산길 41");
            place7.setPhone_num("02-743-7985");
            place7.setLat(37.580691);
            place7.setLon(127.007473);

            MarkerItem place8 = realm.createObject(MarkerItem.class);
            place8.setTitle("동묘시장");
            place8.setAdd("서울특별시 종로구 숭인2동");
            place8.setPhone_num("");
            place8.setLat(37.573309);
            place8.setLon(127.017610);


            MarkerItem place9 = realm.createObject(MarkerItem.class);
            place9.setTitle("한국민속촌");
            place9.setAdd("경기도 용인시 기흥구 상갈동 민속촌로 90");
            place9.setPhone_num("031-288-0000");
            place9.setLat(37.258468);
            place9.setLon(127.117005);

            realm.commitTransaction();

        }



    }
}
