public class Bread {
    //class variables
    private String state;

    public Bread(){
        this.state = "UNTOASTED";
    }

    //setters and getters
    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
}
