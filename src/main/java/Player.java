import java.util.ArrayList;
import java.util.List;

public class Player {
    Integer id;
    List<Card> hand = new ArrayList<>();

    public Player(Integer id) {
        this.id = id;
    }
}
