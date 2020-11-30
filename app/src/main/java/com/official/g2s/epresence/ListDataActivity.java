package com.official.g2s.epresence;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    com.official.g2s.epresence.DatabaseHelper mDatabaseHelper;
    private ListView mListView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        mListView=(ListView)findViewById(R.id.listView);
        mDatabaseHelper=new com.official.g2s.epresence.DatabaseHelper(this);

        populateListView();
        populateListViewTeacher();
    }

    private void populateListView(){

        Log.d(TAG, "populateListView: Displaying data in list view");

        Cursor data=mDatabaseHelper.getData();
        ArrayList<String> listData=new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }

        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);
    }


    private void populateListViewTeacher(){

        Log.d(TAG, "populateListView: Displaying data in list view");

        Cursor data=mDatabaseHelper.getTeacherData();
        ArrayList<String> listData=new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }

        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);
    }

}
