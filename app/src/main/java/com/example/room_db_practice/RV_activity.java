package com.example.room_db_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RV_activity extends AppCompatActivity {
    RecyclerView rview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);



        getroomdata();
    }

    public void getroomdata()
    {
        DatabaseHelper db = Room.databaseBuilder(getApplicationContext(),
                DatabaseHelper.class, "room_db").allowMainThreadQueries().build();
        DaoDetails userDao = db.dao();

        rview=findViewById(R.id.rview);
        rview.setLayoutManager(new LinearLayoutManager(this));

        List<personDetails> details_user=userDao.getAllDetails();

        MyAdapter adapter=new MyAdapter(details_user);
        rview.setAdapter(adapter);
    }
}