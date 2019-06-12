package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.models.Place;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

public class PlaceRecyclerAdapter extends RealmRecyclerViewAdapter<Place, PlaceRecyclerAdapter.StudentViewHolder> {

    public PlaceRecyclerAdapter(
            @Nullable OrderedRealmCollection<Place> data) {
        super(data, true);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // ViewHolder 만드는 부분
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_place, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder studentViewHolder, final int position) {
        // 실제로 화면에 뿌려주는 부분
        final Place place = getItem(position);
        studentViewHolder.nameTextView.setText(place.getName());
        studentViewHolder.ageTextView.setText(place.getAddress());
        studentViewHolder.phoneTextView.setText(place.getPhone());

        studentViewHolder.del_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                place.deleteFromRealm();
                realm.commitTransaction();
            }
        });



    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView ageTextView;
        public TextView phoneTextView;
        public Button del_bt;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text);
            ageTextView = itemView.findViewById(R.id.age_text);
            phoneTextView = itemView.findViewById(R.id.phone_num);
            del_bt = itemView.findViewById(R.id.delete_bt);


        }


    }






}

