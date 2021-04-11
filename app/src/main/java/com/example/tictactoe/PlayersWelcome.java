package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayersWelcome extends AppCompatActivity {

TextView welcomeText;
private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_welcome);

        welcomeText = findViewById(R.id.welcomeText);
        playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");
        if (playerNames != null) {
            welcomeText.setText(" Labdien " + playerNames[0] + " un " + playerNames[1] + "!\n" + "    Vai vēlaties uzsākt spēli?");
        }
        else {
            welcomeText.setText("Labdien, vai vēlaties uzsākt spēli?");
        }
    }

    public void editNameClick(View view){
        Intent intent = new Intent(this, PlayerSetup.class);
        startActivity(intent);
    }

    public void startGameClick (View view){
        String player1Name =  playerNames[0].toString();
        String player2Name = playerNames[1].toString();
        Intent intent = new Intent (this, GameDisplay1.class);
        intent.putExtra("PLAYER_NAMES", new String[]{player1Name,player2Name});
        startActivity(intent);
    }
}