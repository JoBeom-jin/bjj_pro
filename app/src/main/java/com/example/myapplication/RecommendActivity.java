package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.MarkerItem;
import com.example.myapplication.models.Place;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class RecommendActivity extends AppCompatActivity {

    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;
    Button menu_bt4;
    Button money_recommend;

    TextView place_name;
    TextView phone_name;
    TextView addr_name;
    TextView date_text;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");


    private Realm realm = Realm.getDefaultInstance();

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


    View.OnClickListener money_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MoneyActivity.class);
            startActivity(i);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        place_name = (TextView) findViewById(R.id.place_name);
        addr_name = (TextView) findViewById(R.id.addr_name);
        phone_name = (TextView) findViewById(R.id.phone_name);
        date_text = (TextView) findViewById(R.id.date_text);


        menu_bt1 = (Button) findViewById(R.id.menu_bt1);
        menu_bt2 = (Button) findViewById(R.id.menu_bt2);
        home_bt2 = (Button) findViewById(R.id.menu_bt3);
        menu_bt5 = (Button) findViewById(R.id.menu_bt5);
        menu_bt4 = (Button) findViewById(R.id.menu_bt4);
        money_recommend = (Button) findViewById(R.id.money_recommend);


        menu_bt1.setOnClickListener(menu1_click);
        menu_bt2.setOnClickListener(menu2_click);
        home_bt2.setOnClickListener(home_click);
        menu_bt4.setOnClickListener(menu4_click);
        menu_bt5.setOnClickListener(menu5_click);
        money_recommend.setOnClickListener(money_click);


        date_text.setText(getTime());

        String text = date_text.getText().toString();

        String text2 = text.substring(text.length()-1);


        final RealmResults<MarkerItem> results = realm.where(MarkerItem.class).findAll();


        final List<MarkerItem> placeList = new ArrayList<>();
        for (MarkerItem place : results) {
            placeList.add(place);
        }


        if(placeList.size()>0) {

            switch (text2){
                case "0":
                    place_name.setText(placeList.get(0).getTitle());
                    addr_name.setText(placeList.get(0).getAdd());
                    phone_name.setText(placeList.get(0).getPhone_num());
                    break;
                case"1":
                    place_name.setText(placeList.get(1).getTitle());
                    addr_name.setText(placeList.get(1).getAdd());
                    phone_name.setText(placeList.get(1).getPhone_num());
                    break;
                case"2":
                    place_name.setText(placeList.get(2).getTitle());
                    addr_name.setText(placeList.get(2).getAdd());
                    phone_name.setText(placeList.get(2).getPhone_num());
                    break;
                case"3":
                    place_name.setText(placeList.get(3).getTitle());
                    addr_name.setText(placeList.get(3).getAdd());
                    phone_name.setText(placeList.get(3).getPhone_num());
                    break;

                case"4":
                    place_name.setText(placeList.get(4).getTitle());
                    addr_name.setText(placeList.get(4).getAdd());
                    phone_name.setText(placeList.get(4).getPhone_num());
                    break;
                case"5":
                    place_name.setText(placeList.get(5).getTitle());
                    addr_name.setText(placeList.get(5).getAdd());
                    phone_name.setText(placeList.get(5).getPhone_num());
                    break;
                case"6":
                    place_name.setText(placeList.get(6).getTitle());
                    addr_name.setText(placeList.get(6).getAdd());
                    phone_name.setText(placeList.get(6).getPhone_num());
                    break;

                case"7":
                    place_name.setText(placeList.get(7).getTitle());
                    addr_name.setText(placeList.get(7).getAdd());
                    phone_name.setText(placeList.get(7).getPhone_num());
                    break;

                case"8":
                    place_name.setText(placeList.get(8).getTitle());
                    addr_name.setText(placeList.get(8).getAdd());
                    phone_name.setText(placeList.get(8).getPhone_num());
                    break;

                case"9":
                    place_name.setText(placeList.get(9).getTitle());
                    addr_name.setText(placeList.get(9).getAdd());
                    phone_name.setText(placeList.get(9).getPhone_num());
                    break;
            }


        }
    }


    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

}
