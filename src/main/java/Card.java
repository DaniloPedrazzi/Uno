public class Card {
    String color;
    Integer number;

    public Card(String color, Integer number) {
        if(color.equals("\uD83D\uDFE9") || color.equals("\uD83D\uDFE5") || color.equals("\uD83D\uDFE6") || color.equals("\uD83D\uDFE8")){
            this.color = color;
        }
        if(number >= 0 && number <= 9){
            this.number = number;
        }
    }
}
