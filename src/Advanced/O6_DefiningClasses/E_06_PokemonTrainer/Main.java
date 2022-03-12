package Advanced.O6_DefiningClasses.E_06_PokemonTrainer;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).addPokemon(pokemon);
            } else {
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                trainers.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Map.Entry<String, Trainer> stringTrainerEntry : trainers.entrySet()) {
                if (stringTrainerEntry.getValue().isElementInColection(command)) {
                    stringTrainerEntry.getValue().addBadge();
                } else {
                    stringTrainerEntry.getValue().getDecreaseHealthOrRemovedIt();
                }

            }


            command = scanner.nextLine();
        }


        Comparator<Trainer> compareByBadge =
                (Trainer t1, Trainer t2) -> {
                    int t1TrainerBages = t1.getBadges();
                    int t2TrainerBages = t2.getBadges();

                    if (t2TrainerBages < t1TrainerBages) {
                        return -1;
                    } else if (t1TrainerBages == t2TrainerBages) {
                        return 0;
                    } else {
                        return 1;
                    }
                };

        List<Trainer> trainersList = new ArrayList<>(trainers.values());

        trainersList.sort(compareByBadge);

        for (
                Trainer trainer : trainersList) {
            System.out.println(trainer);
        }
    }
}

