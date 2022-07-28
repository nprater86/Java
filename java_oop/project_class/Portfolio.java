import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects;

    public Portfolio() {
        this.projects = new ArrayList<Project>();
    }

    public void setProject(int idx, Project project) {
        this.projects.set(idx, project);
    }

    public Project getProject(int idx) {
        return projects.get(idx);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public double getPortfolioCost() {
        double total = 0;

        for(Project project : projects) {
            total += project.getInitialCost();
        }

        return total;
    }

    public void showPortfolio() {
        for(Project project : projects) {
            System.out.println(project.elevatorPitch());
        }
    }
}
