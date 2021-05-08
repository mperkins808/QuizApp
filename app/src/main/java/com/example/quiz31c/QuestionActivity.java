package com.example.quiz31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    // Arrays for storing the questions and answers
    String[] questionTitles;
    String[] questions;
    String[][] questionAnswers;
    String[] completeModeButton;

    int questionTally;
    int score;
    boolean correct;
    int ansChoice;
    SharedPreferences sp;
    //initialising all the buttons and views in the scene
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button completeButton;
    ProgressBar progressBar;

    TextView titleTextView;
    TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        sp = getSharedPreferences("com.example.task31c", MODE_PRIVATE);
        initVariables();

    }
    //Initialising all the variables used in Activity.
    public void initVariables(){

        questionTitles = new String[5];
        questions = new String[5];
        questionAnswers = new String[5][3];
        completeModeButton = new String[2];
        questionTally = 1;
        score = 0;
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        completeButton = findViewById(R.id.completeButton);
        titleTextView = findViewById(R.id.titleTextView);
        questionTextView = findViewById(R.id.questionTextView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(5);
        progressBar.setProgress(0);

        //Titles of the questions
        questionTitles[0] = "Data Persistence"; questionTitles[1] = "Programming language"; questionTitles[2] = "Android History";
        questionTitles[3] = "Adding Functionality"; questionTitles[4] = "App Versatility";

        //The questions
        questions[0] = "I am given a variable x that I want to store in an SQL lite database to use everytime I boot my application. What method would I use?";
        questions[1] ="What programming language would I use to program my app's behaviour and then what markup language to design it's layout in Android Studio?";
        questions[2] ="What kernel is Android based on?";
        questions[3] ="I want to add a second screen to my app. What is the naming convention of the new file created?";
        questions[4] ="I want to change the color of the button everytime the user clicks the button. How would I do this easily?";

        //Answers to the questions
        questionAnswers[0][0] = "Store x with SharedPreferences"; questionAnswers[0][1] = "assign x to a constant"; questionAnswers[0][2] = "Store x with an intent";
        questionAnswers[1][0] = "C++ and XML"; questionAnswers[1][1] = "JavaScript and CSS"; questionAnswers[1][2] = "Java and XML";
        questionAnswers[2][0] = "Windows"; questionAnswers[2][1] = "Linux"; questionAnswers[2][2] = "MacOS";
        questionAnswers[3][0] = "<ScreenName>.Class"; questionAnswers[3][1] = "<ScreenName>.Java"; questionAnswers[3][2] = "<ScreenName>Activity.java";
        questionAnswers[4][0] = "Onclick listener"; questionAnswers[4][1] = "Hardcode in XML"; questionAnswers[4][2] = "Have button below the button";
        //decides what question to display. 10 values. 5 questions. Every odd value shows the next button. Every even values shows the submit button
        questionTally = 1;

        //Sets the text on the 4th button
        completeModeButton[0] = "Submit"; completeModeButton[1] = "Next";

        //Sets the initial questions
        setValues(questionTitles[0], questions[0], questionAnswers[0][0], questionAnswers[0][1], questionAnswers[0][2], completeModeButton[0]);

    }

    //Assess which button the user clicks and changes colors of the buttons accordingly when user selectes Submit button
    public void onSubmitClick(View view) {
        questionTally++;
        switch (questionTally){
            case 1:
                setValues(questionTitles[0], questions[0], questionAnswers[0][0], questionAnswers[0][1], questionAnswers[0][2], completeModeButton[0]);
                break;
            case 2:
                if (ansChoice == 1) {
                    score += 1;
                    progressBar.setProgress(1);
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else if (ansChoice == 2) {
                    progressBar.setProgress(1);
                    answer2Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else {
                    progressBar.setProgress(1);
                    answer3Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                }
                setValues(completeModeButton[1]);
                break;
            case 3:
                setValues(questionTitles[1], questions[1], questionAnswers[1][0], questionAnswers[1][1], questionAnswers[1][2], completeModeButton[0]);
                break;
            case 4:
                if (ansChoice == 3) {
                    score += 1;
                    progressBar.setProgress(2);
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else if (ansChoice == 1) {
                    progressBar.setProgress(2);
                    answer1Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else {
                    progressBar.setProgress(2);
                    answer2Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                }
                setValues(completeModeButton[1]);
                break;
            case 5:
                setValues(questionTitles[2], questions[2], questionAnswers[2][0], questionAnswers[2][1], questionAnswers[2][2], completeModeButton[0]);
                break;
            case 6:
                if (ansChoice == 2) {
                    score += 1;
                    progressBar.setProgress(3);
                    Log.e("D", "A2 is changed to green");
                    answer2Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else if (ansChoice == 1) {
                    progressBar.setProgress(3);
                    Log.e("D", "A1 is changed to green");
                    answer1Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer2Button.setBackgroundColor(Color.parseColor("#32cd32"));
                } else if (ansChoice == 3) {
                    progressBar.setProgress(3);
                    Log.e("D", "A3 is changed to red");
                    answer3Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer2Button.setBackgroundColor(Color.parseColor("#32cd32"));
                }
                setValues(completeModeButton[1]);
                break;
            case 7:
                setValues(questionTitles[3], questions[3], questionAnswers[3][0], questionAnswers[3][1], questionAnswers[3][2], completeModeButton[0]);
                break;
            case 8:
                if (ansChoice == 3) {
                    score += 1;
                    progressBar.setProgress(4);
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else if (ansChoice == 1) {
                    progressBar.setProgress(4);
                    answer1Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else {
                    progressBar.setProgress(4);
                    answer2Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer3Button.setBackgroundColor(Color.parseColor("#32CD32"));
                }
                setValues(completeModeButton[1]);
                break;
            case 9:
                setValues(questionTitles[4], questions[4], questionAnswers[4][0], questionAnswers[4][1], questionAnswers[4][2], completeModeButton[0]);
                break;
            case 10:
                if (ansChoice == 1) {
                    score += 1;
                    progressBar.setProgress(5);
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else if (ansChoice == 2) {
                    progressBar.setProgress(5);
                    answer2Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                } else {
                    progressBar.setProgress(5);
                    answer3Button.setBackgroundColor(Color.parseColor("#ff1a1a"));
                    answer1Button.setBackgroundColor(Color.parseColor("#32CD32"));
                }
                setValues(completeModeButton[1]);
                break;
            case 11:
                sp.edit().putInt("score", score).apply();
                Intent intent = new Intent(getApplicationContext(), EndScreenActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    //Sets values for the views on the scene. Quicker to bundle it into a function
    public void setValues(String title, String question, String a, String b, String c, String d) {
        titleTextView.setText(title); questionTextView.setText(question);
        answer1Button.setText(a); answer2Button.setText(b); answer3Button.setText(c);
        completeButton.setText(d);

        //Resets colors to original for buttons
        answer1Button.setBackgroundColor(Color.parseColor("#6200ee"));
        answer2Button.setBackgroundColor(Color.parseColor("#6200ee"));
        answer3Button.setBackgroundColor(Color.parseColor("#6200ee"));

        correct = false;
    }
    //Changes mode of the submit/next button
    public void setValues(String modeChange) {
        completeButton.setText(modeChange);
    }

    //Detects what button the user clicked
    public void answerButton(View view) {
        switch (questionTally) {
            case 1:
                answerChoice(view, 1);
                break;
            case 3:
                answerChoice(view, 3);
                break;
            case 5:
                answerChoice(view, 5);
            case 7:
                answerChoice(view, 7);
                Log.d("D", String.valueOf(ansChoice));
            case 9:
                answerChoice(view, 9);
            default:
                break;

        }
    }
    //Finds the user choice once they click the button.
    public void answerChoice(View view, int q){
        switch (q) {
            case 1:
                if (view.getId() == R.id.answer1Button) ansChoice = 1;
                else if (view.getId() == R.id.answer2Button) ansChoice = 2;
                else ansChoice = 3;
                break;
            case 3:
                if (view.getId() == R.id.answer1Button) ansChoice = 1;
                else if (view.getId() == R.id.answer2Button) ansChoice = 2;
                else ansChoice = 3;
                break;
            case 5:
                if (view.getId() == R.id.answer1Button) ansChoice = 1;
                else if (view.getId() == R.id.answer2Button) ansChoice = 2;
                else ansChoice = 3;
                break;
            case 7:
                if (view.getId() == R.id.answer1Button) ansChoice = 1;
                else if (view.getId() == R.id.answer2Button) ansChoice = 2;
                else ansChoice = 3;
                break;
            case 9:
                if (view.getId() == R.id.answer1Button) ansChoice = 1;
                else if (view.getId() == R.id.answer2Button) ansChoice = 2;
                else ansChoice = 3;
                break;
        }
    }
}