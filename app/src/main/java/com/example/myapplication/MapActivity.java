package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.models.MarkerItem;
import com.example.myapplication.models.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;
    Button menu_bt4;

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

    View.OnClickListener menu5_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MyActivity.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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


    @Override
    public void onMapReady(final GoogleMap map) {

        final RealmResults<MarkerItem> results = realm.where(MarkerItem.class).findAll();

        ArrayList<MarkerItem> sample = new ArrayList();

        for (MarkerItem markerItem : results) {
            sample.add(markerItem);
        }




        for(int i=0; i<sample.size(); i++){
            LatLng g = new LatLng(sample.get(i).getLat(), sample.get(i).getLon());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions
                    .position(g)
                    .title(sample.get(i).getTitle())
                    .snippet(sample.get(i).getAdd() + "," + sample.get(i).getPhone_num());

            BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.marker_icon);
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 70, 70, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

            map.addMarker(markerOptions);
        }



        map.setOnMarkerClickListener(this);




        //map.setOnMarkerClickListener(this);
        LatLng gg = new LatLng(37.403882, 126.931122);



        map.moveCamera(CameraUpdateFactory.newLatLng(gg));
        map.animateCamera(CameraUpdateFactory.zoomTo(17));


    }








    @Override
    public boolean onMarkerClick(Marker marker){
        Intent i = new Intent(getApplicationContext(), PlacepopupActivity.class);
        i.putExtra("title", marker.getTitle());
        i.putExtra("add_phone", marker.getSnippet());
        startActivity(i);
        return true;
    }
}
