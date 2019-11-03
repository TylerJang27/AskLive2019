package com.example.asklive10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.asklive10.ui.login.LoginActivity;
import com.example.asklive10.ui.login.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.asklive10.R;
import com.example.asklive10.classes.*;

import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;
import com.example.asklive10.Session;

public class Home extends AppCompatActivity {

    private CodeRetrieveModel codeRetrieveModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //final TextView loginText = (TextView) findViewById(R.id.name);
        //loginText.setText(Globals.getUser().getName());

        /*final EditText class_code_input = findViewById(R.id.class_code);
        final Button submitButton = findViewById(R.id.submit_code);
        Log.i("onCreate", "hello my guy bleh1");

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onCreate", "hello my guy bleh2");
                if(codeRetrieveModel.join(class_code_input.getText().toString())) {
                    nextPlease();
                }
        });
        */
    }
    public void onClick(View view) {
        Log.i("onClick", "hello my guy bleh1");
        codeRetrieveModel = new CodeRetrieveModel();
        final EditText class_code_input = findViewById(R.id.class_code);
        final Button submitButton = findViewById(R.id.submit_code);
        if(codeRetrieveModel.join(class_code_input.getText().toString())) {
            Log.i("onClick", "hello my guy bleh2");
            Intent i = new Intent(this, Session.class);
            startActivity(i);
        }
        //handle error
    }

    private void nextPlease() {
        Log.i("nextPlease", "hello my guy bleh");
        Intent i = new Intent(this, Session.class);
        startActivity(i);
    }




}
