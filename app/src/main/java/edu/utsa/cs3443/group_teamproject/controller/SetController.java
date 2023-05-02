package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

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
        AssetManager assetManager = context.getAssets();
        InputStream inSet = assetManager.open("sets.csv");
        ArrayList<String[]> setParts = StringLoader.loadData(inSet);
        InputStream inQuestions = assetManager.open("questions.csv");
        ArrayList<String[]> questionParts = StringLoader.loadData(inQuestions);
        AllQuestionSets.getQuestionSetsInstance(user, setParts, questionParts);
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
}
