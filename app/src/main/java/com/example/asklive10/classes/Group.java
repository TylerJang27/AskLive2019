package com.example.asklive10.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Date;

public class Group {

    private HashSet<String> students;
    private String groupID;
    private String studentJoinCode;
    private String instructorJoinCode;
    private HashSet<String> instructors;
    private Survey survey;
    private Date timeStart;
    private Date timeEnd;
    private ArrayList<String> questions;
    private ArrayList<Question> recentQuestions;
    private ArrayList<Question> nonrecentQuestions;
    private ArrayList<Comment> comments;
    private int currentID;

    //constructor for a Group
    public Group(HashSet<String> myStudents, String myGroupID, String myStudentJoinCode, String myInstructorJoinCode,
				 HashSet<String> myInstructors, Survey mySurvey, HashSet<Question> theQuestions) {
        this.students = myStudents;
        this.groupID = myGroupID;
        this.studentJoinCode = myStudentJoinCode;
        this.instructorJoinCode = myInstructorJoinCode;
        this.instructors = myInstructors;
        this.survey = mySurvey;
        this.timeStart = new Date();
        Date timeCopy = (Date) this.timeStart.clone();
        this.timeEnd = new Date(this.timeStart.getTime() + 3600000);
        currentID = 0;
        //TODO: Determine if this should be by Question s or String s
		//Maverick note - question should be good
		recentQuestions = new ArrayList<Question>();
        nonrecentQuestions = new ArrayList<Question>();
        questions = new ArrayList<String>();
        if  (theQuestions==null)
		{
			theQuestions = new HashSet<>();
			Question q1 = new Question("RTFM?", "Bob Ross", "def1");
			Question q2 = new Question("I accidentally my computer", "Hongyi Zhang", "def2");
			theQuestions.add(q1);
			theQuestions.add(q2);
		}
        for (Question s : theQuestions) {
            boolean recent = s.getRecency();
            boolean flagged = s.isFlagged();
            if (!flagged) {
                if (recent) {
                    recentQuestions.add(s);
                } else {
                    nonrecentQuestions.add(s);
                }
            }
            questions.add(s.toString());
            Collections.sort(recentQuestions);
            Collections.sort(nonrecentQuestions);
            Collections.sort(questions); //FIXME remove later? should sort by recent and time already
        }
    }

    //constructor called by CodeRetrieveModel
    public Group(HashSet<String> myStudents, String myGroupID, String myStudentJoinCode,
                 HashSet<String> myInstructors, Survey mySurvey, HashSet<Question> theQuestions) {
        this(myStudents, myGroupID, myStudentJoinCode, "0000", myInstructors, mySurvey, theQuestions);
    }

    //default constructor for a Group
    public Group(String myGroupID, String myStudentJoinCode, String myInstructorJoinCode, HashSet<String> myInstructors) {
        this(new HashSet<String>(), myGroupID, myStudentJoinCode, myInstructorJoinCode,
				myInstructors, new Survey(), null);
    }

    //default constructor for a Group
    public Group() {
        this(new HashSet<String>(), "0", "0", "0", new HashSet<String>(), new Survey(), null);
    }

    //adds a new student to the Group
    public void addStudent(String studentID) {
        this.students.add(studentID);
    }

    //adds a new instructor to the Group
    public void addInstructor(String instructorID) {
        this.instructors.add(instructorID);
    }

    public String getNextID()
	{
		return ""+ currentID++;
	}

    public String getGroupID()
    {
        return "" + currentID;
    }

	public void addQuestion(Question q)
	{
		if (q.getRecency())
		{
			recentQuestions.add(q);
		}
		nonrecentQuestions.add(q);
	}

	public void addComment(Comment c)
	{
		comments.add(c);
	}

	public ArrayList<Question> getRecents() {
        return recentQuestions;
    }

    public ArrayList<Question> getnonRecents() {
        return nonrecentQuestions;
    }
    public ArrayList<String> getQuestions() {
        return questions;
    }
}
