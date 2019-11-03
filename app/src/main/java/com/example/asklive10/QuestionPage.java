package com.example.asklive10;

import android.content.Intent;
import android.os.Bundle;

import com.example.asklive10.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asklive10.classes.*;

import java.util.ArrayList;

public class QuestionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Question currQuestion = Globals.getQuestion();
        ArrayList<String> comments = Globals.getComments();

        final TextView questText = (TextView) findViewById(R.id.QuestionText);
        questText.setText(currQuestion.getText());
        final TextView questTime = (TextView) findViewById(R.id.TimeAsk);
        questTime.setText(currQuestion.getTimestamp().toString());
        final TextView qUpVotes = (TextView) findViewById(R.id.qUpVotes);
        questTime.setText("" + currQuestion.getUpvotes());

        ListAdapter myCommentAdapter = new CustomAdapterComment(this, comments);
        ListView myCommentListView = (ListView)findViewById(R.id.commentListView);
        myCommentListView.setAdapter(myCommentAdapter);
        //TODO: ADD FORMATTING


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Session.class);
        startActivity(i);

    }

}
