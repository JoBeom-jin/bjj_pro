package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.models.Place;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class PlacepopupActivity extends Activity {

    Button bookmark;
    Button p_popup_close;

    TextView p_name;
    TextView p_addr;
    TextView p_phone;

    private Realm realm = Realm.getDefaultInstance();

    View.OnClickListener boomark_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            realm.beginTransaction();
            Place place = realm.createObject(Place.class);
            place.setName(p_name.getText().toString());
            place.setAddress(p_addr.getText().toString());
            place.setPhone(p_phone.getText().toString());
            realm.commitTransaction();


        }
    };


    View.OnClickListener p_popup_close_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_placepopup);

        bookmark = (Button) findViewById(R.id.bookmark_bt);
        p_popup_close = (Button) findViewById(R.id.p_popup_close);
        p_name = (TextView) findViewById(R.id.p_name);
        p_addr = (TextView) findViewById(R.id.p_addr);
        p_phone = (TextView) findViewById(R.id.p_phone);

        final RealmResults<Place> results = realm.where(Place.class).findAll();


        p_popup_close.setOnClickListener(p_popup_close_click);
        bookmark.setOnClickListener(boomark_click);

        Intent i = getIntent();

        String addr = i.getStringExtra("add_phone");

        String[] array = addr.split(",");

        for (int a = 0; a < array.length; a++) {
            System.out.println(array[a]);
        }

        p_name.setText(i.getStringExtra("title"));
        p_addr.setText(array[0]);
        p_phone.setText(array[1]);

    }
}
