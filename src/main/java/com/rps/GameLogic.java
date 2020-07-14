package com.rps;

import javafx.application.Application;

public class GameLogic {

    public static void main(String[] args) {
        String playerName;
        boolean NewGame = true;
        String chose = "P";

        while(NewGame = true) {
            GameBoradController gameBoradController = new GameBoradController();
            playerName = gameBoradController.askAboutPlayerName();
            gameBoradController.setQuantitiOfRoundsToEndGame(gameBoradController.askAboutQuantitiRounds());
            Player player1 = new Player(1, playerName);
            Player player2 = new Player(2, "Uncle Bob");
            gameBoradController.addPlayer(player1);
            gameBoradController.addPlayer(player2);
            while (gameBoradController.checkWhoWinGame() == 0) {
                player1.setMove(gameBoradController.askAboutMove());
                player2.setMove(gameBoradController.randomMove());
                gameBoradController.showWhatChosePlayers();
                gameBoradController.showWhoWinRound(gameBoradController.checkWhoWinRonud());
                gameBoradController.addPointToPlayerId(gameBoradController.checkWhoWinRonud());
                gameBoradController.showSccore();
            }
            gameBoradController.showWhoWinGame(gameBoradController.checkWhoWinGame());
            while( ! chose.equals("X") && ! chose.equals("N") ) {
                chose = gameBoradController.askAboutExitOrReaptGame();

            }
            if (chose.equals("X")){
                System.exit(0);

            }
            else if (chose.equals("N")){
                gameBoradController = null;
                chose = "P";
            }
        }
    }
}
