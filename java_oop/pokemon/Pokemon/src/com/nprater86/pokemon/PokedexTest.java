package com.nprater86.pokemon;
import java.util.ArrayList;

public class PokedexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex myPokedex = new Pokedex();
		
		myPokedex.createPokemon("Squirtle", 100, "water");
		myPokedex.createPokemon("Charmander", 100, "fire");
		myPokedex.createPokemon("Bulbasaur", 100, "grass");
		myPokedex.createPokemon("Pikachu", 100, "electric");
		
		myPokedex.listPokemon();
		
		ArrayList<Pokemon> myPokemon = myPokedex.getMyPokemon();
		
		System.out.println(myPokedex.pokemonInfo(myPokemon.get(0)));
	}

}
