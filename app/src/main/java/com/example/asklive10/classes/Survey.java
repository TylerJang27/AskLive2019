package com.example.asklive10.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Survey extends Post {
    private HashMap<String, ArrayList<String>> responses;

    public Survey(String tex, String[] options) {
        super(tex, "Capital-G God", "the best possible ID");
        upvotes = Integer.MAX_VALUE;
        isRecent = true;
        responses = new HashMap<String, ArrayList<String>>();
        for (String option : options) {
            if (!responses.containsKey(option)) {
                responses.put(option, new ArrayList<String>());
            }
        }
    }

    public Survey() {
        this("", new String[0]);
        responses.put("default survey option", new ArrayList<String>());
    }

    @Override
    public boolean getRecency() {
        return true;
    }

    public void vote(String option, String userID) {
        Set<String> options = responses.keySet();
        if (!responses.containsKey(option)) return;
        for (String o: options)
        {
            ArrayList<String> studentList = responses.get(o);
                studentList.remove(userID);
        }
        ArrayList<String> list = responses.get(option);
        list.add(userID);
    }

    public int getVotes(String option)
    {
        if (!responses.containsKey(option)) return -1;
        return responses.get(option).size();
    }
}
