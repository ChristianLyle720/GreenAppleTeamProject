/**
 * @author Green Apple Inc.
 * MainActivity is the main activity of the application and acts as the starting point.
 * It handles user input for name and initializes the necessary resources for the app.
 */
package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import edu.utsa.cs3443.group_teamproject.controller.MainController;
import edu.utsa.cs3443.group_teamproject.model.CSVProcessor;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Copy the CSV file from the assets folder to the app's private storage for editing
        String questionsFilePath = getApplicationContext().getFilesDir().getPath() + "/questions.csv";
        String setsFilePath = getApplicationContext().getFilesDir().getPath() + "/sets.csv";

        // Only create the files if it doesn't exist
        if (!CSVProcessor.fileExists(questionsFilePath)) {
            CSVProcessor.copyAssetToFile(this, "questions.csv", "questions.csv");
        }

        if (!CSVProcessor.fileExists(setsFilePath)) {
            CSVProcessor.copyAssetToFile(this, "sets.csv", "sets.csv");
        }

        nameEditText = findViewById(R.id.nameEditText);
        MainController mainController = new MainController(this, nameEditText);
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(mainController);
    }

}