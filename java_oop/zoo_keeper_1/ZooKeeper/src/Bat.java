
public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	public void fly() {
		System.out.println("Bat takes off flying, decreasing its energy by 50.");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Bat eats some humans, increasing its energy by 25.");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Bat attacks a town, decreasing its energy by 100.");
		this.energyLevel -= 100;
	}
}
