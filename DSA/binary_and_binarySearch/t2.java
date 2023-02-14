package DSA.binary_and_binarySearch;

import java.util.Scanner;

public class t2 {
    static int num1(int n)
    {
        int count=0;
        while(n!=0)
        {
            n=n&n-1;
            count++;
        }
        return count;
    }
    static int countSetBits(long n)
    {
        int rev=0;
        for (int i=1;i<=n;i++)
        {
            rev= rev+num1(i);
        }
        return rev;
    }
    public static void main(String[] args) {

        int n;
        System.out.println("Enter number");
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        System.out.println(countSetBits(n));
    }
}
