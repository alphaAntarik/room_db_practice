package com.example.room_db_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,title;
    Button save_btn,view_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_);
        title = findViewById(R.id.title_);
        save_btn = findViewById(R.id.savebtn);
        view_btn = findViewById(R.id.viewbtn);



        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = Room.databaseBuilder(getApplicationContext(),
                        DatabaseHelper.class, "room_db").allowMainThreadQueries().build();
                DaoDetails userDao = db.dao();
                userDao.addDetails(new personDetails(name.getText().toString(), title.getText().toString()));
                name.setText("");
                title.setText("");

                Toast.makeText(getApplicationContext(),"Inserted successfully",Toast.LENGTH_LONG).show();

            }


        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RV_activity.class);
                startActivity(intent);

            }
        });



    }
}