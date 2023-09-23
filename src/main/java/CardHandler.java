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
            case 0 -> colorChoosed = "green";
            case 1 -> colorChoosed = "red";
            case 2 -> colorChoosed = "blue";
            case 3 -> colorChoosed = "yellow";
        }
        return colorChoosed;
    }

    static Card drawRandomCard(List<Card> remainingCards){
        int randomCardIndex = ThreadLocalRandom.current().nextInt(remainingCards.size());
        Card cardToDraw = remainingCards.get(randomCardIndex);
        remainingCards.remove(cardToDraw);
        return cardToDraw;
    }
}
