package com.example.quiz31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String userName = "pep";
    EditText enterNameTextEdit;
    Intent intentGet;
    boolean leaveActivity = false;
    SharedPreferences sp;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("com.example.task31c", MODE_PRIVATE);
        enterNameTextEdit = findViewById(R.id.enterNameTextEdit);
        sp.edit().putInt("score", 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            userName = sp.getString("userName", "");
            enterNameTextEdit.setText(userName);
        } catch (NullPointerException e) {
            e.printStackTrace();
            enterNameTextEdit.setText("");
        }
    }

    public void onButtonStartClick(View view) {
        userName = enterNameTextEdit.getText().toString();
        sp.edit().putString("userName", userName).apply();
        Log.d("debug", "onButtonStartClick: " + userName);
        Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
        intentGet = getIntent();
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

}