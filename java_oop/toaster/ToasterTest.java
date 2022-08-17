public class ToasterTest {
    public static void main(String[] args){
        //create two toasters, one with default capacity of two and one with a set capacity of 4
        Toaster twoToaster = new Toaster();
        Toaster fourToaster = new Toaster(4);

        //test the getCapacity method
        System.out.println(twoToaster.getCapacity());
        System.out.println(fourToaster.getCapacity());

        //add some bread to the bread List
        Bread bread1 = new Bread();
        Bread bread2 = new Bread();
        Bread bread3 = new Bread();
        twoToaster.addBread(bread1);
        twoToaster.addBread(bread2);
        twoToaster.addBread(bread3);

        //test breadStatus method
        twoToaster.breadStatus();
        fourToaster.breadStatus();

        //test toastBread method
        twoToaster.toastBread();
        twoToaster.breadStatus();


        //test emptyToaster
        twoToaster.emptyToaster();
        twoToaster.breadStatus();
    }
}
