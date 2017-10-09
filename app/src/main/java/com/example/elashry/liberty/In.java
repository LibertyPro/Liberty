package com.example.elashry.liberty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class In extends AppCompatActivity {
    String [] filmsNames = {"شرم الشيخ","الغردقه","العين السخنه"};
    String [] filmsRate = {"25$","100$","94$"};
    int [] filmsImg = {R.drawable.sharm,R.drawable.ghardaka,R.drawable.elsokhna};
    RecyclerView movieRecyclerView;
    RecyclerAdapter movieRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);
        movieRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        movieRecyclerAdapter = new RecyclerAdapter(In.this,filmsNames,filmsRate,filmsImg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);
        movieRecyclerView.setHasFixedSize(true);


        movieRecyclerView.setAdapter(movieRecyclerAdapter);
    }
}
