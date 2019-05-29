package com.example.myapplication;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.Place;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class MyActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;
    private RecyclerView mRecyclerView;

    private Realm realm = Realm.getDefaultInstance();

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
        setContentView(R.layout.activity_my);

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

        nameEditText = findViewById(R.id.name_edit);
        addressEditText = findViewById(R.id.age_edit);
        phoneEditText = findViewById(R.id.phone_edit);

        mRecyclerView = findViewById(R.id.recycler_view);


        // 쿼리
        final RealmResults<Place> results = realm.where(Place.class)
                .sort("name", Sort.DESCENDING)
                .distinct("name")
                .findAll();

        PlaceRecyclerAdapter adapter = new PlaceRecyclerAdapter(results);
        mRecyclerView.setAdapter(adapter);

        Intent i = getIntent();
        final String position = i.getStringExtra("pos");


        if (position == null) {

        } else {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Intent i = getIntent();
                    int a = Integer.parseInt(i.getStringExtra("pos"));
                    // remove a single object
                    Place dog = results.get(a);
                    dog.deleteFromRealm();


                }
            });
        }


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();


                // DB에 저장
                realm.beginTransaction();
                Place place = realm.createObject(Place.class);
                place.setName(name);
                place.setAddress(address);
                place.setPhone(phone);
                realm.commitTransaction();

                nameEditText.setText("");
                addressEditText.setText("");
                phoneEditText.setText("");
            }
        });


    }
}
