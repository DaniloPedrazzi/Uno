public class App {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();

        gameHandler.drawInitialCards();

        do{
            for (int i = 0; i < gameHandler.playerAmount; i++) {
                System.out.println("Card on the table: " + gameHandler.cardOnTable.number + " " + gameHandler.cardOnTable.color);
                gameHandler.turn(gameHandler.players.get(i));
            }
        }while(!gameHandler.isOver);

        //LOGS
        showPlayersCards(gameHandler);
    }

    static void showPlayersCards(GameHandler gameHandler){
        for (int i = 0; i < gameHandler.players.size(); i++) {
            System.out.println("Player: " + i);
            for (int j = 0; j < gameHandler.initialCards; j++) {
                System.out.println(gameHandler.players.get(i).hand.get(j).number + " " + gameHandler.players.get(i).hand.get(j).color);
            }
            System.out.println("\n");
        }
    }
}
