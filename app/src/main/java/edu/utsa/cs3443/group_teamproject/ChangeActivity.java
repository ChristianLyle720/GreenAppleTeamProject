/**
 * ChangeActivity allows users to modify a question set by adding, removing, or changing questions
 * and their respective answers. This activity handles the UI elements and user interactions
 * for making these changes.
 */
package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.controller.ChangeController;
import edu.utsa.cs3443.group_teamproject.controller.QuestionController;
import edu.utsa.cs3443.group_teamproject.controller.SetController;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;
import edu.utsa.cs3443.group_teamproject.model.Question;

public class ChangeActivity extends AppCompatActivity {

    // Declare instance variables
    private QuestionActivity QuestionActivity;
    private SetController SetController;
    public EditText removeQuestionNum, addQuestion, addAnswer, changeQuestion, changeAnswer, changeQuestionNum;
    public TextView changeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        // Get the name of the set to be changed from the intent
        Intent intent = getIntent();
        String setName = intent.getStringExtra("name");

        // Get the list of questions in the set
        ArrayList<Question> setQuestions = AllQuestionSets.getQuestionSets().getQuestionsBySet(setName);

        // Create a change controller with the list of questions and the activity's context
        ChangeController changeController = new ChangeController(setQuestions, this, SetController, QuestionActivity);

        // Get references to the UI elements
        Button startButton = findViewById(R.id.returnSetButton);
        Button addButton = findViewById(R.id.addButton);
        Button removeButton = findViewById(R.id.removeButton);
        Button changeButton = findViewById(R.id.changeButton);

        removeQuestionNum = findViewById(R.id.removeQuestionEditText);
        addQuestion = findViewById(R.id.addQuestionEditText);
        addAnswer = findViewById(R.id.addAnswerEditText);
        changeQuestion  = findViewById(R.id.changeNewQuestionEditText);
        changeAnswer  = findViewById(R.id.changeNewAnswerEditText);
        changeQuestionNum  = findViewById(R.id.changeQuestionNumberEditText);
        changeSet  = findViewById(R.id.changeSetTextView);

        // Set the text of the changeSet TextView to the name of the set being changed
        changeSet.setText(QuestionController.name);

        // Set the click listeners for the buttons
        startButton.setOnClickListener(changeController);
        removeButton.setOnClickListener(changeController);
        addButton.setOnClickListener(changeController);
        changeButton.setOnClickListener(changeController);
    }
}
