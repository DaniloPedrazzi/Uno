public class App {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();

        gameHandler.drawInitialCards();

        do{
            for (int i = 0; i < gameHandler.playerAmount; i++) {
                if(gameHandler.isOver) continue;

                System.out.println("Card on the table: " + gameHandler.cardOnTable.number + " " + gameHandler.cardOnTable.color);
                gameHandler.turn(gameHandler.players.get(i));
                System.out.println("\n");
            }
        }while(!gameHandler.isOver);

        System.out.println("O jogo acabou!");
        System.exit(0);
    }
}