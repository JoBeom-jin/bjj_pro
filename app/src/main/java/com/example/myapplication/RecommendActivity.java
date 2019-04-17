package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.Place;

import java.util.ArrayList;
import java.util.Collections;
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

    TextView place_name;
    TextView phone_name;
    TextView addr_name;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        place_name = (TextView) findViewById(R.id.place_name);
        addr_name = (TextView) findViewById(R.id.addr_name);
        phone_name = (TextView) findViewById(R.id.phone_name);


        menu_bt1 = (Button) findViewById(R.id.menu_bt1);
        menu_bt2 = (Button) findViewById(R.id.menu_bt2);
        home_bt2 = (Button) findViewById(R.id.menu_bt3);
        menu_bt5 = (Button) findViewById(R.id.menu_bt5);
        menu_bt4 = (Button) findViewById(R.id.menu_bt4);


        menu_bt1.setOnClickListener(menu1_click);
        menu_bt2.setOnClickListener(menu2_click);
        home_bt2.setOnClickListener(home_click);
        menu_bt4.setOnClickListener(menu4_click);
        menu_bt5.setOnClickListener(menu5_click);


        final RealmResults<Place> results = realm.where(Place.class).findAll();


        final List<Place> placeList = new ArrayList<>();
        for (Place place : results) {
            placeList.add(place);
        }


        if(placeList.size()>0) {
            Collections.shuffle(placeList);
            place_name.setText(placeList.get(0).getName());
            addr_name.setText(placeList.get(0).getAddress());
            phone_name.setText(placeList.get(0).getPhone());
        }
    }
}
