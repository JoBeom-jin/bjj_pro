package com.example.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.MarkerItem;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MoneyActivity extends Activity {

    Button recommend_bt;
    Button recommend_close_bt;
    EditText pp;
    TextView p1;
    TextView p2;
    TextView p3;


    ArrayList<MarkerItem> sample = new ArrayList();

    private Realm realm = Realm.getDefaultInstance();

    View.OnClickListener re_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final RealmResults<MarkerItem> results = realm.where(MarkerItem.class).findAll();

            for (MarkerItem markerItem : results) {
                sample.add(markerItem);
            }

            String money1 = pp.getText().toString();
            int money_num = Integer.parseInt(money1);

            if(money_num>=2000 && money_num<10000){
                p1.setText(sample.get(4).getTitle());
                p2.setText(sample.get(4).getAdd());
                p3.setText(sample.get(4).getPhone_num());
            }

            else if(money_num>=0 && money_num<2000){
                p1.setText(sample.get(7).getTitle());
                p2.setText(sample.get(7).getAdd());
                p3.setText(sample.get(7).getPhone_num());
            }

            else if(money_num>=10000 && money_num<30000){
                p1.setText(sample.get(8).getTitle());
                p2.setText(sample.get(8).getAdd());
                p3.setText(sample.get(8).getPhone_num());
            }

            else if(money_num>=30000 && money_num<50000){
                p1.setText(sample.get(9).getTitle());
                p2.setText(sample.get(9).getAdd());
                p3.setText(sample.get(9).getPhone_num());
            }

            else if(money_num>=50000 && money_num<70000){
                p1.setText(sample.get(1).getTitle());
                p2.setText(sample.get(1).getAdd());
                p3.setText(sample.get(1).getPhone_num());
            }

            else if(money_num>70000){
                p1.setText(sample.get(6).getTitle());
                p2.setText(sample.get(6).getAdd());
                p3.setText(sample.get(6).getPhone_num());
            }
            else {
                Toast.makeText(getApplicationContext(), "다시 입력해주세요!",Toast.LENGTH_SHORT).show();
            }



        }
    };


    View.OnClickListener re_close = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_money);

        recommend_bt = (Button) findViewById(R.id.recommend_bt);
        recommend_close_bt = (Button) findViewById(R.id.recommend_close);
        pp = (EditText) findViewById(R.id.money_go);

        p1 = (TextView) findViewById(R.id.place_re_name);
        p2 = (TextView) findViewById(R.id.place_re_address);
        p3 = (TextView) findViewById(R.id.place_re_num);

        recommend_bt.setOnClickListener(re_click);
        recommend_close_bt.setOnClickListener(re_close);





    }
}
