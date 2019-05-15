package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GMPage extends Activity {

    Button gm_popup_close;
    Button gm_page;

    EditText password;

    View.OnClickListener page_go = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(password.getText().toString().equals("09241")){
                Intent i = new Intent(getApplicationContext(), DBActivity.class);
                startActivity(i);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "다시 입력해주십시오!",Toast.LENGTH_SHORT).show();
                password.setText("");
            }
        }
    };


    View.OnClickListener popup_close = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), TitleActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gmpage);

        gm_popup_close = (Button) findViewById(R.id.gm_popup_close);
        gm_page = (Button) findViewById(R.id.page_go);
        password = (EditText) findViewById(R.id.app_password);

        gm_popup_close.setOnClickListener(popup_close);
        gm_page.setOnClickListener(page_go);
    }
}
