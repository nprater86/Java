public class BasicJava 
{

    //Print 1-255
    public void print255() 
    {
        for(int i = 1; i <= 255; i++) 
        {
            System.out.println(i);
        }
    }

    //Print odd num between 1-255
    public void printOdd255() 
    {
        for(int i = 1; i <= 255; i++) 
        {
            if(i%2 != 0) 
            {
                System.out.println(i);
            }
            
        }
    }

    //Sum to 255
    public int sum255() 
    {
        int sum = 0;
        for(int i = 1; i <= 255; i++) 
        {
            sum += i;
        }

        return sum;
    }

    //Iterating through an Array
    public void iterateArray(int[] arr) 
    {
        for(int num : arr)
        {
            System.out.println(num);
        }
    }

    //Find Max
    public void findMax(int[] arr)
    {
        int max = arr[0];

        for(int num : arr)
        {
            if(num > max)
            {
                max = num;
            }
        }

        System.out.println(max);
    }

    //Array With Odd Numbers
    public int[] arrayWithOdd()
    {
        int[] oddArray;
        oddArray = new int[128];
        int count = 1;

        for(int i = 0; i < 128; i++) 
        {
            oddArray[i] = count;
            count += 2;
        }

        return oddArray;
    }

    //Get Average
    public double getAverage(int[] arr)
    {
        double sum = 0;

        for(int num : arr)
        {
            sum += num;
        }

        return sum / arr.length;
    }

    //Greater than Y
    public int greaterThanY(int[] arr, int y)
    {
        int count = 0;

        for(int num : arr)
        {
            if(num > y)
            {
                count++;
            }
        }

        return count;
    }

    //square the values
    public int[] squareValues(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] *= arr[i];
        }

        return arr;
    }

    //eliminate negative numbers
    public int[] eliminateNegatives(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0)
            {
                arr[i] = 0;
            }
        }

        return arr;
    }
}