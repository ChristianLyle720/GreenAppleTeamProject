package edu.utsa.cs3443.group_teamproject.model;
/**
 * @author Green Apple Inc.
 * This is a class which represents a question with a coressponding answer and a set it is related to
 */
public class Question {
    private String question;
    private String answer;
    private String set;
    /**
     * Constructor to create a new Question object
     * @param question The question being asked
     * @param answer Answer to the question
     * @param set Set the Question object is associated with
     */
    public Question(String question, String answer, String set){
        this.question = question;
        this.answer = answer;
        this.set = set;
    }
    /**
     * Method to return the question being asked
     * @return The question being asked
     */
    public String getQuestion(){
        return question;
    }
    /**
     * Method to set the question being asked
     * @param q The question to be set
     */
    public void setQuestion(String q){
        question = q;
    }
    /**
     * Method to get the answer to the question
     * @return The answer to the question
     */
    public String getAnswer(){
        return answer;
    }
    /**
     * Method to set the answer to the question
     * @param a The answer to be set
     */
    public void setAnswer(String a){
        answer = a;
    }
    /**
     * Method to get the set the Question is associated with
     * @return The set the question is associated with
     */
    public String getSet(){
        return set;
    }
    /**
     * Method to set the set the Question is associated with
     * @param s The name of the set to be set
     */
    public void setSet(String s){
        set = s;
    }
}
