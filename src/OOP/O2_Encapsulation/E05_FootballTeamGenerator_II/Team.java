package OOP.O2_Encapsulation.E05_FootballTeamGenerator_II;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player playerToRemove = players.stream().filter(player -> player.getName().equals(name)).findFirst()
        .orElseThrow(InvalidParameterException::new);
        this.players.remove(playerToRemove);
    }

    public double getRating() {
        return this.players.stream().mapToDouble(players -> players.overallSkillLevel()).sum();
    }
}
