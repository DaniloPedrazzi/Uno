import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    List<Card> hand = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    public Card pickACard(){
        System.out.println("Pick a Card From your Hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ". " + hand.get(i).number + " " + hand.get(i).color);
        }
        return hand.get(in.nextInt() - 1);
    }
}
