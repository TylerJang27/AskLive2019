package com.example.asklive10.classes;

public class Question extends Post {
    private boolean isResolved;
    private String resolvedBy;

    public Question(String tex, String askID, String posID) {
        super(tex, askID, posID);
        isResolved = false;
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
