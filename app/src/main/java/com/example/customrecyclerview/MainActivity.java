package com.example.customrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private UserDataItem[] getUserData() {
        UserDataItem[] userDataItems = {
                new UserDataItem("Ekata", "Female", "9876057816", R.drawable.ekta),
                new UserDataItem("Akshar", "Male", "9054298682", R.drawable.akshar),
                new UserDataItem("Miloni", "Female", "9521679546", R.drawable.mili),
                new UserDataItem("Kishan", "Male", "9856879816", R.drawable.kishan),
                new UserDataItem("Vikita", "Female", "9521679546", R.drawable.vikita),
                new UserDataItem("Nirali", "Female", "8200232123", R.drawable.nirali),
        };
        return userDataItems;
    }

    UserDataAdapter userDataAdapter;
    RecyclerView idRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDataAdapter = new UserDataAdapter(this, getUserData());

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Gson gson = new Gson();
                String CheckJson = gson.toJson(userDataAdapter.userDataItemArrayList);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Data", CheckJson);
                startActivity(intent);
            }
        });

        idRecyclerview = (RecyclerView) findViewById(R.id.idRecyclerview);
        idRecyclerview.setAdapter(userDataAdapter);
        idRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        idRecyclerview.setItemAnimator(new DefaultItemAnimator());

        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}