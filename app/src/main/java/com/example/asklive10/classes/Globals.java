package com.example.asklive10.classes;

import android.app.Application;

public class Globals extends Application {

    private static User user;
    private static Group group;

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

}
