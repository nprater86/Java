
public class BatTest {

	public static void main(String[] args) {
		Bat batty = new Bat();
		
		//attack three towns
		batty.attackTown();
		batty.displayEnergy();
		batty.attackTown();
		batty.displayEnergy();
		batty.attackTown();
		batty.displayEnergy();
		
		//eat two humans
		batty.eatHumans();
		batty.displayEnergy();
		batty.eatHumans();
		batty.displayEnergy();
		
		//fly twice
		batty.fly();
		batty.displayEnergy();
		batty.fly();
		batty.displayEnergy();
	}

}
