package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.models.MarkerItem;
import com.example.myapplication.models.Place;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

public class DBRecyclerAdapter extends RealmRecyclerViewAdapter<MarkerItem, DBRecyclerAdapter.StudentViewHolder> {

    public DBRecyclerAdapter(
            @Nullable OrderedRealmCollection<MarkerItem> data) {
        super(data, true);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // ViewHolder 만드는 부분
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_db, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder studentViewHolder, final int position) {
        // 실제로 화면에 뿌려주는 부분
        final MarkerItem markerItem = getItem(position);
        studentViewHolder.nameTextView.setText(markerItem.getTitle());
        studentViewHolder.ageTextView.setText(markerItem.getAdd());
        studentViewHolder.phoneTextView.setText(markerItem.getPhone_num());
        studentViewHolder.lon_text.setText(Double.toString(markerItem.getLat()));
        studentViewHolder.lat_text.setText(Double.toString(markerItem.getLat()));

        studentViewHolder.del_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                markerItem.deleteFromRealm();
                realm.commitTransaction();
            }
        });



    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView ageTextView;
        public TextView phoneTextView;
        public TextView lon_text;
        public TextView lat_text;
        public Button del_bt;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text);
            ageTextView = itemView.findViewById(R.id.age_text);
            phoneTextView = itemView.findViewById(R.id.phone_num);
            lat_text = itemView.findViewById(R.id.lat_text);
            lon_text = itemView.findViewById(R.id.lon_text);
            del_bt = itemView.findViewById(R.id.delete_bt);


        }


    }






}

