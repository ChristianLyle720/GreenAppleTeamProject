package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import edu.utsa.cs3443.group_teamproject.controller.ChangeController;

public class ChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        ChangeController ChangeController = new ChangeController(this);
        Button startButton = findViewById(R.id.returnSetButton);
        startButton.setOnClickListener(ChangeController);
    }
}