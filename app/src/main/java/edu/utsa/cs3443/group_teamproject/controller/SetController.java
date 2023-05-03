package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.QuestionActivity;
import edu.utsa.cs3443.group_teamproject.SetActivity;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.StringLoader;

public class SetController implements View.OnClickListener{
    private String name;
    private String user;
    private Context context;
    private SetActivity setActivity;

    public SetController(String user, Context c){
        this.user = user;
        context = c;
    }

    public SetController(String user, Context c, SetActivity setActivity){
        this.user = user;
        context = c;
        this.setActivity = setActivity;
    }
    public SetController(String name, String user, Context c, SetActivity setActivity){
        this.name = name;
        this.user = user;
        context = c;
        this.setActivity = setActivity;
    }

    public void onClick(View view){
        Intent intent = new Intent(setActivity, QuestionActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("user", user);
        setActivity.startActivity(intent);
    }

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
