package com.example.room_db_practice;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {personDetails.class},  version = 1)
public abstract class DatabaseHelper extends RoomDatabase {


    public abstract  DaoDetails dao();

}
