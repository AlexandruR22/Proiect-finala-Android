package com.example.flappybird;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import Json.RecyclerFragment;
import Room.BestScoreFragment;
import Room.CreateUser;

import static android.view.View.GONE;

public class GameOver extends AppCompatActivity {

    TextView tvScore, tvPersonalBest;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        int scoreSP = pref.getInt("scoreSP", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(score > scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
        }
        tvScore = findViewById(R.id.tvScore);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        tvScore.setText(""+score);
        tvPersonalBest.setText(""+scoreSP);

        btn = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameOver.this, CreateUser.class));
            }
        });

    }
    public int getScore(){
        int score = getIntent().getExtras().getInt("score");
        return score;
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
    }

    public void bestScores(View view){
        findViewById(R.id.button3).setVisibility(GONE);
        findViewById(R.id.button4).setVisibility(GONE);
        findViewById(R.id.button5).setVisibility(GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        BestScoreFragment bestScoreFragment = new BestScoreFragment();
        fragmentManager.beginTransaction().replace(R.id.gameOver, bestScoreFragment).commit();
    }

    public void loadJson(View view){
        findViewById(R.id.button3).setVisibility(GONE);
        findViewById(R.id.button4).setVisibility(GONE);
        findViewById(R.id.button5).setVisibility(GONE);
       // FragmentManager fragmentManager = getSupportFragmentManager();
       // RecyclerFragment recyclerFragment = new RecyclerFragment();
       // fragmentManager.beginTransaction().replace(R.id.gameOver, recyclerFragment).commit();
        RecyclerFragment recyclerFragment = new RecyclerFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.gameOver, recyclerFragment,"recyclerFragment");
        fragmentTransaction.commit();
    }

}
