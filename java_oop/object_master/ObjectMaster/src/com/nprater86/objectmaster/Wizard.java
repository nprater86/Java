package com.nprater86.objectmaster;

public class Wizard extends Human{
	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
	}
	
	public void heal(Human human) {
		int humanHp = human.getHealth();
		humanHp += this.getIntelligence();
		human.setHealth(humanHp);
	}
	
	public void fireball(Human human) {
		int humanHp = human.getHealth();
		humanHp -= this.getIntelligence()*3;
		human.setHealth(humanHp);
	}
}
