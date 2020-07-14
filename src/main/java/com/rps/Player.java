package com.rps;

public final class Player {

    private final int playerId;
    private final String playerName;
    private int currentMove;
    private int qunatitiOfWinPoints;


    public Player(final int  playerId, final String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.qunatitiOfWinPoints = 0;
    }


    @Override
    public boolean equals(Object obj) {
        Player player = (Player) obj;
        return this.playerId == player.playerId && this.playerName == player.playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
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
