package edu.utsa.cs3443.group_teamproject.model;


import java.util.ArrayList;

/**
 * QuestionSet is a class that represents a collection of questions.
 */
public class QuestionSet {
    private String name;
    private ArrayList<Question> Questions;

    /**
     * Constructor for QuestionSet.
     *
     * @param name the name of the question set
     */
    public QuestionSet(String name){
        this.name = name;
        Questions = new ArrayList<Question>();
    }

    /**
     * Returns the name of the question set.
     *
     * @return the name of the question set
     */
    public String getName(){
        return this.name;
    }

    public void setName(String n){
        name = n;
    }

    /**
     * Returns the list of questions in the question set.
     */
    public ArrayList<Question> getQuestions(){
        return Questions;
    }

    /**
     * Loads questions into the question set from the provided data.
     *
     * @param questionData an ArrayList of String arrays containing question data
     */
    public void loadQuestions(ArrayList<String[]> questionData){
        Question addQuestion = null;
        for(int i = 0; i < questionData.size(); i++){
            if(questionData.get(i)[2].equals(name)){
                addQuestion = new Question(questionData.get(i)[0], questionData.get(i)[1], questionData.get(i)[2]);
                Questions.add(addQuestion);
            }
        }
    }
}
