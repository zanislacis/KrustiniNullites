package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    EditText player1;
    EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }

    public void submitButtonClick(View view){

        String fl1 = player1.getText().toString().substring(0,1).toUpperCase();
        String rl1 = player1.getText().toString().substring(1).toLowerCase();

        String fl2 = player2.getText().toString().substring(0,1).toUpperCase();
        String rl2 = player2.getText().toString().substring(1).toLowerCase();

        String player1Name = fl1 + rl1;
        String player2Name = fl2 + rl2;

        Intent intent = new Intent(this, PlayersWelcome.class);
        intent.putExtra("PLAYER_NAMES", new String[] {player1Name, player2Name});
        startActivity(intent);
    }
}