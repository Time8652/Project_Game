package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button game_1, game_2, game_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initListener() {
        game_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Game_Jingziqi.class));
            }
        });
        game_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Game_Jingziqi_Plus.class));
            }
        });
        game_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Game_2048.class));
            }
        });
    }

    private void initData() {
        welcome.setText("欢迎admin!");
    }

    private void initView() {
        welcome = findViewById(R.id.welcome);
        game_1 = findViewById(R.id.game_1);
        game_2 = findViewById(R.id.game_2);
        game_3 = findViewById(R.id.game_3);
    }
}