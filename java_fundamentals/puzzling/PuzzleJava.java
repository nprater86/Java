import java.util.Random;

public class PuzzleJava {
    Random rand = new Random();
    
    public int[] getTenRolls()
    {
        int[] randomNums;
        randomNums = new int[10];

        for(int i = 0; i < randomNums.length; i++)
        {
            randomNums[i] = rand.nextInt(20) + 1;
        }

        return randomNums;
    }

    public char getRandomLetter()
    {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int randomIdx = rand.nextInt(26);
        return alphabet[randomIdx];
    }

    public String generatePassword()
    {
        String password = "";

        while(password.length() < 8)
        {
            password += this.getRandomLetter();
        }

        return password;
    }

    public String[] getNewPasswordSet(int n)
    {
        String[] passwordSet;
        passwordSet = new String[n];

        for(int i = 0; i < n; i++)
        {
            passwordSet[i] = this.generatePassword();
        }

        return passwordSet;
    }

    
}
