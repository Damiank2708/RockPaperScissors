package com.rps;

public final class Player {

    private final int playerId;
    private final String playerName;
    private final Boolean isComputer;
    private int currentMove;
    private int qunatitiOfWinPoints;


    public Player(final int  playerId, final String playerName,final Boolean isComputer) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.isComputer = isComputer;
        this.qunatitiOfWinPoints = 0;
    }


    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getComputer() {
        return isComputer;
    }

    public void setMove(int move){
        currentMove = move;
    }

    public int getCurrentMove(){
        return this.currentMove;
    }

    public void addPoint(){
        qunatitiOfWinPoints = qunatitiOfWinPoints +1;
    }

    public int getPoint(){
        return qunatitiOfWinPoints;
    }
}
