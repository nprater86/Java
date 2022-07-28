
public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gorilla1 = new Gorilla();
		
		//throw three things
		gorilla1.throwSomething();
		gorilla1.displayEnergy();
		gorilla1.throwSomething();
		gorilla1.displayEnergy();
		gorilla1.throwSomething();
		gorilla1.displayEnergy();
		
		//eat twice
		gorilla1.eatBananas();
		gorilla1.displayEnergy();
		gorilla1.eatBananas();
		gorilla1.displayEnergy();
		
		//climb once
		gorilla1.climb();
		gorilla1.displayEnergy();
		
	}

}
