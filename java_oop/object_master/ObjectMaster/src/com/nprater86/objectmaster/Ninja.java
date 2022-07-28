package com.nprater86.objectmaster;

public class Ninja extends Human{
	public Ninja() {
		this.setStealth(10);
	}
	
	public void steal(Human human) {
		int humanHp = human.getHealth();
		int thisHp = this.getHealth();
		
		humanHp -= this.getStealth();
		thisHp += this.getStealth();
		
		human.setHealth(humanHp);
		this.setHealth(thisHp);
	}
	
	public void runAway() {
		int thisHp = this.getHealth();
		thisHp -= 10;
		this.setHealth(thisHp);
	}
}
