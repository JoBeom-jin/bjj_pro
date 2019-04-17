package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class InfopopupActivity extends Activity {

    TextView t_name;
    TextView t_phone;
    TextView t_gender;
    TextView t_hobby;
    Button t_button;

    View.OnClickListener t_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.commit();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener close_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_infopopup);

        t_name = (TextView) findViewById(R.id.t_name);
        t_phone = (TextView) findViewById(R.id.t_phone);
        t_gender = (TextView) findViewById(R.id.t_gender);
        t_hobby = (TextView) findViewById(R.id.t_hobby);
        t_button = (Button)findViewById(R.id.t_button);
        Button info_close = (Button) findViewById(R.id.popup_close);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);


        t_button.setOnClickListener(t_click);
        info_close.setOnClickListener(close_click);


        t_name.setText(sp.getString("m_name",""));
        t_phone.setText(sp.getString("m_phone",""));
        t_gender.setText(sp.getString("m_gender",""));
        t_hobby.setText(sp.getString("m_hobby",""));
    }
}
