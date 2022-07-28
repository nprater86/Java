public class Project {
    private String name;
    private String description;
    private double initialCost;

    //constructors
    public Project() {
        this("","",0);
    }

    public Project(String name) {
        this(name, "",0);
    }

    public Project(String name, String description) {
        this(name, description,0);
    }

    public Project(String name, String description, double initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }

    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    public double getInitialCost() {
        return this.initialCost;
    }

    //methods
    public String elevatorPitch() {
        return name + "($" + initialCost + "): " + description;
    }
}
