import java.util.ArrayList;

public class Toaster {
    //class variables
    private int capacity;

    private ArrayList<Bread> bread;

    //constructors
    public Toaster(){
        this.capacity = 2;
        this.bread = new ArrayList<Bread>();
    }

    public Toaster(int capacity){
        this.capacity = capacity;
    }

    //getters and setters
    public int getCapacity(){
        return this.capacity; //we're not going to make a setter for capacity since we don't want capacity changing after a toaster has been made
    }

    public ArrayList<Bread> getBread(){
        return this.bread;
    }

    public void setBread(ArrayList<Bread> bread){
        this.bread = bread;
    }

    //methods
    public void addBread(Bread bread){
        //check to make sure the toaster isn't full yet
        if(this.bread.size() < this.capacity){
            //if not full, add the bread
            this.bread.add(bread);
            System.out.println("Bread added!");
        } else {
            //otherwise let the user know the toaster is full
            System.out.println("Toaster is full!");
        }
    }

    //this loops through all of the bread and prints the state
    public void breadStatus(){
        //if the list is null or the size is 0 then there's no bread currently in it
        if(this.bread == null || this.bread.size() < 1){
            System.out.println("Toaster is empty!");
        } else {
            //if not empty, then loop through the list and print out the state of each bread slice
            for(int i = 0; i < this.bread.size(); i++){
                System.out.println("Bread " + (i + 1) + " is " + bread.get(i).getState() + "!");
            }
        }
    }

    //this will loop through all of the bread in the bread list and change their state from UNTOASTED to TOASTED
    public void toastBread(){
        //loop through all the bread and set its state to "TOASTED"
        for(Bread bread : this.bread){
            bread.setState("TOASTED");
        }
    }

    //this will empty the bread list ONLY if all of the bread is toasted
    public void emptyToaster(){
        //create boolean for whether all the bread is toasted and set to true
        boolean allToasted = true;

        //loop through all of the bread to see if it's all toasted yet. If not, set allToasted to false
        for(Bread bread : this.bread){
            if(bread.getState() != "TOASTED"){
                allToasted = false;
            }
        }

        //if all bread is toasted, then clear the list
        if(allToasted){
            this.bread.clear();
        } else {
            //otherwise, let the user know there's still untoasted bread
            System.out.println("Not all bread is toasted yet!");
        }
    }
}
