package edu.utsa.cs3443.group_teamproject.model;

public class Question {
    private String question;
    private String answer;
    private String set;

    public Question(String question, String answer, String set){
        this.question = question;
        this.answer = answer;
        this.set = set;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String q){
        question = q;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String a){
        answer = a;
    }

    public String getSet(){
        return set;
    }

    public void setSet(String s){
        set = s;
    }
}
