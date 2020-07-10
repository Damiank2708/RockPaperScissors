package com.rps;

import java.util.ArrayList;
import java.util.List;


public final class GameBoradController {

    private final List<Player> playersList;
    private int quantitiOfRoundsToEndGame;

    public GameBoradController() {
        playersList = new ArrayList<>();
    }

    public void addPlayer(Player player){
        playersList.add(player);
    }

    public List<Player> getPlayers(){
        return playersList;
    }

    public void setQuantitiOfRoundsToEndGame(int quantitiOfRoundsToEndGame){
        this.quantitiOfRoundsToEndGame = quantitiOfRoundsToEndGame;
    }

    public int getQuantitiOfRoundsToEndGame(){
        return this.quantitiOfRoundsToEndGame;
    }

    public int checkWhoWinRonud(){
        //1 - ROCK. 2 - Paper. 3 - SCISSORS.
        //function return 0 if is DRAW !
        if ( playersList.get(0).getCurrentMove() == 1 ){
            if (playersList.get(1).getCurrentMove() == 2 ){
                return playersList.get(1).getPlayerId();
            }
            else if (playersList.get(1).getCurrentMove() == 3 ){
                return playersList.get(0).getPlayerId();
            }
        }
        else if(playersList.get(0).getCurrentMove() == 2 ){
            if (playersList.get(1).getCurrentMove() == 1 ){
                return playersList.get(0).getPlayerId();
            }
            else if (playersList.get(1).getCurrentMove() == 3 ){
                return playersList.get(1).getPlayerId();
            }
        }
        else if(playersList.get(0).getCurrentMove() == 3 ){
            if (playersList.get(1).getCurrentMove() == 1 ){
                return playersList.get(1).getPlayerId();
            }
            else if (playersList.get(1).getCurrentMove() == 2 ){
                return playersList.get(0).getPlayerId();
            }
        }
        return 0;
    }

    public void addPointToPlayerId(int PlyerId){
        playersList.stream()
                   .filter(t -> t.getPlayerId() == PlyerId)
                   .forEach(t -> t.addPoint());
    }

    public int getCountOfWinOfPlayerId(int PlyerId){
       return playersList.stream()
                .filter(t -> t.getPlayerId() == PlyerId)
                .map(Player::getPoint)
                .reduce(0, (sum, current) -> sum = sum + current);
    }

    public int checkWhoWinGame(){
        // 0 means that nobody wins yet.
        for ( Player player: playersList ) {
              if ( player.getPoint() == quantitiOfRoundsToEndGame ){
                  return player.getPlayerId();
              }
        }
        return 0;
    }

}
