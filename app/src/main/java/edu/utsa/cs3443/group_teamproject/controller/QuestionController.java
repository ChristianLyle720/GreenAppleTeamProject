package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.QuestionActivity;
/**
 * @author Green Apple Inc.
 * QuestionController is a class responsible for handling interactions between SetActivity and the model classes.
 */
public class QuestionController implements View.OnClickListener {
    public static String name;
    private String user;
    private String question;
    private String answer;
    private QuestionActivity questionActivity;
    private boolean changeScreen;
    /**
     * Constructor to create a new QuestionController
     * @param name Name of the set of questions
     * @param user Name of user of the app
     * @param questionActivity The QuestionActivity instance
     * @param changeScreen Boolean for if the QuestionController is meant to change screens
     */
    public QuestionController(String name, String user, QuestionActivity questionActivity, boolean changeScreen){
        this.name = name;
        this.user = user;
        this.questionActivity = questionActivity;
        this.changeScreen = changeScreen;
    }
    /**
     * Constructor to create a new QuestionController
     * @param name Name of the set of questions
     * @param question A question being asked
     * @param answer The answer to the question
     * @param questionActivity The QuestionActivity instance
     * @param changeScreen Boolean for if the QuestionController is meant to change screens
     */
    public QuestionController(String name, String question, String answer, QuestionActivity questionActivity, boolean changeScreen){
        this.name = name;
        this.question = question;
        this.answer = answer;
        this.questionActivity = questionActivity;
        this.changeScreen = changeScreen;
    }
    /**
     * Handles click events on the UI buttons in the ChangeActivity.
     *  
     * @param view The view that was clicked.
     */
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
    /**
    * Method to return a string representation of current set and associated user
    * @return String representation of current set and associated user
    */
    public String getSetText(){
        return user + "'s " + name + " set";
    }
    /**
     * Method to return a string representation of a question
     * @param i The question number
     * @return String representation of the question
     */
    public String getQuestionText(int i){
        return (i+1) + ". " + question;
    }
    /**
     * Method to return a string representation of the answer to a question
     * @return String representation of the answer to a question
     */
    public String getAnswerText(){
        return answer;
    }

}
