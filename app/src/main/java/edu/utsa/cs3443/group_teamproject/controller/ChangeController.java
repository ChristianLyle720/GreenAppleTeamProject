/**
 * @author Green Apple Inc.
 * ChangeController handles the click events and actions for the ChangeActivity UI,
 * which allows users to modify a question set by adding, removing, or changing
 * questions and their respective answers. This controller is responsible for managing
 * the interactions between the UI elements and the underlying data model.
 */
package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.QuestionActivity;
import edu.utsa.cs3443.group_teamproject.R;
import edu.utsa.cs3443.group_teamproject.SetActivity;
import edu.utsa.cs3443.group_teamproject.model.Question;
import edu.utsa.cs3443.group_teamproject.model.CSVProcessor;

public class ChangeController implements View.OnClickListener {
    private ChangeActivity ChangeActivity;
    private SetController SetController;
    private QuestionActivity questionActivity;
    private ArrayList<Question> setQuestions;

    /**
     * Constructor for the ChangeController.
     *
     * @param setQuestions The list of questions in the set being edited.
     * @param ChangeActivity The ChangeActivity instance.
     * @param SetController The SetController instance.
     * @param questionActivity The QuestionActivity instance.
     */
    public ChangeController(ArrayList<Question> setQuestions, ChangeActivity ChangeActivity, SetController SetController, QuestionActivity questionActivity) {
        this.setQuestions = setQuestions;
        this.ChangeActivity = ChangeActivity;
        this.SetController = SetController;
        this.questionActivity = questionActivity;
    }

    /**
     * Handles click events on the UI buttons in the ChangeActivity.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        String user = MainController.user;
        String name = QuestionController.name;
        Toast t;

        // Create an intent to navigate to the SetActivity
        Intent i = new Intent(ChangeActivity, SetActivity.class);
        i.putExtra("user", user);
        i.putExtra("name", QuestionController.name);

        switch (view.getId()) {
            case R.id.returnSetButton:
                // Return to the SetActivity
                ChangeActivity.startActivity(i);
                setQuestions.clear();
                break;
            case R.id.removeButton:
                try {
                    // Remove a question from the set
                    int removeQuestionNumber = Integer.parseInt(ChangeActivity.removeQuestionNum.getText().toString()) - 1;
                    String answer = setQuestions.get(removeQuestionNumber).getAnswer();

                    // Remove the question from the CSV file
                    CSVProcessor.removeQuestion(answer, "questions.csv", ChangeActivity);
                    t = Toast.makeText(view.getContext(), "Successfully removed question!", Toast.LENGTH_SHORT);
                    t.show();
                    setQuestions.clear();
                } catch (Exception e) {
                    t = Toast.makeText(view.getContext(), "Remove Question Failed!", Toast.LENGTH_SHORT);
                    t.show();
                    setQuestions.clear();
                }
                break;
            case R.id.addButton:
                // Add a question to the set
                String addQuestion = ChangeActivity.addQuestion.getText().toString();
                String addAnswer = ChangeActivity.addAnswer.getText().toString();

                // Add the question to the CSV file
                CSVProcessor.addQuestion(addQuestion, addAnswer, name, ChangeActivity);
                t = Toast.makeText(view.getContext(), "Successfully added question!", Toast.LENGTH_SHORT);
                t.show();
                setQuestions.clear();
                break;
            case R.id.changeButton:
                try {
                    // Replace a question in the set with a new one
                    int changeQuestionNumber = Integer.parseInt(ChangeActivity.changeQuestionNum.getText().toString()) - 1;
                    String currentQuestion = setQuestions.get(changeQuestionNumber).getQuestion();
                    String changeQuestion = ChangeActivity.changeQuestion.getText().toString();
                    String changeAnswer = ChangeActivity.changeAnswer.getText().toString();

                    // Replace the question in the CSV file
                    CSVProcessor.editQuestion(currentQuestion, changeQuestion, changeAnswer, name, ChangeActivity);
                    t = Toast.makeText(view.getContext(), "Successfully replaced question!", Toast.LENGTH_SHORT);
                    t.show();
                    setQuestions.clear();
                } catch (Exception e) {
                    t = Toast.makeText(view.getContext(), "Change Question Failed!", Toast.LENGTH_SHORT);
                    t.show();
                    setQuestions.clear();
                }
                break;
        }
    }
}