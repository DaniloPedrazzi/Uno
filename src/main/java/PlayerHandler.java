import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PlayerHandler {
    static List<Player> buildPlayers(Integer playerAmount){
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerAmount; i++) {
            players.add(new Player(i));
        }
        return players;
    }

    private static final Scanner in = new Scanner(System.in);
    public static Card pickACard(Player player){
        listPlayerCards(player);
        while (true) {
            System.out.println("Pick a Card From your Hand:");
            int choice = in.nextInt();
            if (choice > player.hand.size() || choice < 1) {
                System.out.println("Pick a valid number.");
            }else{
                return player.hand.get(choice - 1);
            }
        }
    }

    static void listPlayerCards(Player player){
        for (int i = 0; i < player.hand.size(); i++) {
            System.out.println((i + 1) + ". " + player.hand.get(i).number + " " + player.hand.get(i).color);
        }
    }

    static Boolean hasCardToPlay(Player player, Card cardOnTable){
        for (int i = 0; i < player.hand.size(); i++) {
            Card card = player.hand.get(i);
            if(Objects.equals(card.color, cardOnTable.color) || Objects.equals(card.number, cardOnTable.number)){
                return true;
            }
        }
        return false;
    }
}