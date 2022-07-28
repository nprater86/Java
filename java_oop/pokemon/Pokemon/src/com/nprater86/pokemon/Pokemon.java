package com.nprater86.pokemon;

public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int count = 0;
	
	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
	}
	
	public void attackPokemon(Pokemon pokemon) {
		int health = pokemon.getHealth();
		health -= 10;
		pokemon.setHealth(health);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
