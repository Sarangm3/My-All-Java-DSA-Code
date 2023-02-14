package DSA.BasicMath;

import java.util.Scanner;

public class a8_power {

    static int power(int x,int n)
    {
        int result=1;
        for (int i=1;i<=n;i++)
        {
            result*= x;
        }
        return result;
    }
    static int power1(int x,int n)
    {
        if (n==0)
        {
            return 1;
        }
        int temp;
        temp=power1(x,n/2);
        temp=temp*temp;
        if (n%2==0)
        {
            return temp;//even
        }
        else
        return temp*x;//odd
    }
    static int power2(int x,int n)//bit vadu soulution
    {

        int answer=1;
//         2^10=2^8+2^2;   1010
//         x=2^2;
//        answer=2^2; and x=2^4;
//        x=2^8;
//        answer=2^2*2^8; and x=2^8*2^8;
//        return answer;   return 2^10;

        //
        //5^13;  1101
        //answer=1*5;  x=5^2;                at the end//n=6
        //x=5^2*5^2;                        //n=3
        //answer=5 * 5^4; x=5^8;           //n=1
        //answer=5^5 * 5^8; x=5^16        //n=0

        while (n > 0)
        {
            if ((n&1)==1)//odd
            {
                answer=answer * x;
            }
            x = x * x;
            n=n>>1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int x;
        int n;
        System.out.println("In x^n enter value of x and n");
        Scanner sc= new Scanner(System.in);
        x=sc.nextInt();
        n=sc.nextInt();
        System.out.println("x^n="+power(x,n));
        System.out.println("x^n="+power1(x,n));
        System.out.println("x^n="+power2(x,n));

    }
}