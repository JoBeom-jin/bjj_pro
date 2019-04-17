package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;
    Button menu_bt4;


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


    View.OnClickListener menu4_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), RecommendActivity.class);
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
        setContentView(R.layout.activity_info);

        menu_bt1 = (Button) findViewById(R.id.menu_bt1);
        menu_bt2 = (Button) findViewById(R.id.menu_bt2);
        home_bt2 = (Button) findViewById(R.id.menu_bt3);
        menu_bt5 = (Button) findViewById(R.id.menu_bt5);
        menu_bt4 = (Button) findViewById(R.id.menu_bt4);


        menu_bt1.setOnClickListener(menu1_click);
        menu_bt2.setOnClickListener(menu2_click);
        home_bt2.setOnClickListener(home_click);
        menu_bt5.setOnClickListener(menu5_click);
        menu_bt4.setOnClickListener(menu4_click);
    }
}
