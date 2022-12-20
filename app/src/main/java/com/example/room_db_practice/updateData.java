package com.example.room_db_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateData extends AppCompatActivity {
    int id;
    EditText name, title;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        name = findViewById(R.id.editfname);
        title = findViewById(R.id.editlname);
        update = findViewById(R.id.btn);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        name.setText(getIntent().getStringExtra("name"));
        title.setText(getIntent().getStringExtra("title"));

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = Room.databaseBuilder(getApplicationContext(),
                        DatabaseHelper.class, "room_db").allowMainThreadQueries().build();
                DaoDetails userDao = db.dao();
                userDao.updateById(id,name.getText().toString(),title.getText().toString());

                startActivity(new Intent(getApplicationContext(),RV_activity.class));
                finish();

            }
        });





    }
}