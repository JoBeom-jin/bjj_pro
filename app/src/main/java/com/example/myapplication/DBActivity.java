package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.MarkerItem;
import com.example.myapplication.models.Place;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class DBActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;
    private EditText latEditText;
    private EditText lonEditText;

    RecyclerView recyclerView2;

    private Realm realm = Realm.getDefaultInstance();





    Button bbutton;
    Button gm_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        nameEditText = findViewById(R.id.title_edit);
        addressEditText = findViewById(R.id.add_edit);
        phoneEditText = findViewById(R.id.num_edit);
        latEditText = findViewById(R.id.lat_edit);
        lonEditText = findViewById(R.id.lon_edit);

        recyclerView2 = findViewById(R.id.recycler_view2);

        bbutton = findViewById(R.id.bbutton);
        gm_back = findViewById(R.id.gm_back);


        final RealmResults<MarkerItem> results = realm.where(MarkerItem.class).findAll();

        DBRecyclerAdapter adapter = new DBRecyclerAdapter(results);
        recyclerView2.setAdapter(adapter);

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
                    MarkerItem dog = results.get(a);
                    dog.deleteFromRealm();


                }
            });
        }


        findViewById(R.id.gm_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TitleActivity.class);
                startActivity(i);
                finish();
            }
        });


        findViewById(R.id.bbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                Double lat = Double.parseDouble(latEditText.getText().toString());
                Double lon = Double.parseDouble(lonEditText.getText().toString());


                // DB에 저장
                realm.beginTransaction();
                MarkerItem place = realm.createObject(MarkerItem.class);
                place.setTitle(name);
                place.setAdd(address);
                place.setPhone_num(phone);
                place.setLat(lat);
                place.setLon(lon);
                realm.commitTransaction();

                nameEditText.setText("");
                addressEditText.setText("");
                phoneEditText.setText("");
                latEditText.setText("");
                lonEditText.setText("");
            }
        });






    }
}
