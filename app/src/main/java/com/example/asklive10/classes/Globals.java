package com.example.asklive10.classes;

import android.app.Application;

import java.util.ArrayList;

public class Globals extends Application {

    private static User user;
    private static Group group;
    private static ArrayList<Comment> comments;

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

    public static void setComments(ArrayList<Comment> newComment) {
        comments=newComment;
    }

    public static ArrayList<Comment> getComments() { return comments; }

}
