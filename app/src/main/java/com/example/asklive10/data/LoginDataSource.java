package com.example.asklive10.data;

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

            if (email.equals(fakeUser.getEmail()) && password.equals(fakeUser.getPassword())) {
                boolean student = true;

                /*
                public Student(ArrayList<Question> myStrikeList,
                String myUserID, String myEmail, String myName, String myPassHash) {}
                 */
                //TODO: LOAD INFORMATION FROM DATABASE
                ArrayList<Question> myStrikeList = new ArrayList<Question>();
                String myUserID = fakeUser.getUserId();
                String myEmail = fakeUser.getEmail();
                String myName = fakeUser.getDisplayName();
                String myPass = fakeUser.getPassword();
                //TODO: ADD INSTRUCTOR OPTION
                Globals.setUser(new Student (myStrikeList, myUserID, myEmail, myName, myPass));

                return new Result.Success<>(fakeUser);
            } else {
                return new Result.Error(new IOException("Incorrect Login Credentials"));
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
