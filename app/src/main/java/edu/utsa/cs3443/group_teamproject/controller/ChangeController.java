package edu.utsa.cs3443.group_teamproject.controller;

import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.group_teamproject.ChangeActivity;
import edu.utsa.cs3443.group_teamproject.MainActivity;
import edu.utsa.cs3443.group_teamproject.R;
import edu.utsa.cs3443.group_teamproject.SetActivity;

public class ChangeController implements View.OnClickListener{
    private MainActivity main;
    private SetActivity SetActivity;
    private ChangeActivity ChangeActivity;
    public ChangeController(ChangeActivity ChangeActivity){
        this.ChangeActivity = ChangeActivity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.returnSetButton:
                String user = MainController.user;
                Intent i = new Intent(ChangeActivity, SetActivity.class);
                i.putExtra("user", user);
                ChangeActivity.startActivity(i);
        }
    }
}
