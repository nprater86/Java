
public class Mammal {
	int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level: " + this.energyLevel);
		return this.energyLevel;
	}
}
