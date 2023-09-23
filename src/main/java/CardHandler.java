import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CardHandler {
    static List<Card> initialCards(){
        List<Card> initialCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 9; j++) {
                initialCards.add(new Card(returnColor(i), j));
            }
        }
        return initialCards;
    }

    static String returnColor(Integer color){
        String colorChoosed = "";
        switch (color){
            case 0 -> colorChoosed = "🟩";
            case 1 -> colorChoosed = "🟥";
            case 2 -> colorChoosed = "🟦";
            case 3 -> colorChoosed = "🟨";
        }
        return colorChoosed;
    }

    static Card getRandomCard(List<Card> remainingCards, List<Card> playedCards){
        //Puts the playedCards into playable cards again
        if(remainingCards.isEmpty()){
            remainingCards.addAll(playedCards);
            playedCards.clear();
        }
        int randomCardIndex = ThreadLocalRandom.current().nextInt(remainingCards.size());
        Card cardToDraw = remainingCards.get(randomCardIndex);
        remainingCards.remove(cardToDraw);
        return cardToDraw;
    }
}
