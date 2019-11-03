package com.example.asklive10.classes;

import java.util.ArrayList;

public class Hardcode {
    private static ArrayList<ArrayList<String>> users = new ArrayList<>();
    private static ArrayList<ArrayList<String>> groups = new ArrayList<>();
    private static ArrayList<ArrayList<String>> memberships = new ArrayList<>();
    private static ArrayList<ArrayList<String>> questions = new ArrayList<>();
    private static ArrayList<ArrayList<String>> comments = new ArrayList<>();

    private static String usercode = "1,Tyler Jang,kerchoo\n2,Prof Lee,CS250\n3,Hongyi Zhang,123";
    private static String groupcode = "1,CS250,cpmac\n2,egr103,engin";
    private static String membercode = "1,1\n1,1\n2,1\n3,1";
    private static String questioncode = "1,4,1,0,When is HW4 due again?,10:30:00,false,false,false\n"+
            "1,5,1,2,Will this midterm cover caches?,10:32:00,false,false,false\n"+
            "1,2,1,1,Massive amounts of profanity,10:35:00,false,true,true";
    private static String commentcode = "2,6,5,1,10,No,10:36:00,false,false";

    /*
    users: id, name, pass
    groups: gid, code_s, code_i
    memberships: id, gid
    questions: id, qid, gid, votes, descr, time, resolved, flag, strike
    comment: id, cid, qid, gid, votes, descr, time, flag, strike
     */

    private static void init()
    {
        String[] codes = {usercode,groupcode,membercode,questioncode,commentcode};
        for (int i = 0; i< codes.length; i++)
        {
            String code = codes[i];
            ArrayList<String> row = new ArrayList<>();
            for (String line:code.split("\n"))
            {
                for (String entry: line.split(","))
                {
                    row.add(entry);
                }
            }
            switch (i) {
                case 0:
                    users.add(row);
                    break;
                case 1:
                    groups.add(row);
                    break;
                case 2:
                    memberships.add(row);
                    break;
                case 3:
                    questions.add(row);
                    break;
                case 4:
                    comments.add(row);
            }
        }
    }

    private ArrayList<ArrayList<String>> getUserDB()
    {
        return users;
    }

    private ArrayList<ArrayList<String>> getGroupDB()
    {
        return groups;
    }

    private ArrayList<ArrayList<String>> getMembershipDB()
    {
        return memberships;
    }

    private ArrayList<ArrayList<String>> getQuestionDB()
    {
        return questions;
    }

    private ArrayList<ArrayList<String>> getCommentDB()
    {
        return comments;
    }
}
