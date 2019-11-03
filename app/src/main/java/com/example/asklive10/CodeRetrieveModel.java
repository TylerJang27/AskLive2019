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
import com.example.asklive10.classes.*;

import java.util.HashSet;

public class CodeRetrieveModel extends ViewModel {

    public CodeRetrieveModel() {

    }

    public boolean join(String classCode) {
        // can be launched in a separate asynchronous job
        //Result<LoggedInUser> result = loginRepository.login(username, password);
        //TODO: implement Result rather than boolean

        //TODO: implement query
        // if query successful:
        HashSet<String> myStudents = new HashSet<String>();
        String myGroupID = "001";
        String myStudentJoinCode = "100";
        HashSet<String> myInstructors = new HashSet<String>();
        Survey mySurvey = new Survey();
        HashSet<Question> theQuestions = new HashSet<Question>();
        theQuestions.add(new Question("I am a question", "1231", "0001"));
        theQuestions.add(new Question("I am a question too", "1234", "0002"));
        theQuestions.add(new Question("I am a question, psych", "4121", "0003"));
        theQuestions.add(new Question("I am inevitable", "1010", "0004"));

        //HashSet<String> myStudents, String myGroupID, String myStudentJoinCode,
        //				 HashSet<String> myInstructors, Survey mySurvey, HashSet<Question> theQuestions

        Globals.setGroup(new Group(myStudents, myGroupID, myStudentJoinCode, myInstructors, mySurvey, theQuestions));
        return true;
    }
}
