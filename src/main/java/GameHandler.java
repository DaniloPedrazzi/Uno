import java.util.List;
import java.util.Objects;

public class GameHandler {
    public Boolean isOver = false;
    public Integer playerAmount = 4;
    public Integer initialCards = 7;
    public List<Card> remainingCards = CardHandler.initialCards();
    public List<Player> players = PlayerHandler.buildPlayers(playerAmount);
    public Card cardOnTable = CardHandler.drawRandomCard(remainingCards);
    public void drawInitialCards(){
        for (int i = 0; i < playerAmount; i++) {
            for (int j = 0; j < initialCards; j++) {
                Card cardToDraw = CardHandler.drawRandomCard(remainingCards);
                remainingCards.remove(cardToDraw);
                players.get(i).hand.add(cardToDraw);
            }
        }
    }

    public void turn(Player player){
        boolean sucess = false;
        do{
            Card cardPicked = player.pickACard();
            if(Objects.equals(cardPicked.color, cardOnTable.color) || Objects.equals(cardPicked.number, cardOnTable.number)){
                player.hand.remove(cardPicked);
                cardOnTable = cardPicked;
                sucess = true;
            }
        }while(!sucess);
    }
}