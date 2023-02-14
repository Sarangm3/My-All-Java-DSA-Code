package BasicJava;

import java.util.Scanner;

public class recursion {
    static int factorial(int n)
    {
        if (n==1 || n==0)
        {
            return 1;
        }

        return n* factorial(n-1);
    }
    static int fibonacci(int n)
    {
        if(n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {

        int num;
        System.out.print("Enter which number factorial:");
        Scanner s = new Scanner(System.in);
        num=s.nextInt();
        System.out.println("factorial of "+num+" is:"+factorial(num));
        System.out.println("fibonacci of "+num+" is:"+fibonacci(num));
    }
}
