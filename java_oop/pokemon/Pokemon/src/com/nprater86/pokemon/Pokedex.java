package com.nprater86.pokemon;
import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
	private ArrayList<Pokemon> myPokemon = new ArrayList<Pokemon>();
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon newPokemon = super.createPokemon(name, health, type);
		myPokemon.add(newPokemon);
		return newPokemon;
	}
	
	public void listPokemon() {
		for(Pokemon pokemon : myPokemon) {
			System.out.println(pokemon.getName());
		}
	}
	
	public ArrayList<Pokemon> getMyPokemon(){
		return myPokemon;
	}
}
