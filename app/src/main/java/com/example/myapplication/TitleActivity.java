package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity {


    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;
    Button menu_bt4;
    Button hidden_bt;
    Button my_info_bt;



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



    }
}
