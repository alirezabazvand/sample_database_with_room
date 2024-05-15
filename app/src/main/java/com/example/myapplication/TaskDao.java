package com.example.myapplication;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(com.example.myapplication.Task task);

    @Query("SELECT * FROM Task")
    List<com.example.myapplication.Task> getAll();

    @Delete
    void deleteTask(com.example.myapplication.Task task);

    @Update
    void updateTask(com.example.myapplication.Task task);

}
