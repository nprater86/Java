package com.nprater86.objectmaster;

public class Samurai extends Human{
	private static int numberOfSamurai = 0;
	
	public Samurai() {
		this.setHealth(200);
		numberOfSamurai++;
	}
	
	public void deathBlow(Human human) {
		human.setHealth(0);
		int thisHp = this.getHealth();
		thisHp /= 2;
		this.setHealth(thisHp);
	}
	
	public void meditate() {
		int thisHp = this.getHealth();
		thisHp = (this.getHealth()/2);
		this.setHealth(thisHp);
	}
	
	public static int howMany() {
		return numberOfSamurai;
	}
}
