package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.controller.QuestionController;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.Question;

public class QuestionActivity extends AppCompatActivity {
    private TextView setTextView;
    private TextView question1TextView;
    private TextView question2TextView;
    private TextView question3TextView;
    private TextView question4TextView;
    private TextView question5TextView;
    private TextView question6TextView;
    private TextView question7TextView;
    private TextView question8TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setTextView = findViewById(R.id.userQuestionTextView);
        question1TextView = findViewById(R.id.questionTextView1);
        question2TextView = findViewById(R.id.questionTextView2);
        question3TextView = findViewById(R.id.questionTextView3);
        question4TextView = findViewById(R.id.questionTextView4);
        question5TextView = findViewById(R.id.questionTextView5);
        question6TextView = findViewById(R.id.questionTextView6);
        question7TextView = findViewById(R.id.questionTextView7);
        question8TextView = findViewById(R.id.questionTextView8);
        ArrayList<TextView> questionTextViews = new ArrayList<TextView>();
        questionTextViews.add(question1TextView);
        questionTextViews.add(question2TextView);
        questionTextViews.add(question3TextView);
        questionTextViews.add(question4TextView);
        questionTextViews.add(question5TextView);
        questionTextViews.add(question6TextView);
        questionTextViews.add(question7TextView);
        questionTextViews.add(question8TextView);
        Intent intent = getIntent();
        String setName = intent.getStringExtra("name");
        String userName = intent.getStringExtra("user");

        QuestionController generalController = new QuestionController(setName, userName, this, true);
        Button changeButton = findViewById(R.id.changeActivityButton);
        changeButton.setOnClickListener(generalController);
        String display = generalController.getSetText();
        setTextView.setText(display);

        QuestionController questionController1 = null;
        QuestionController questionController2 = null;
        QuestionController questionController3 = null;
        QuestionController questionController4 = null;
        QuestionController questionController5 = null;
        QuestionController questionController6 = null;
        QuestionController questionController7 = null;
        QuestionController questionController8 = null;


        Button answerButton1 = findViewById(R.id.answerButton1);
        Button answerButton2 = findViewById(R.id.answerButton2);
        Button answerButton3 = findViewById(R.id.answerButton3);
        Button answerButton4 = findViewById(R.id.answerButton4);
        Button answerButton5 = findViewById(R.id.answerButton5);
        Button answerButton6 = findViewById(R.id.answerButton6);
        Button answerButton7 = findViewById(R.id.answerButton7);
        Button answerButton8 = findViewById(R.id.answerButton8);
        ArrayList<Button> answerButtons = new ArrayList<Button>();
        answerButtons.add(answerButton1);
        answerButtons.add(answerButton2);
        answerButtons.add(answerButton3);
        answerButtons.add(answerButton4);
        answerButtons.add(answerButton5);
        answerButtons.add(answerButton6);
        answerButtons.add(answerButton7);
        answerButtons.add(answerButton8);

        ArrayList<Question> setQuestions = AllQuestionSets.getQuestionSets().getQuestionsBySet(setName);
        int loadedQuestions = 0;
        if(setQuestions.size() > 0) {
            questionController1 = new QuestionController(setName, setQuestions.get(0).getQuestion(), setQuestions.get(0).getAnswer(), this, false);
            answerButton1.setOnClickListener(questionController1);
            loadedQuestions++;
        }
        if(setQuestions.size() > 1) {
            questionController2 = new QuestionController(setName, setQuestions.get(1).getQuestion(), setQuestions.get(1).getAnswer(), this, false);
            answerButton2.setOnClickListener(questionController2);
            loadedQuestions++;
        }
        if(setQuestions.size() > 2) {
            questionController3 = new QuestionController(setName, setQuestions.get(2).getQuestion(), setQuestions.get(2).getAnswer(), this, false);
            answerButton3.setOnClickListener(questionController3);
            loadedQuestions++;
        }
        if(setQuestions.size() > 3) {
            questionController4 = new QuestionController(setName, setQuestions.get(3).getQuestion(), setQuestions.get(3).getAnswer(), this, false);
            answerButton4.setOnClickListener(questionController4);
            loadedQuestions++;
        }
        if(setQuestions.size() > 4) {
            questionController5 = new QuestionController(setName, setQuestions.get(4).getQuestion(), setQuestions.get(4).getAnswer(), this, false);
            answerButton5.setOnClickListener(questionController5);
            loadedQuestions++;
        }
        if(setQuestions.size() > 5) {
            questionController6 = new QuestionController(setName, setQuestions.get(5).getQuestion(), setQuestions.get(5).getAnswer(), this, false);
            answerButton6.setOnClickListener(questionController6);
            loadedQuestions++;
        }
        if(setQuestions.size() > 6) {
            questionController7 = new QuestionController(setName, setQuestions.get(6).getQuestion(), setQuestions.get(6).getAnswer(), this, false);
            answerButton7.setOnClickListener(questionController7);
            loadedQuestions++;
        }
        if(setQuestions.size() > 7) {
            questionController8 = new QuestionController(setName, setQuestions.get(7).getQuestion(), setQuestions.get(7).getAnswer(), this, false);
            answerButton8.setOnClickListener(questionController8);
            loadedQuestions++;
        }
        ArrayList<QuestionController> questionControllers = new ArrayList<QuestionController>();
        questionControllers.add(questionController1);
        questionControllers.add(questionController2);
        questionControllers.add(questionController3);
        questionControllers.add(questionController4);
        questionControllers.add(questionController5);
        questionControllers.add(questionController6);
        questionControllers.add(questionController7);
        questionControllers.add(questionController8);

        while(loadedQuestions < 8){
            answerButtons.get(loadedQuestions).setVisibility(View.GONE);
            loadedQuestions++;
        }

        for(int i = 0; i < setQuestions.size(); i++){
            display = questionControllers.get(i).getQuestionText(i);
            setQuestionTextView(questionTextViews.get(i), display);
        }

    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...

    }

    public void setQuestionTextView(TextView setText, String display){
        setText.setText(display);
    }
}