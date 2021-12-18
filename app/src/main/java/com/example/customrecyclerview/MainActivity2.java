package com.example.customrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    String UserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        UserData = intent.getStringExtra("Data");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<UserDataItem>>(){}.getType();
        List<UserDataItem> userList = gson.fromJson(UserData, listType);

        RecyclerView idrecyclerview = (RecyclerView) findViewById(R.id.idrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
        ReceiveDataAdapter receiveDataAdapter = new ReceiveDataAdapter(userList);
        idrecyclerview.setAdapter(receiveDataAdapter);
        idrecyclerview.setLayoutManager(layoutManager);

        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}