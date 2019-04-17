package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button main_button;
    EditText main_name;
    EditText main_phone;
    CheckBox ch1;
    CheckBox ch4;
    CheckBox ch3;
    CheckBox ch2;
    RadioGroup gender_radio;



    View.OnClickListener main_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton radioB = (RadioButton) findViewById(gender_radio.getCheckedRadioButtonId());

            SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("m_name",main_name.getText().toString());
            ed.putString("m_phone",main_phone.getText().toString());
            ed.putString("m_gender",radioB.getText().toString());
            String result = "";
            if(ch1.isChecked() == true) result += ch1.getText().toString();
            if(ch2.isChecked() == true) result += ch2.getText().toString();
            if(ch3.isChecked() == true) result += ch3.getText().toString();
            if(ch4.isChecked() == true) result += ch4.getText().toString();
            ed.putString("m_hobby", result);
            ed.commit();
            Intent i = new Intent(getApplicationContext(), TitleActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_button = (Button) findViewById(R.id.main_button);
        main_name = (EditText) findViewById(R.id.main_name);
        main_phone = (EditText) findViewById(R.id.main_phone);
        ch1 = (CheckBox) findViewById(R.id.main_ch1);
        ch2 = (CheckBox) findViewById(R.id.main_ch2);
        ch3 = (CheckBox) findViewById(R.id.main_ch3);
        ch4 = (CheckBox) findViewById(R.id.main_ch4);
        gender_radio = (RadioGroup) findViewById(R.id.gender);



        main_button.setOnClickListener(main_click);
    }

    @Override
    public void onBackPressed() {
        return;
    }

}
