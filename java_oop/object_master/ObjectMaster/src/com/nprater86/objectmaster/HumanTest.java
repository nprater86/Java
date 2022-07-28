package com.nprater86.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test Human
		System.out.println("TEST HUMAN:");
		Human human1 = new Human();
		Human human2 = new Human();
		
		System.out.println(human1.getHealth());
		System.out.println(human2.getHealth());
		
		human1.attack(human2);
		
		System.out.println(human1.getHealth());
		System.out.println(human2.getHealth());
		
		System.out.println();
		
		//Test Wizard
		System.out.println("TEST WIZARD:");
		Wizard wizard1 = new Wizard();
		System.out.println(wizard1.getHealth());
		
		wizard1.heal(human2);
		System.out.println(human2.getHealth());
		
		wizard1.fireball(human1);
		System.out.println(human1.getHealth());
		
		System.out.println();
		
		//Test Ninja
		System.out.println("TEST NINJA:");
		Ninja ninja1 = new Ninja();
		System.out.println(ninja1.getHealth());
		
		ninja1.steal(human2);
		System.out.println(ninja1.getHealth());
		System.out.println(human2.getHealth());
		
		ninja1.runAway();
		System.out.println(ninja1.getHealth());
		
		System.out.println();
		
		//Test Samurai
		System.out.println("TEST SAMURAI:");
		Samurai samurai1 = new Samurai();
		System.out.println(samurai1.getHealth());
		
		samurai1.deathBlow(human2);
		System.out.println(samurai1.getHealth());
		System.out.println(human2.getHealth());
		
		samurai1.meditate();
		System.out.println(samurai1.getHealth());
		samurai1.meditate();
		System.out.println(samurai1.getHealth());
		samurai1.meditate();
		System.out.println(samurai1.getHealth());
		
		System.out.println(Samurai.howMany());
		
		
	}

}
