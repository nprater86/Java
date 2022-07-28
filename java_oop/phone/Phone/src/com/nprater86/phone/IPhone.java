package com.nprater86.phone;

public class IPhone extends Phone implements Ringable{
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
	
    @Override
    public String ring() {
        // your code here
    	return "IPhone " + this.getVersionNumber() + " says " + this.getRingTone();
    }
    @Override
    
    public String unlock() {
        // your code here
    	return "IPhone " + this.getVersionNumber() + " unlocked.";
    }
    
    @Override
    public void displayInfo() {
        // your code here     
    	System.out.println("IPhone " + this.getVersionNumber() + " from " + this.getCarrier());
    }
}
