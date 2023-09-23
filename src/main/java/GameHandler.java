import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameHandler {
    public Boolean isOver = false;
    public Integer playerAmount = 4;
    public Integer initialCards = 7;
    public Boolean drawUntilSuccess = false;
    public List<Card> remainingCards = CardHandler.initialCards();
    public List<Card> playedCards = new ArrayList<>();
    public List<Player> players = PlayerHandler.buildPlayers(playerAmount);
    public Card cardOnTable = CardHandler.getRandomCard(remainingCards, playedCards);

    public void drawInitialCards(){
        for (int i = 0; i < playerAmount; i++) {
            for (int j = 0; j < initialCards; j++) {
                Card cardToDraw = CardHandler.getRandomCard(remainingCards, playedCards);
                remainingCards.remove(cardToDraw);
                players.get(i).hand.add(cardToDraw);
            }
        }
    }

    public void turn(Player player){
        if(player.hand.isEmpty()){
            isOver = true;
            return;
        }
        System.out.println("Player: " + player.id);
        if(PlayerHandler.hasCardToPlay(player, cardOnTable)){
            playCard(player);
        }else if(!drawUntilSuccess){
            drawCard(player);
        }else{
            do{
                drawCard(player);
            }while(!PlayerHandler.hasCardToPlay(player, cardOnTable));
        }
    }

    private void playCard(Player player){
        boolean sucess = false;
        do{
            Card cardPicked = PlayerHandler.pickACard(player);
            if(Objects.equals(cardPicked.color, cardOnTable.color) || Objects.equals(cardPicked.number, cardOnTable.number)){
                player.hand.remove(cardPicked);
                playedCards.add(cardPicked);
                cardOnTable = cardPicked;
                sucess = true;
            }else{
                System.out.println("Invalid Card!");
            }
        }while(!sucess);
    }

    private void drawCard(Player player){
        PlayerHandler.listPlayerCards(player);
        System.out.println("Looks like you do not have a card to this round.");
        Card cardDrew = CardHandler.getRandomCard(remainingCards, playedCards);
        player.hand.add(cardDrew);
        System.out.printf("You draw an %d %s%n", cardDrew.number, cardDrew.color);
    }
}