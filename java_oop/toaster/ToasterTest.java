public class ToasterTest {
    public static void main(String[] args){
        //create two toasters, one with default capacity of two and one with a set capacity of 4
        Toaster twoToaster = new Toaster();
        Toaster fourToaster = new Toaster(4);

        //test the getCapacity method
        System.out.println(twoToaster.getCapacity()); //output: 2
        System.out.println(fourToaster.getCapacity()); //output: 4

        //add some bread to the bread List
        Bread bread1 = new Bread();
        Bread bread2 = new Bread();
        Bread bread3 = new Bread();
        twoToaster.addBread(bread1);
        twoToaster.addBread(bread2);
        twoToaster.addBread(bread3); //should print that the toaster is full

        //test breadStatus method
        twoToaster.breadStatus(); //output: all bread is UNTOASTED
        fourToaster.breadStatus(); //output: toaster is empty since we never added bread to this one

        //test toastBread method
        twoToaster.toastBread(); //toasts all the bread
        twoToaster.breadStatus(); //should print out that all bread is TOASTED state now


        //test emptyToaster
        twoToaster.emptyToaster(); //will clear the array list
        twoToaster.breadStatus(); //should show that toaster is empty now

        //check bread1 and bread2 status after being in toaster
        System.out.println(bread1.getState());
        System.out.println(bread2.getState());
    }
}
