package com.nprater86.phone;

public class Galaxy extends Phone implements Ringable{
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
	
    @Override
    public String ring() {
        // your code here
    	return "Galaxy " + this.getVersionNumber() + " says " + this.getRingTone();
    }
    @Override
    
    public String unlock() {
        // your code here
    	return "Galaxy " + this.getVersionNumber() + " unlocked.";
    }
    
    @Override
    public void displayInfo() {
        // your code here     
    	System.out.println("Galaxy " + this.getVersionNumber() + " from " + this.getCarrier());
    }
}
