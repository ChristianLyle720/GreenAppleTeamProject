package edu.utsa.cs3443.group_teamproject.model;

import java.util.ArrayList;
/**
 * @author Green Apple Inc.
 * This is a class which represents all of the question sets in the application
 * Stores list of QuestionSet objects which hold the Questions
 */
public class AllQuestionSets {
    private String user;
    private ArrayList<QuestionSet> questionSets;
    private static AllQuestionSets questionSetsInstance = null;
    /**
     * Constructor to create AllQuestionSets object, calls method to load data from files
     * @param user Name of the user of the app
     * @param setData ArrayList of Strings containing data from sets.csv
     * @param questionData ArrayList of Strings containing data from questions.csv
     */
    private AllQuestionSets(String user, ArrayList<String[]> setData, ArrayList<String[]> questionData){
        this.user = user;
        questionSets = new ArrayList<QuestionSet>();
        loadData(setData, questionData);
    }
    /**
     * Method to initialize the instance of AllQuestionSets and return it
     * @param user Name of the user of the app
     * @param setData ArrayList of Strings containing data from sets.csv
     * @param questionData ArrayList of Strings containing data from questions.csv
     * @return Initialized instance of AllQuestionSets
     */
    public static AllQuestionSets getQuestionSetsInstance(String user, ArrayList<String[]> setData, ArrayList<String[]> questionData){
        questionSetsInstance = new AllQuestionSets(user, setData, questionData);
        return questionSetsInstance;
    }
    /**
     * Method to return the instance of AllQuestionSets
     * @return The instance of AllQuestionSets
     */
    public static AllQuestionSets getQuestionSets(){
        return questionSetsInstance;
    }
    /**
     * Method to add a QuestionSet to the questionSets list
     * @param s The QuestionSet object to be added
     */
    public void addSet(QuestionSet s)
    {
        questionSets.add(s);
    }
     /**
     * Method to return the list of QuestionSets
     * @return The list of QuestionSets
     */
    public ArrayList<QuestionSet> getSets(){
        return questionSets;
    }
    /**
     * Method to return the list of Questions in a specified set
     * @param s The name of the set
     * @return The list of Questions in the specified set
     */
    public ArrayList<Question> getQuestionsBySet(String s){
        ArrayList<Question> questions = null;
        for(int i = 0; i < questionSets.size(); i++){
            if(questionSets.get(i).getName().equals(s)){
                questions = questionSets.get(i).getQuestions();
            }
        }
        return questions;
    }
    /**
     * Method to load the set and question data from sets.csv and zones.csv into AllQuestionSets
     * @param setData ArrayList of Strings containing data from sets.csv
     * @param questionData ArrayList of Strings containing data from questions.csv
     */
    private void loadData(ArrayList<String[]> setData, ArrayList<String[]> questionData){
        QuestionSet newSet = null;
        for(int i = 0; i < setData.size(); i++){
            newSet = new QuestionSet(setData.get(i)[0]);
            newSet.loadQuestions(questionData);
            addSet(newSet);
        }
    }
}
