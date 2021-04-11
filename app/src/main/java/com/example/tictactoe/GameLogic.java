package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class GameLogic {
    private final int[][] gameBoard;


    private int[] winType = {-1, -1, -1};

    private int player = 1;
    String[] playerNames = {"Spēlētājs_1", "Spēlētājs_2"};

    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    GameLogic(){

        gameBoard = new int[3][3];

        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col){


        if (gameBoard[row-1][col-1] == 0){
            gameBoard[row-1][col-1] = player;


            if (player == 1){
                playerTurn.setText(("Spēlētāja "+playerNames[1] + " gājiens"));
            }
            else{
                playerTurn.setText(("Spēlētāja "+playerNames[0] + " gājiens"));
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;


        for (int r = 0; r<3; r++){

            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                    gameBoard[r][0] != 0){

                winType = new int[]{r, 0, 1};
                isWinner = true;
                break;
            }
        }


        for (int c=0; c<3; c++){

            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] &&
                    gameBoard[0][c] != 0){

                winType = new int[]{0, c, 2};
                isWinner = true;
                break;
            }
        }


        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[2][2] == gameBoard[0][0] &&
                gameBoard[0][0] != 0){

            winType = new int[]{0, 2, 3};
            isWinner = true;
        }

      
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] &&
                gameBoard[2][0] != 0){

            winType = new int[]{2, 2, 4};
            isWinner = true;
        }

        int boardFilled = 0;

        for (int row=0; row<3; row++){
            for (int col=0; col<3; col++){
                if(gameBoard[row][col] != 0){
                    boardFilled += 1;
                }
            }
        }

        if (isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + " vinnēja!"));
            return true;
        }
        else if (boardFilled == 9){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Neizšķirta spēle!");
            return true;
        }

        return false;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int[] getWinType() {
        return winType;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public void resetGame(){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                gameBoard[r][c] = 0;
            }
        }

        winType[0] = -1;
        winType[1] = -1;
        winType[2] = -1;

        player = 1;

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText(("Spēlētāja " + playerNames[0] + " gājiens"));
    }
}

