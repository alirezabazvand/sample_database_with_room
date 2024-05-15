package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    private Button btn_main;
    private  MainAdapter mainAdapter;


    public static TaskDao taskDao;

    @Override
    protected void onResume() {
        super.onResume();
        mainAdapter.addTask( taskDao.getAll());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main = findViewById(R.id.rv_main);
        btn_main = findViewById(R.id.btn_main);
        taskDao = com.example.myapplication.AppDatabase.getAppDatabase(this).getTaskDao();

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.myapplication.AddTaskActivity.class);
                startActivity(intent);
            }
        });



        mainAdapter = new MainAdapter(taskDao.getAll());

        rv_main.setLayoutManager(new LinearLayoutManager(this));

        rv_main.setAdapter(mainAdapter);


    }
}