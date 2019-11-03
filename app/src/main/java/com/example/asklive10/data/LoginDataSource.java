package com.example.asklive10.data;

import android.util.Log;

import com.example.asklive10.data.model.LoggedInUser;

import java.io.IOException;
import com.example.asklive10.classes.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String email, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser("Jane Doe", "0001", "example@example.com", "password");
                    //implement login credentials, store userID

            //OLD IMPLEMENTATION if (email.equals(fakeUser.getEmail()) && password.equals(fakeUser.getPassword())) {
                //OLD IMPLEMENTATIONboolean student = true;

                /*
                public Student(ArrayList<Question> myStrikeList,
                String myUserID, String myEmail, String myName, String myPassHash) {}
                 */
                //TODO: LOAD INFORMATION FROM DATABASE
                Hardcode.init();
                ArrayList<ArrayList<String>> userList = Hardcode.users;
                Log.i("login", "aaaa" + userList.size() + "pleaseee");
                for (ArrayList<String> user: userList) {
                    Log.i("login", "aaaa" + user.get(1));
                    if (user.get(2).equals(email)) {
                        Log.i("login", "aaaa" + user.get(1) + "email");
                        if (user.get(3).equals(password)) {
                            Log.i("login", "aaaa" + user.get(1) + "pass");
                            ArrayList<Question> myStrikeList = new ArrayList<Question>();
                            String myUserID = user.get(0);
                            String myEmail = user.get(2);
                            String myName = user.get(1);
                            String myPass = user.get(3);
                            //TODO: ADD INSTRUCTOR OPTION
                            Globals.setUser(new Student (myStrikeList, myUserID, myEmail, myName, myPass));

                            return new Result.Success<>(fakeUser);
                        }
                        return new Result.Error(new IOException("Incorrect Login Credentials"));
                    }
                }
                return new Result.Error(new IOException("Incorrect Login Credentials"));

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
