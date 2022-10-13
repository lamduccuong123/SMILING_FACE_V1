package com.example.room_demo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class People {
    @PrimaryKey
    int _id;
    @ColumnInfo(name = "name")
    String _name;

    public People() {
    }

    public People(int id, String name) {
        this._id = id;
        this._name = name;
    }

    public People(String name) {
        this._name = name;
    }

    public int getID() {
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }
}