package com.example.asklive10.classes;

import java.text.DateFormat;
import java.text.ParseException;

public class Comment extends Post {
    private boolean instructor;
    private String parentID;

    public Comment(String tex, String authorID, Post parent, String posID) {
        super(tex, authorID, posID);
        parentID = parent.getPostID();
        instructor = false;
    }

    public Comment(String tex, User author, Post parent, String posID) {
        this(tex, author.getUserID(), parent, posID);
        if (author instanceof Instructor) {
            isRecent = true;
            upvotes = Integer.MAX_VALUE;
            instructor = true;
        }
    }

    public Comment(String postID, String text, String askID, String upVotes, String timeStamp) {
        this(text, askID, null, postID);
        upvotes = Integer.parseInt(upVotes);
        DateFormat df = DateFormat.getDateInstance();
        try {
            timestamp = df.parse(timeStamp);
        } catch (ParseException e) {
        }

    }

    @Override
    public boolean getRecency() {
        return true;
    }

    public boolean isInstructor() {
        return instructor;
    }
}
