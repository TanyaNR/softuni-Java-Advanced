package OOP.O2_Encapsulation.E05_FootballTeamGenerator_II;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, OOP.O2_Encapsulation.E05_FootballTeamGenerator_II.Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String command = input.split(";")[0];
            String teamName = input.split(";")[1];

            switch (command) {
                case "Team":
                    OOP.O2_Encapsulation.E05_FootballTeamGenerator_II.Team team = new OOP.O2_Encapsulation.E05_FootballTeamGenerator_II.Team(teamName);
                    teams.putIfAbsent(teamName, team);
                    break;
                case "Add":
                    Team currentTeam = teams.get(teamName);
                    if (currentTeam == null) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        String playerName = input.split(";")[2];
                        int endurance = Integer.parseInt(input.split(";")[3]);
                        int sprint = Integer.parseInt(input.split(";")[4]);
                        int dribble = Integer.parseInt(input.split(";")[5]);
                        int passing = Integer.parseInt(input.split(";")[6]);
                        int shooting = Integer.parseInt(input.split(";")[7]);

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        currentTeam.addPlayer(player);
                        teams.put(teamName, currentTeam);
                    }
                    break;
                case "Remove":
                    String playerName2 = input.split(";")[2];
                    try {
                        Team currentTeam2 = teams.get(teamName);
                        currentTeam2.removePlayer(playerName2);
                    } catch (IllegalArgumentException exception) {
                        System.out.println("Player " + playerName2 + " is not in " + teamName + " team.");
                    }
                    break;
                case "Rating":
                    Team currentTeams3 = teams.get(teamName);
                    if (currentTeams3 != null) {
                        System.out.printf("%s – %.0f", teamName, currentTeams3.getRating());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
