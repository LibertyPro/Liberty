package com.example.elashry.liberty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
public class Out extends AppCompatActivity {

    String [] filmsNames = {"دبي","ماليزيا","الصين","تركيا","تايلندا"};
    String [] filmsRate = {"25$","100$","94$","74$","6.5$"};
    int [] filmsImg = {R.drawable.dbia,R.drawable.malizya,R.drawable.elsen,R.drawable.torkya,R.drawable.tylanda};
    RecyclerView movieRecyclerView;
    RecyclerAdapter movieRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);

        movieRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        movieRecyclerAdapter = new RecyclerAdapter(Out.this,filmsNames,filmsRate,filmsImg);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);
        movieRecyclerView.setHasFixedSize(true);
        movieRecyclerView.setAdapter(movieRecyclerAdapter);
    }
}
