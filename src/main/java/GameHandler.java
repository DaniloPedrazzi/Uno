import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GameHandler {
    public Integer playerAmount = 4;
    public Integer initialCards = 7;
    public List<Card> remainingCards = CardHandler.initialCards();
    public List<Player> players = PlayerHandler.buildPlayers(playerAmount);
    public void drawInitialCards(){
        for (int i = 0; i < playerAmount; i++) {
            for (int j = 0; j < initialCards; j++) {
                int randomCardIndex = ThreadLocalRandom.current().nextInt(remainingCards.size());
                Card cardToDraw = remainingCards.get(randomCardIndex);
                players.get(i).hand.add(cardToDraw);
            }
        }
    }
}