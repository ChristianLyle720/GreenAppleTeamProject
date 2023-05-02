package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.controller.ChangeController;
import edu.utsa.cs3443.group_teamproject.controller.QuestionController;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.Question;

public class ChangeActivity extends AppCompatActivity {

    private QuestionActivity QuestionActivity;
    public EditText removeQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Intent intent = getIntent();
        String setName = intent.getStringExtra("name");
        String userName = intent.getStringExtra("user");

        ArrayList<Question> setQuestions = AllQuestionSets.getQuestionSets().getQuestionsBySet(setName);

        ChangeController ChangeController = new ChangeController(setQuestions, this);
        Button startButton = findViewById(R.id.returnSetButton);
        startButton.setOnClickListener(ChangeController);

        Button removeButton = findViewById(R.id.removeButton);
        removeQuestion = findViewById(R.id.removeQuestionEditText);
        removeButton.setOnClickListener(ChangeController);

    }
}