package com.nprater86.pokemon;

public abstract class AbstractPokemon implements PokemonInterface {
	//implement createPokemon
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon newPokemon = new Pokemon(name, health, type);
		return newPokemon;
	}
	
	//implement pokemonInfo
	public String pokemonInfo(Pokemon pokemon) {
		return "Name: " + pokemon.getName() + " | Health: " + String.valueOf(pokemon.getHealth()) + " | Type: " + pokemon.getType();
	}
}
