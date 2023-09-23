import java.util.ArrayList;
import java.util.List;

public class PlayerHandler {
    static List<Player> buildPlayers(Integer playerAmount){
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerAmount; i++) {
            players.add(new Player());
        }
        return players;
    }
}