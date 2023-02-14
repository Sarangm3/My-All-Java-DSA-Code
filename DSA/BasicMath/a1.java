package DSA.BasicMath;

import java.util.Scanner;

public class a1{

    static boolean isPalindrome2(int n)
    {
        int rev=0;
        int temp=n;
        //   123
        while (n>0)
        {
            rev=rev*10+n%10;
            n=n/10;
        }
        if (temp==rev)
        {
            return true;
        }
        return false;
    }
    static boolean isPalindrome(int n)// time=O(d) and spece=o(d)
    {
        int digit=(int)(Math.log(n)/Math.log(10))+1;
        int [] arry = new int[digit];
        int i=0;
        while(n>0)
        {
            arry[i]=n%10;
            n=n/10;
            i++;
        }
        int count=0;
        for (i=0;i<digit/2;i++)
        {
            if (arry[i]==arry[digit-1-i])
            {
                count++;
            }
        }
        if (count==digit/2)
        {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        int NUM1;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter nubmer:");
        NUM1=sc.nextInt();

        if (isPalindrome(NUM1))
        {
            System.out.println("your nubmber is palindrome");
        }
        else
        {
            System.out.println("your number is not palindrome");
        }
        if (isPalindrome2(NUM1))
        {
            System.out.println("your nubmber is palindrome");
        }
        else
        {
            System.out.println("your number is not palindrome");
        }


    }
}