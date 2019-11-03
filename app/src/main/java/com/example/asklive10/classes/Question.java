package com.example.asklive10.classes;

import java.text.DateFormat;
import java.text.ParseException;

public class Question extends Post {
    private boolean isResolved;
    private String resolvedBy;

    public Question(String tex, String askID, String posID) {
        super(tex, askID, posID);
        isResolved = false;
    }

    public Question(String postID, String text, String askID, String upVotes, String timeStamp) {
        this(text, askID, postID);
        upvotes = Integer.parseInt(upVotes);
        DateFormat df = DateFormat.getDateInstance();
        try {
            timestamp = df.parse(timeStamp);
        } catch (ParseException e) {
        }

    }

    public Post resolve(User user) {
        if (isResolved) {
            return this;
        }
        isResolved = true;
        resolvedBy = user.getUserID();
        return this;
    }

    public boolean getResolved() {
        return isResolved;
    }

}
