package edu.utsa.cs3443.group_teamproject.model;


import java.util.ArrayList;

public class QuestionSet {
    private String name;
    private ArrayList<Question> Questions;
    public QuestionSet(String name){
        this.name = name;
        Questions = new ArrayList<Question>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        name = n;
    }

    public ArrayList<Question> getQuestions(){
        return Questions;
    }

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
