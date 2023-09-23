import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();

        gameHandler.drawInitialCards();



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
