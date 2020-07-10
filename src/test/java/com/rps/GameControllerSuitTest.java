package com.rps;

import org.junit.Assert;
import org.junit.Test;

public class GameControllerSuitTest {
    @Test
    public void testGameController() {
        GameBoradController gameBoardController = new GameBoardController();

        Player player1 = new Player(1, "Damian", false);
        Assert.assertEquals("Damian", player1.getPlayerName());
        Assert.assertEquals(1, player1.getPlayerId());

        Player player2 = new Player(2, "Uncle Bob - PC", true);
        Assert.assertEquals("Uncle Bob - PC", player2.getPlayerName());
        Assert.assertEquals(2, player2.getPlayerId());

        gameBoardController.addPlayer(player1);
        gameBoardController.addPlayer(player2);
        Assert.assertEquals(2, gameBoardController.getPlayers.size());

        gameBoardController.setQuantitiOfRoundsToEndGame(1);
        Assert.assertEquals(1, gameBoardController.getQuantitiOfRoundsToEndGame());

        player1.setMove(1);
        player2.setMove(3);
        int idPlayerWhoWinRound = gameBoardController.checkWhoWinRonud();
        Assert.assertEquals(2, idPlayerWhoWin);
        gameBoardController.addPointToPlayerId(idPlayerWhoWinRound);
        Assert.assertEquals(0, getCountOfWinOfPlayerId(1));
        Assert.assertEquals(1, getCountOfWinOfPlayerId(2));

        int idPlayerWhoWinGame = gameBoardController.checkWhoWinGame();
        Assert.assertEquals(2, idPlayerWhoWinGame);

    }


}
