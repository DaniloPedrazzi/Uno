import java.util.ArrayList;
import java.util.List;

public class Card {
    String color;
    Integer number;

    public Card(String color, Integer number) {
        if(color.equals("green") || color.equals("red") || color.equals("blue") || color.equals("yellow")){
            this.color = color;
        }
        if(number >= 0 && number <= 9){
            this.number = number;
        }
    }
}
