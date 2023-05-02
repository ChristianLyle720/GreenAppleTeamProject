package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.R;
import edu.utsa.cs3443.group_teamproject.SetActivity;
import edu.utsa.cs3443.group_teamproject.model.Question;

public class ChangeController implements View.OnClickListener {
    private ChangeActivity ChangeActivity;
    private ArrayList<Question> setQuestions;

    public ChangeController(ArrayList<Question> setQuestions, ChangeActivity ChangeActivity) {
        this.setQuestions = setQuestions;
        this.ChangeActivity = ChangeActivity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.returnSetButton:
                String user = MainController.user;
                Intent i = new Intent(ChangeActivity, SetActivity.class);
                i.putExtra("user", user);
                ChangeActivity.startActivity(i);
            case R.id.removeButton:
                int questionNumber = Integer.parseInt(ChangeActivity.removeQuestion.getText().toString())-1;
                String question = setQuestions.get(questionNumber).getQuestion();
                Log.i("INFO", question);
        }
    }
}
