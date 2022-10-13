package com.example.room_demo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PeopleDao {

    @Query("SELECT * FROM people")
    List<People> getAll();

    @Query("SELECT * FROM people WHERE _id IN (:userIds)")
    List<People> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM people WHERE name LIKE :name")
    People findByName(String name);

    @Insert
    void insertAll(People... people);

    @Delete
    void delete(People people);
}
