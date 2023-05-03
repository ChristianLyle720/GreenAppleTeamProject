package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.controller.ChangeController;
import edu.utsa.cs3443.group_teamproject.controller.MainController;
import edu.utsa.cs3443.group_teamproject.controller.QuestionController;
import edu.utsa.cs3443.group_teamproject.controller.SetController;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.Question;

public class ChangeActivity extends AppCompatActivity {

    private QuestionActivity QuestionActivity;
    private SetController SetController;
    public EditText removeQuestionNum, addQuestion, addAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Intent intent = getIntent();
        String setName = intent.getStringExtra("name");

        ArrayList<Question> setQuestions = AllQuestionSets.getQuestionSets().getQuestionsBySet(setName);

        ChangeController changeController = new ChangeController(setQuestions, this, SetController, QuestionActivity);

        Button startButton = findViewById(R.id.returnSetButton);
        Button addButton = findViewById(R.id.addButton);
        Button removeButton = findViewById(R.id.removeButton);

        removeQuestionNum = findViewById(R.id.removeQuestionEditText);
        addQuestion = findViewById(R.id.addQuestionEditText);
        addAnswer = findViewById(R.id.addAnswerEditText);

        startButton.setOnClickListener(changeController);
        removeButton.setOnClickListener(changeController);
        addButton.setOnClickListener(changeController);

    }
}