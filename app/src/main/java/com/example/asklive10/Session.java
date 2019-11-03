package com.example.asklive10;

import android.content.Intent;
import android.os.Bundle;

import com.example.asklive10.classes.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
                toNext2();
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                 */
            }
        });
        Log.i("onCreate", "hello my guy leb");

        ArrayList<Question> recent = Globals.getGroup().getRecents();
        ArrayList<Question> nonrecent = Globals.getGroup().getnonRecents();

        ListAdapter myRecentAdapter = new ArrayAdapter<Question>(this, android.R.layout.simple_list_item_1, recent);
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

                        //TODO: query based on quid

                        Question dumbq = new Question("hey what on earth is going on?", "00001", "00002");
                        Comment dumbc1 = new Comment("i think this is what on earth is going on", "00002", dumbq, "00003");
                        Comment dumbc2 = new Comment("no, actually this is what on earth is going on", "00003", dumbq, "00004");
                        ArrayList<Comment> thisComm = new ArrayList<>();
                        thisComm.add(dumbc1);
                        thisComm.add(dumbc2);

                        Globals.setQuestion(dumbq);
                        Globals.setComments(thisComm);

                        toNext();

                    }
                }
        );

    }

    protected void toNext(){
        Intent i = new Intent(this, QuestionPage.class);
        startActivity(i);
    }
    protected void toNext2(){
        Intent i = new Intent(this, AddQuestion.class);
        startActivity(i);
    }

}
