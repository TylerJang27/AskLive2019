package com.example.asklive10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asklive10.R;
import com.example.asklive10.classes.Globals;
import com.example.asklive10.classes.Hardcode;
import com.example.asklive10.classes.Question;

import java.util.ArrayList;

public class AddQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
    }

    public void takeQuestion(View view){
        Intent i = new Intent(this, Session.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Question q = new Question(message, Globals.getUser().getUserID(), "00007"); // Post ID tbd
        Globals.setQuestion(q);
        startActivity(i);
    }


    public void onClick(View view) {
        Log.i("onClick", "hello my guy bleh1");
        final EditText class_code_input = findViewById(R.id.editText);
        final Button submitButton = findViewById(R.id.submit);
        Question ques = new Question(class_code_input.getText().toString(), Globals.getUser().getUserID(), "00007");
        //Globals.setQuestion(ques);
        Hardcode.addQuestion(ques, Globals.getGroup().getGroupID());

            //TODO: FIX ADDING QUESTIONS

        for (ArrayList<String> question: Hardcode.questions) {
            if (question.get(2).equals(Globals.getGroup().getGroupID())) {
                Question x = (new Question(question.get(0), question.get(4), question.get(1), question.get(3), question.get(6)));
                Globals.getGroup().addQuestion(x);
            }
        }

        Intent i = new Intent(this, Session.class);
        startActivity(i);
        //handle error
    }
}
