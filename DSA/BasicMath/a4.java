package DSA.BasicMath;

import java.util.Scanner;

public class a4 {

    static int GCD(int n,int m)
    {

        for (int i=Math.min(m,n);i>0;i--)
        {
            if (m%i==0 && n%i==0)
            {
                return i;
            }
        }
        return 1;
    }

    static int LCM(int m,int n) {

        for(int i=Math.max(m,n);i<=m*n;i++)
        {
            if (i%n==0 && i%m==0)
            {
                return i;
            }
        }
        return 0;
    }

    static int LCM2(int n,int m)
    {
        return m*n /GCD(m,n);
    }
    public static void main(String[] args) {
        int num1;
        int num2;
        System.out.println("enter number for check gcd:");
        Scanner sc= new Scanner(System.in);
        num1=sc.nextInt();
        num2=sc.nextInt();
        System.out.println("your lcm of two number is:"+ LCM(num1,num2));
        System.out.println("your lcm of two number is:"+ LCM2(num1,num2));
    }
}
