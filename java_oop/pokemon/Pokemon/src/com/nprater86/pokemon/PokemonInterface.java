package com.nprater86.pokemon;

public interface PokemonInterface {
	Pokemon createPokemon(String name, int health, String type);
	String pokemonInfo(Pokemon pokemon);
	void listPokemon();
}
