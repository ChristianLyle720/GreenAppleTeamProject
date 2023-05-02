package edu.utsa.cs3443.group_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import edu.utsa.cs3443.group_teamproject.controller.SetController;
import edu.utsa.cs3443.group_teamproject.model.AllQuestionSets;

public class SetActivity extends AppCompatActivity {
    private TextView userTextView;
    private TextView setTextView1;
    private TextView setTextView2;
    private TextView setTextView3;
    private TextView setTextView4;
    private TextView setTextView5;
    private TextView setTextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        userTextView = findViewById(R.id.userSetTextView);
        setTextView1 = findViewById(R.id.setTextView1);
        setTextView2 = findViewById(R.id.setTextView2);
        setTextView3 = findViewById(R.id.setTextView3);
        setTextView4 = findViewById(R.id.setTextView4);
        setTextView5 = findViewById(R.id.setTextView5);
        setTextView6 = findViewById(R.id.setTextView6);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        SetController initializeController = new SetController(user, this, this);
        try {
            initializeController.loadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SetController set1Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(0).getName(),user, this, this);
        SetController set2Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(1).getName(),user, this, this);
        SetController set3Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(2).getName(),user, this, this);
        SetController set4Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(3).getName(),user, this, this);
        SetController set5Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(4).getName(),user, this, this);
        SetController set6Controller = new SetController(AllQuestionSets.getQuestionSets().getSets().get(5).getName(),user, this, this);

        Button set1Button = findViewById(R.id.setButton1);
        Button set2Button = findViewById(R.id.setButton2);
        Button set3Button = findViewById(R.id.setButton3);
        Button set4Button = findViewById(R.id.setButton4);
        Button set5Button = findViewById(R.id.setButton5);
        Button set6Button = findViewById(R.id.setButton6);

        set1Button.setOnClickListener(set1Controller);
        set2Button.setOnClickListener(set2Controller);
        set3Button.setOnClickListener(set3Controller);
        set4Button.setOnClickListener(set4Controller);
        set5Button.setOnClickListener(set5Controller);
        set6Button.setOnClickListener(set6Controller);

        ArrayList<SetController> setControllers = new ArrayList<SetController>();
        setControllers.add(set1Controller);
        setControllers.add(set2Controller);
        setControllers.add(set3Controller);
        setControllers.add(set4Controller);
        setControllers.add(set5Controller);
        setControllers.add(set6Controller);

        ArrayList<TextView> textViews = new ArrayList<TextView>();
        textViews.add(setTextView1);
        textViews.add(setTextView2);
        textViews.add(setTextView3);
        textViews.add(setTextView4);
        textViews.add(setTextView5);
        textViews.add(setTextView6);

        String display = initializeController.getUserText();
        userTextView.setText(display);
        for(int i = 0; i < AllQuestionSets.getQuestionSets().getSets().size() && i < 6; i++){
            display = setControllers.get(i).getSetText();
            setSetText(textViews.get(i), display);
        }
    }

    public void setSetText(TextView setText, String display){
        setText.setText(display);
    }

}