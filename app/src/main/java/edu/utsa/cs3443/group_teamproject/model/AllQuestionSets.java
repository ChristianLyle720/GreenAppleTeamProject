package edu.utsa.cs3443.group_teamproject.model;

import java.util.ArrayList;

public class AllQuestionSets {
    private String user;
    private ArrayList<QuestionSet> questionSets;
    private static AllQuestionSets questionSetsInstance = null;

    private AllQuestionSets(String user, ArrayList<String[]> setData, ArrayList<String[]> questionData){
        this.user = user;
        questionSets = new ArrayList<QuestionSet>();
        loadData(setData, questionData);
    }

    public static AllQuestionSets getQuestionSetsInstance(String user, ArrayList<String[]> setData, ArrayList<String[]> questionData){
        questionSetsInstance = new AllQuestionSets(user, setData, questionData);
        return questionSetsInstance;
    }

    public static AllQuestionSets getQuestionSets(){
        return questionSetsInstance;
    }
    public void addSet(QuestionSet s)
    {
        questionSets.add(s);
    }
    public ArrayList<QuestionSet> getSets(){
        return questionSets;
    }

    public ArrayList<Question> getQuestionsBySet(String s){
        ArrayList<Question> questions = null;
        for(int i = 0; i < questionSets.size(); i++){
            if(questionSets.get(i).getName().equals(s)){
                questions = questionSets.get(i).getQuestions();
            }
        }
        return questions;
    }

    private void loadData(ArrayList<String[]> setData, ArrayList<String[]> questionData){
        QuestionSet newSet = null;
        for(int i = 0; i < setData.size(); i++){
            newSet = new QuestionSet(setData.get(i)[0]);
            newSet.loadQuestions(questionData);
            addSet(newSet);
        }
    }
}
