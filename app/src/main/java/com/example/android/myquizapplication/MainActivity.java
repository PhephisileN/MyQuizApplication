package com.example.android.myquizapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.android.myquizapplication.R;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void displayScore(int answeredScore) {
        String name;

        EditText tName = findViewById(R.id.nameView);
        name = tName.getText().toString().trim();

        Toast.makeText(this, "Dear, " + name + " Total Score is: " + answeredScore, Toast.LENGTH_LONG).show();
    }

   public void getQuizResults(View v) {
        boolean ansArray[] = new boolean[8];
        RadioButton ans = (RadioButton) findViewById(R.id.question1choice3);
        ansArray[0] = ans.isChecked();

        ans = (RadioButton) findViewById(R.id.question2choice1);
        ansArray[1] = ans.isChecked();

        ans = (RadioButton) findViewById(R.id.question3choice2);
        ansArray[2] = ans.isChecked();

        CheckBox chAns = (CheckBox) findViewById(R.id.question4choice1);
        ansArray[3] = chAns.isChecked();

        ans = (RadioButton) findViewById(R.id.question5choice2);
        ansArray[4] = ans.isChecked();

        ans = (RadioButton) findViewById(R.id.question8choice1);
        ansArray[5] = ans.isChecked();

        chAns = (CheckBox) findViewById(R.id.question9choice1);
        ansArray[6] = chAns.isChecked();

        ans = (RadioButton) findViewById(R.id.question10choice1);
        ansArray[7] = ans.isChecked();

        int score = calcScore(ansArray);

        displayScore(score);
    }


    private int calcScore(boolean[] ansArray) {
        int scoreCnt = 0;
        for (int i = 0; i < 8; i++) {
            if (ansArray[i]) {
                scoreCnt += 1;
            }

        }
        return scoreCnt;
    }

    public void resetApp(View view) {

        // clear the Radio button controls
        RadioGroup ansGroup = findViewById(R.id.question1rg);
        ansGroup.clearCheck();

        ansGroup = findViewById(R.id.question2rb);
        ansGroup.clearCheck();

        ansGroup = findViewById(R.id.question3rg);
        ansGroup.clearCheck();

        ansGroup = findViewById(R.id.question5rg);
        ansGroup.clearCheck();

        ansGroup = findViewById(R.id.question8rg);
        ansGroup.clearCheck();

        ansGroup = (RadioGroup) findViewById(R.id.question10rg);
        ansGroup.clearCheck();

        // Clear Edit Text controls
        EditText ansEditText = (EditText) findViewById(R.id.nameView);
        ansEditText.setText("");


        // Clear out the checkboxes
        CheckBox cbAns = (CheckBox) findViewById(R.id.question4choice1);
        cbAns.setChecked(false);
        cbAns = (CheckBox) findViewById(R.id.question4choice2);
        cbAns.setChecked(false);
        cbAns = (CheckBox) findViewById(R.id.question4choice3);
        cbAns.setChecked(false);
        cbAns = (CheckBox) findViewById(R.id.question9choice1);
        cbAns.setChecked(false);
        cbAns = (CheckBox) findViewById(R.id.question9choice2);
        cbAns.setChecked(false);

        /*
        Reset the questions contained in the app
         */
        ScrollView quizTop = (ScrollView) findViewById(R.id.quizScrollView);
        quizTop.fullScroll(ScrollView.FOCUS_UP);

    }
}