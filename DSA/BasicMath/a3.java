package DSA.BasicMath;

import java.util.Scanner;

public class a3 {

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

    public static void main(String[] args) {

        int num1;
        int num2;
        System.out.println("enter number for check gcd:");
        Scanner sc= new Scanner(System.in);
        num1=sc.nextInt();
        num2=sc.nextInt();
        System.out.println("your gcd of two number is:"+ GCD(num1,num2) );
    }
}
