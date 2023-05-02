package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import edu.utsa.cs3443.group_teamproject.controller.MainController;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        MainController mainController = new MainController(this, nameEditText);
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(mainController);
    }
}