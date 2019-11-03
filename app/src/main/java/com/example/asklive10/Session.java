package com.example.asklive10;

import android.os.Bundle;

import com.example.asklive10.classes.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.asklive10.R;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import android.util.Log;

public class Session extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("onCreate", "hello my guy leb");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.i("onCreate", "hello my guy leb");

        ArrayList<String> recent = Globals.getGroup().getQuestions();
        //ArrayList<String> nonrecent = Globals.getGroup().getnonRecents();

        ListAdapter myRecentAdapter = new CustomAdapterComment(this, recent);
        ListView myRecentListView = (ListView)findViewById(R.id.myRecentListView);
        myRecentListView.setAdapter(myRecentAdapter);
        //TODO: ADD FORMATTING

        myRecentListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String clickedQID = Post.valueOf((Post)(parent.getItemAtPosition(position)));

                        //TODO: query the database for comments with that question ID
                        //store query result in Globals: setComments
                        //Do an intent
                        //Store extra intent information including Question information (see login for details)
                        //

                    }
                }
        );

    }

}
