package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import edu.utsa.cs3443.group_teamproject.MainActivity;
import edu.utsa.cs3443.group_teamproject.SetActivity;

/**
 * The controller class for the MainActivity.
 * @author Green Apple Inc.
 */
public class MainController implements View.OnClickListener{
    private MainActivity main;
    private EditText nameText;
    public static String user;

    /**
     * Constructor for the MainController.
     *
     * @param main The MainActivity instance.
     * @param nameText The EditText containing the user's name.
     */
    public MainController(MainActivity main, EditText nameText){
        this.main = main;
        this.nameText = nameText;
    }

    /**
     * Handles click events on the UI button in the MainActivity.
     *
     * @param view The view that was clicked.
     */
    public void onClick(View view) {
        // Get the user's name from the EditText and store it in a static variable
        user = nameText.getText().toString();

        // Create an intent to navigate to the SetActivity and pass the user's name as an extra
        Intent intent = new Intent(main, SetActivity.class);
        intent.putExtra("user", user);

        // Start the SetActivity
        main.startActivity(intent);
    }
}
