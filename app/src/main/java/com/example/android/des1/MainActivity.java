package com.example.android.des1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.des1.R.id.ans3;


public class MainActivity extends AppCompatActivity {

    int userScore = 0;
    public static final String CORRANS3_1 = "ntanos";
    public static final String CORRANS3_2 = "NTANOS";

    private RadioButton q1_corr_ans;    // Global Variables
    private RadioButton q2_corr_ans;
    private EditText q3_ans;
    private RadioButton q4_corr_ans;
    private RadioButton q5_corr_ans;
    private RadioButton q6_corr_ans;
    private CheckBox q7_corr_ans1;
    private CheckBox q7_corr_ans2;
    private CheckBox q7_corr_ans3;
    private CheckBox q7_corr_ans4;
    private RadioButton q8_corr_ans;
    private RadioButton q9_corr_ans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1_corr_ans = (RadioButton) findViewById(R.id.ans1_2);  // Check & Define the correct answer for question 1
        q2_corr_ans = (RadioButton) findViewById(R.id.ans2_4);  // Check & Define the correct answer for question 2
        q3_ans = (EditText) findViewById(ans3);                  // Check & Define the correct answer for question 3
        q4_corr_ans = (RadioButton) findViewById(R.id.ans4_3);  // Check & Define the correct answer for question 4
        q5_corr_ans = (RadioButton) findViewById(R.id.ans5_2);  // Check & Define the correct answer for question 5
        q6_corr_ans = (RadioButton) findViewById(R.id.ans6_2);  // Check & Define the correct answer for question 6
        q7_corr_ans1 = (CheckBox) findViewById(R.id.ans7_1);    // Check & Define the correct answer for question 7
        q7_corr_ans2 = (CheckBox) findViewById(R.id.ans7_2);
        q7_corr_ans3 = (CheckBox) findViewById(R.id.ans7_3);
        q7_corr_ans4 = (CheckBox) findViewById(R.id.ans7_4);
        q8_corr_ans = (RadioButton) findViewById(R.id.ans8_3);  // Check & Define the correct answer for question 8
        q9_corr_ans = (RadioButton) findViewById(R.id.ans9_4);  // Check & Define the correct answer for question 9

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("userScore", userScore);


    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userScore = savedInstanceState.getInt("userScore");

        if (userScore > 0){
            corrAnsGreen();
        }

    }





    /*
    *   Resets the quiz status
    */
    public void resetQuiz(View view){
        RadioGroup ans1RadioGroup = (RadioGroup) findViewById(R.id.ans1RG);
        RadioGroup ans2RadioGroup = (RadioGroup) findViewById(R.id.ans2RG);
        RadioGroup ans4RadioGroup = (RadioGroup) findViewById(R.id.ans4RG);
        RadioGroup ans5RadioGroup = (RadioGroup) findViewById(R.id.ans5RG);
        RadioGroup ans6RadioGroup = (RadioGroup) findViewById(R.id.ans6RG);
        CheckBox ans7_1 = (CheckBox) findViewById(R.id.ans7_1);
        CheckBox ans7_2 = (CheckBox) findViewById(R.id.ans7_2);
        CheckBox ans7_3 = (CheckBox) findViewById(R.id.ans7_3);
        CheckBox ans7_4 = (CheckBox) findViewById(R.id.ans7_4);
        RadioGroup ans8RadioGroup = (RadioGroup) findViewById(R.id.ans8RG);
        RadioGroup ans9RadioGroup = (RadioGroup) findViewById(R.id.ans9RG);

        // reset state of whole quiz
        ans1RadioGroup.clearCheck();
        ans2RadioGroup.clearCheck();
        q3_ans.setText("");
        ans4RadioGroup.clearCheck();
        ans5RadioGroup.clearCheck();
        ans6RadioGroup.clearCheck();
        ans7_1.setChecked(false);
        ans7_2.setChecked(false);
        ans7_3.setChecked(false);
        ans7_4.setChecked(false);
        ans8RadioGroup.clearCheck();
        ans9RadioGroup.clearCheck();

        // reset colors
        corrAnsWhite();

        // Resetting userScore
        userScore = 0;

    }


    public void showResults (View view){



        if (userScore > 0){
            //create the message:
            CharSequence toastMessage = "Your score is: " + userScore + "/9";
            Toast resultsToast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
            resultsToast.show();
            return;
        }


        // Checks condition
        boolean isAns1Correct = q1_corr_ans.isChecked();
        boolean isAns2Correct = q2_corr_ans.isChecked();
        String ans3Text = q3_ans.getText().toString();
        boolean isAns4Correct = q4_corr_ans.isChecked();
        boolean isAns5Correct = q5_corr_ans.isChecked();
        boolean isAns6Correct = q6_corr_ans.isChecked();
        boolean isAns7_1Correct = q7_corr_ans1.isChecked();
        boolean isAns7_2Correct = q7_corr_ans2.isChecked();
        boolean isAns7_3Correct = q7_corr_ans3.isChecked();
        boolean isAns7_4Correct = q7_corr_ans4.isChecked();
        boolean isAns8Correct = q8_corr_ans.isChecked();
        boolean isAns9Correct = q9_corr_ans.isChecked();


        // Then adds 1 point for each question checked
        if (isAns1Correct){
            userScore ++;
        }
        if (isAns2Correct){
            userScore ++;
        }

        if (ans3Text.equals(CORRANS3_1) || ans3Text.equals(CORRANS3_2)){
            userScore ++;
        }

        if (isAns4Correct){
            userScore ++;
        }

        if (isAns5Correct){
            userScore ++;
        }

        if (isAns6Correct){
            userScore ++;
        }
        if (isAns7_1Correct && isAns7_3Correct && !isAns7_2Correct && !isAns7_4Correct){
            userScore ++;
        }

        if (isAns8Correct){
            userScore ++;
        }

        if (isAns9Correct){
            userScore ++;
        }

        // Color correct
        corrAnsGreen();

        //create the message:
        CharSequence toastMessage = "Your score is: " + userScore + "/9";
        Toast resultsToast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
        resultsToast.show();
    }


    // colors all the correct answers text to Green (results)
    public void corrAnsGreen() {
        q1_corr_ans.setTextColor(Color.GREEN);
        q2_corr_ans.setTextColor(Color.GREEN);
        q3_ans.setText(CORRANS3_1);
        q3_ans.setTextColor(Color.GREEN);
        q4_corr_ans.setTextColor(Color.GREEN);
        q5_corr_ans.setTextColor(Color.GREEN);
        q6_corr_ans.setTextColor(Color.GREEN);
        q7_corr_ans1.setTextColor(Color.GREEN);
        q7_corr_ans3.setTextColor(Color.GREEN);
        q8_corr_ans.setTextColor(Color.GREEN);
        q9_corr_ans.setTextColor(Color.GREEN);
    }

    // colors all correct answer text in White (reset)
    public void corrAnsWhite(){
        q1_corr_ans.setTextColor(Color.WHITE);
        q2_corr_ans.setTextColor(Color.WHITE);
        q3_ans.setTextColor(Color.WHITE);
        q4_corr_ans.setTextColor(Color.WHITE);
        q5_corr_ans.setTextColor(Color.WHITE);
        q6_corr_ans.setTextColor(Color.WHITE);
        q7_corr_ans1.setTextColor(Color.WHITE);
        q7_corr_ans3.setTextColor(Color.WHITE);
        q8_corr_ans.setTextColor(Color.WHITE);
        q9_corr_ans.setTextColor(Color.WHITE);
    }

}
