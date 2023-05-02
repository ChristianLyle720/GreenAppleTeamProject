package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.QuestionActivity;

public class QuestionController implements View.OnClickListener {
    private String name;
    private String user;
    private String question;
    private String answer;
    private QuestionActivity questionActivity;
    private boolean changeScreen;
    public QuestionController(String name, String user, QuestionActivity questionActivity, boolean changeScreen){
        this.name = name;
        this.user = user;
        this.questionActivity = questionActivity;
        this.changeScreen = changeScreen;
    }
    public QuestionController(String name, String question, String answer, QuestionActivity questionActivity, boolean changeScreen){
        this.name = name;
        this.question = question;
        this.answer = answer;
        this.questionActivity = questionActivity;
        this.changeScreen = changeScreen;
    }

    public void onClick(View view){
        if(changeScreen){
            Intent intent = new Intent(questionActivity, ChangeActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("user", user);
            questionActivity.startActivity(intent);
        }
        else {
            Toast t;
            String answer = getAnswerText();
            t = Toast.makeText(view.getContext(), answer, Toast.LENGTH_SHORT);
            t.show();
        }
    }

    public String getSetText(){
        return user + "'s " + name + " set";
    }

    public String getQuestionText(int i){
        return (i+1) + ". " + question;
    }

    public String getAnswerText(){
        return answer;
    }

}
