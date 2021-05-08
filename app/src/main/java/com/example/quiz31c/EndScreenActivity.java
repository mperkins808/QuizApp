package com.example.quiz31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EndScreenActivity extends AppCompatActivity {
    TextView congratsTextView;
    TextView scoreDisplayTextView;
    String congratsString;
    boolean newQuiz;
    int userScore;
    SharedPreferences sp;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        congratsTextView = findViewById(R.id.congratsTextView);
        scoreDisplayTextView = findViewById(R.id.scoreDisplayTextView);
        congratsTextView.setText("PLACE");
        Intent intentGet = getIntent();
        sp = getSharedPreferences("com.example.task31c", MODE_PRIVATE);
        score = sp.getInt("score", -1);
        Log.d("S", "Score of " + String.valueOf(score));
        congratsString = "Congratulations " + sp.getString("userName", "Bob") + "!";
        congratsTextView.setText(congratsString);
        scoreDisplayTextView.setText(String.valueOf(score) + "/5");
    }

    //Sends user to the starting activity
    public void onNewQuizClick(View view) {
        Intent intentSend = new Intent(getApplicationContext(), MainActivity.class);
        newQuiz = true;
        intentSend.putExtra("newQuiz", newQuiz);
        startActivity(intentSend);
    }
    //Closes the app if user clicks button
    public void finishClick(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}