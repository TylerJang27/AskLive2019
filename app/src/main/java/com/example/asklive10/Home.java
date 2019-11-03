package com.example.asklive10;

import android.app.Activity;
import android.os.Bundle;

import com.example.asklive10.ui.login.LoginFormState;
import com.example.asklive10.ui.login.LoginResult;
import com.example.asklive10.ui.login.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import com.example.asklive10.R;
import com.example.asklive10.classes.*;

import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    private CodeRetrieveModel codeRetrieveModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //final TextView loginText = (TextView) findViewById(R.id.name);
        //loginText.setText(Globals.getUser().getName());

        final EditText class_code_input = findViewById(R.id.class_code);
        final Button submitButton = findViewById(R.id.submit_code);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(codeRetrieveModel.join(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString())) {

                }
            }
        });
    }




}
