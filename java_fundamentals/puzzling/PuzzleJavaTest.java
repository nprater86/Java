public class PuzzleJavaTest {
    public static void main(String[] args)
    {
        PuzzleJava tester = new PuzzleJava();

        //test getTenRolls
        // int[] randomNums = tester.getTenRolls();
        // for(int num : randomNums)
        // {
        //     System.out.println(num);
        // }

        //test getRandomLetter
        // System.out.println(tester.getRandomLetter());

        //test generatePassword
        // System.out.println(tester.generatePassword());

        //test getNewPasswordSet
        String[] passwordSet = tester.getNewPasswordSet(5);
        for(String password : passwordSet)
        {
            System.out.println(password);
        }
    }
}
