public class ProjectTest {
    public static void main(String[] args) {
        Project testProject1 = new Project();
        Project testProject2 = new Project("Tester2");
        Project testProject3 = new Project("Tester3","This project was created to test the final constructor");

        //test getters
        System.out.println(testProject1.getName());
        System.out.println(testProject1.getDescription());
        System.out.println(testProject2.getName());
        System.out.println(testProject2.getDescription());
        System.out.println(testProject3.getName());
        System.out.println(testProject3.getDescription());

        //test setters
        testProject1.setName("Tester1");
        System.out.println(testProject1.getName());
        testProject1.setDescription("This project was created to test the first constructor");
        System.out.println(testProject1.getDescription());
        testProject2.setDescription("This project was created to test the second constructor");
        System.out.println(testProject2.getDescription());
        testProject1.setInitialCost(20);
        testProject2.setInitialCost(20);
        testProject3.setInitialCost(20);


        //elevator pitches
        System.out.println(testProject1.elevatorPitch());
        System.out.println(testProject2.elevatorPitch());
        System.out.println(testProject3.elevatorPitch());

        //test Portfolio
        Portfolio portfolioTest = new Portfolio();
        portfolioTest.addProject(testProject1);
        portfolioTest.addProject(testProject2);
        portfolioTest.addProject(testProject2);

        System.out.println(portfolioTest.getPortfolioCost());
        portfolioTest.showPortfolio();

    }
}
