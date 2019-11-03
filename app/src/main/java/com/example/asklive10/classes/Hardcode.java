package com.example.asklive10.classes;

import java.util.ArrayList;
import java.util.Date;

public class Hardcode {
    public static ArrayList<ArrayList<String>> users = new ArrayList<>();
    public static ArrayList<ArrayList<String>> groups = new ArrayList<>();
    public static ArrayList<ArrayList<String>> memberships = new ArrayList<>();
    public static ArrayList<ArrayList<String>> questions = new ArrayList<>();
    public static ArrayList<ArrayList<String>> comments = new ArrayList<>();

    public static String usercode = "1,Tyler Jang,taj26@duke.edu,kerchoo\n2,Prof Lee,lee@duke.edu,CS250\n" +
            "3,Hongyi Zhang,hz@duke.edu,123";
    public static String groupcode = "1,CS250,cpmac\n2,egr103,engin";
    public static String membercode = "1,1\n1,2\n2,1\n3,1";
    public static String questioncode = "";
    public static String commentcode = "2,6,5,1,10,No,10:36:00,false,false";

    /*
    users: id, name, pass
    groups: gid, code_s, code_i
    memberships: id, gid
    questions: id, qid, gid, votes, descr, time, resolved, flag, strike
    comment: id, cid, qid, gid, votes, descr, time, flag, strike
     */

    public static void addQuestion(Question q, String gid)
    {
        ArrayList<String> row = new ArrayList<>();
        row.add(q.getAskerID());
        row.add(q.getPostID());
        row.add(""+gid);
        row.add(""+q.getUpvotes());
        row.add(q.getText());
        row.add(q.getTimestamp().toString());
        row.add(""+q.getResolved());
        row.add(""+q.getFlagged());
        row.add(""+q.getStruck());
        questions.add(row);
    }

    public static void init()
    {
        Date now = new Date();
        long ms = now.getTime();
        Date then = new Date(ms-60*1000);
        Date more = new Date(ms-150*1000);
        questioncode = "1,4,1,0,When is HW4 due again?,"+now.toString()+",false,false,false\n"+
                "1,5,1,2,Will this midterm cover caches?,"+then.toString()+",false,false,false\n"+
                "1,2,1,1,Massive amounts of profanity,"+more.toString()+",false,true,true";
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

    public ArrayList<ArrayList<String>> getUserDB()
    {
        return users;
    }

    public ArrayList<ArrayList<String>> getGroupDB()
    {
        return groups;
    }

    public ArrayList<ArrayList<String>> getMembershipDB()
    {
        return memberships;
    }

    public ArrayList<ArrayList<String>> getQuestionDB()
    {
        return questions;
    }

    public ArrayList<ArrayList<String>> getCommentDB()
    {
        return comments;
    }
}
