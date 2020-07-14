package com.rps;

import java.util.*;


public final class GameBoradController {

    private final List<Player> playersList;
    private int quantitiOfRoundsToEndGame;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


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

    public String askAboutPlayerName(){
      System.out.println("You Name: ");
      return scanner.nextLine();
    }

    public int askAboutQuantitiRounds(){
        System.out.println("Please chose how many rounds the game will have: ");
        int i = 0;
        try {
            i = Integer.parseInt(scanner.nextLine());
            if (i <= 0){
               System.out.println("Please type number more than 0. ");
                return askAboutQuantitiRounds();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please write number.");
            return askAboutQuantitiRounds();
        }
        return i;
    }

    public int askAboutMove(){
        System.out.println("Please chose move " +
                "1 - ROCK " +
                "2 - Paper " +
                "3 - SCISSORS : ");
        int i = 0;
        try{
          i = Integer.parseInt(scanner.nextLine());
            if (i <= 0 && i >=4){
                System.out.println("Please type number 1 or 2 or 3. ");
                return askAboutMove();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please write correctly number.");
            return askAboutMove();
        }
        return i;
    }

    public int randomMove(){
        int randomResult = 0;
        while(randomResult == 0){
            randomResult = random.nextInt(4);
        }
        return randomResult;
    }

    public void showWhatChosePlayers(){
        for ( Player player: playersList ) {
            System.out.println(player.getPlayerName()+" was chose "+ convertIdMoveToName(player.getCurrentMove()));
        }
    }

    public void showWhoWinRound(int playerID){
        if (playerID > 0) {
            System.out.println("This Round Win " + playersList.get( getIndexByPlayerId(playerID)).getPlayerName());
        }
        else {
            System.out.println("This Round nobody win. DRAW !");
        }
    }

    private String convertIdMoveToName(int idMove){
        switch (idMove){
            case 1: return "ROCK.";
            case 2: return "PAPER.";
            case 3: return "SCISSORS.";
            default: return "";
        }
    }

    public void showSccore(){
        for ( Player player: playersList ) {
            if ( player.getPoint() > 1 ){
              System.out.println(player.getPlayerName()+" have "+ player.getPoint() + " points.");
            }
            else {
              System.out.println(player.getPlayerName()+" have "+ player.getPoint() + " point.");
            }
        }
    }

    public void showWhoWinGame(int playerIdWhoWinGame){
        System.out.println("The WINNER is "+playersList.get(getIndexByPlayerId(playerIdWhoWinGame)).getPlayerName() + "!!!!");
    }

    public String askAboutExitOrReaptGame(){
        System.out.println("Chose X to exit. " +
                           "N to play again: ");
        return  scanner.nextLine().toUpperCase();
    }

    private int getIndexByPlayerId(int playerId){
        for ( Player player: playersList ) {
            if ( player.getPlayerId()== playerId ){
                return playersList.indexOf(player);
            }
        }
        return 0;
    }


}
