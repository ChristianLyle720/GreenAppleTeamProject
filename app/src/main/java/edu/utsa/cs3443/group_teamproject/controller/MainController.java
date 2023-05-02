package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import edu.utsa.cs3443.group_teamproject.MainActivity;
import edu.utsa.cs3443.group_teamproject.SetActivity;

public class MainController implements View.OnClickListener{
    private MainActivity main;
    private EditText nameText;
    public MainController(MainActivity main, EditText nameText){
        this.main = main;
        this.nameText = nameText;
    }
    public void onClick(View view) {
        String user = nameText.getText().toString();
        Intent intent = new Intent(main, SetActivity.class);
        intent.putExtra("user", user);
        main.startActivity(intent);
    }
}
