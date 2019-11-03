package com.example.asklive10;

import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.asklive10.data.LoginRepository;
import com.example.asklive10.data.Result;
import com.example.asklive10.data.model.LoggedInUser;
import com.example.asklive10.R;
import com.example.asklive10.ui.login.LoggedInUserView;
import com.example.asklive10.ui.login.LoginResult;
import com.example.asklive10.classes.Globals;

import java.util.HashSet;

public class CodeRetrieveModel extends ViewModel {


    public boolean join(String classCode) {
        // can be launched in a separate asynchronous job
        //Result<LoggedInUser> result = loginRepository.login(username, password);
        //TODO: implement Result rather than boolean

        //TODO: implement query
        // if query successful:
        HashSet<String> myStudents = new HashSet<String>();
        String myGroupID = "001";
        String myStudentJoinCode = "100";

        //HashSet<String> myStudents, String myGroupID, String myStudentJoinCode, String myInstructorJoinCode,
        //				 HashSet<String> myInstructors, Survey mySurvey, HashSet<Question> theQuestions

        Globals.setGroup(new Group(____)) {

        }
    }
}
