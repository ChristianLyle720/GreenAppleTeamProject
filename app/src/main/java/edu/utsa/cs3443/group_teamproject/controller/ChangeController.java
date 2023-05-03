package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.QuestionActivity;
import edu.utsa.cs3443.group_teamproject.R;
import edu.utsa.cs3443.group_teamproject.SetActivity;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.Question;
import edu.utsa.cs3443.group_teamproject.model.CSVProcessor;
import edu.utsa.cs3443.group_teamproject.model.QuestionSet;

public class ChangeController implements View.OnClickListener {
    private ChangeActivity ChangeActivity;
    private SetController SetController;
    private QuestionActivity questionActivity;
    private ArrayList<Question> setQuestions;

    public ChangeController(ArrayList<Question> setQuestions, ChangeActivity ChangeActivity, SetController SetController, QuestionActivity questionActivity) {
        this.setQuestions = setQuestions;
        this.ChangeActivity = ChangeActivity;
        this.SetController = SetController;
        this.questionActivity = questionActivity;
    }

    @Override
    public void onClick(View view) {
        String user = MainController.user;
        Intent i = new Intent(ChangeActivity, SetActivity.class);
        i.putExtra("user", user);
        i.putExtra("name", QuestionController.name);
        switch (view.getId()){
            case R.id.returnSetButton:
                ChangeActivity.startActivity(i);
                setQuestions.clear();
                break;
            case R.id.removeButton:
                int questionNumber = Integer.parseInt(ChangeActivity.removeQuestionNum.getText().toString())-1;
                String answer = setQuestions.get(questionNumber).getAnswer();
                CSVProcessor.remove(answer, "questions.csv", ChangeActivity);
                setQuestions.clear();
                break;
            case R.id.addButton:
                String addQuestion = ChangeActivity.addQuestion.getText().toString();
                String addAnswer = ChangeActivity.addAnswer.getText().toString();
                String name = QuestionController.name;
                CSVProcessor.addQuestion(addQuestion, addAnswer, name, ChangeActivity);
                setQuestions.clear();
                break;
        }
    }
}
