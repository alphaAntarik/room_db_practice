package com.example.room_db_practice;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoDetails {

    @Insert
    void addDetails(personDetails pd);

    @Query("SELECT * FROM personDetails")
    List<personDetails> getAllDetails();


    @Query("DELETE FROM personDetails WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE personDetails SET name = :fname, title=:lname WHERE id = :id")
    void updateById(int id, String fname, String lname);
}
