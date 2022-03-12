package Advanced.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public List<Player> getRoster() {
        return roster;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        Player toRemove = null;
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                toRemove = player;
            }
        }
        if (toRemove != null) {
            return this.roster.remove(toRemove);
        }
        return false;
    }

    public void promotePlayer(String name) {
        this.roster.stream().filter(player -> getName().equals(name)).findFirst()
                .ifPresent(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        this.roster.stream().filter(player -> getName().equals(name)).findFirst()
                .ifPresent(player -> player.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayer = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                removedPlayer.add(player);
            }
        }
        Predicate<Player> removedPlayerWithSameClass = player -> player.getClazz().equals(clazz);
        this.roster.removeIf(removedPlayerWithSameClass);
        Player[] removedPlayerArr = new Player[removedPlayer.size()];
        return removedPlayer.toArray(removedPlayerArr);
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
    //o	"Players in the guild: {guildName}:
        //{Player1}
        //{Player2}
        //(…)"
        StringBuilder builder = new StringBuilder();
        builder.append("Players in the guild: " + this.name + ":").append(System.lineSeparator());
        for (Player player : roster) {
            builder.append(player);
        }
        return builder.toString();
    }
}
