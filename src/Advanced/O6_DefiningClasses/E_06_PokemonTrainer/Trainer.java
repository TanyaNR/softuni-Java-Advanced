package Advanced.O6_DefiningClasses.E_06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
   private String name;
   private int badges = 0;
   private List<Pokemon> pokemons = new ArrayList<Pokemon>();

   public Trainer(String name) {
      this.name = name;
   }

   public void addBadge() {
      badges++;
   }

   public void addPokemon(Pokemon pokemon) {
      pokemons.add(pokemon);
   }

   public String getName() {
      return name;
   }

   public List<Pokemon> getPokemons() {
      return pokemons;
   }

   public int getBadges() {
      return badges;
   }

   @Override
   public String toString () {
      return (name + " " + badges + " " + pokemons.size());
   }

   public Boolean isElementInColection(String command) {
      for (Pokemon pokemon : pokemons) {
         if (pokemon.getElement().equals(command)) {
            return true;
         }
      }
      return false;
   }


   public void getDecreaseHealthOrRemovedIt() {
      for (Pokemon pokemon : pokemons) {
         pokemon.subtractionHealth();
      }
      pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
   }
}
