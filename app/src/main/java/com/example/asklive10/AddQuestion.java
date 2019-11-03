package com.example.asklive10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.asklive10.R;
import com.example.asklive10.classes.Globals;
import com.example.asklive10.classes.Question;

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
}
