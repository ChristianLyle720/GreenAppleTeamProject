package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.QuestionActivity;
import edu.utsa.cs3443.group_teamproject.SetActivity;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.StringLoader;

/**
 * SetController is a class responsible for handling interactions between SetActivity and the model classes.
 */
public class SetController implements View.OnClickListener{
    private String name;
    private String user;
    private Context context;
    private SetActivity setActivity;

    /**
     * Constructor for SetController.
     *
     * @param user       the user name
     * @param c          the application context
     * @param setActivity the SetActivity instance
     */
    public SetController(String user, Context c, SetActivity setActivity){
        this.user = user;
        context = c;
        this.setActivity = setActivity;
    }

    /**
     * Constructor for SetController.
     *
     * @param name        the name of the set
     * @param user        the user name
     * @param c           the application context
     * @param setActivity the SetActivity instance
     */
    public SetController(String name, String user, Context c, SetActivity setActivity){
        this.name = name;
        this.user = user;
        context = c;
        this.setActivity = setActivity;
    }
    /**
     * Handles click events on the UI buttons in the ChangeActivity.
     *
     * @param view The view that was clicked.
     */
    public void onClick(View view){
        Intent intent = new Intent(setActivity, QuestionActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("user", user);
        setActivity.startActivity(intent);
    }

    /**
     * Loads data from the CSV files into the model.
     *
     * @throws IOException if there's an error reading the CSV files
     */
    public void loadData() throws IOException {
        try {
            ArrayList<String[]> questionParts = null;
            InputStream inSet = context.openFileInput("sets.csv");
            ArrayList<String[]> setParts = StringLoader.loadData(inSet);
            InputStream inputStream = context.openFileInput("questions.csv");
            questionParts = StringLoader.loadData(inputStream);
            AllQuestionSets.getQuestionSetsInstance(user, setParts, questionParts);
            inputStream.close();
        } catch (FileNotFoundException e) {

        }
    }

    /**
     * Returns the user text for the question sets.
     *
     * @return the user text
     */
    public String getUserText(){
        if(user.equals("")){
            return "Question Sets";
        }
        return user + "'s Questions Sets";
    }

    public String getSetText(){
        return name + " Set";
    }

    public String getSet(){return this.name;}
}
