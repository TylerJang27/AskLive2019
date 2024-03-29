package com.example.asklive10.classes;

import android.app.Application;

import java.util.ArrayList;

public class Globals extends Application {

    private static User user;
    private static Group group;
    private static Question thisQuestion;
    private static ArrayList<String> comments;

    public static User getUser() {
        return user;
    }

    public static Group getGroup() {
        return group;
    }

    public static void setUser(User newUser) {
        user = newUser;
    }

    public static void setGroup(Group newGroup) {
        group = newGroup;
    }

    public static void setQuestion(Question question) {
        thisQuestion = question;
    }

    public static void setComments(ArrayList<String> newComment) {
        comments=newComment;
    }

    public static ArrayList<String> getComments() { return comments; }

    public static Question getQuestion() { return thisQuestion; }

}
