
public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla has thrown something and decreased its energy level by 5.");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla has eaten a banana and increased its energy by 10.");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree and decreased its energy by 10.");
		this.energyLevel -= 10;
	}
}
