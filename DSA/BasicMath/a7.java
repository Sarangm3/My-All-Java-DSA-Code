package DSA.BasicMath;

import java.util.Scanner;
import java.util.Arrays;
public class a7 {

    static boolean isPrime(int n)
    {
        if(n==0) return false;
        if (n==2||n==3) return true;
        if (n%2==0 || n%3==0) return false;
        for (int i=5;i*i<=n;i=i+6)
        {
            if (n%i==0 ||n%(i+2)==0)
            {
                return false;
            }
        }
        return true;
    }
    static void sieverOfEratorthenes (int n)
    {
        for (int i= 2;i<=n;i++)
        {
            if (isPrime(i))
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void sieverOfEratorthenes1 (int n)
    {
        boolean [] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for (int i=2;i<=n;i++)//for print prime we take loop n
        {
            if (isPrime[i])
            {
                System.out.print(i+" ");
                for (int j=i*i;j<=n;j=j+i)//for all not prime factor gone  false under n
                    //i*i kem ke if i=5 hoy 25 thi pachhi badu false kare
                    //i=2 and i=3 e 10 15 20 flase kari nakiya hoy then 25,30,35...
                {
                    isPrime[j]=false;
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int n;
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        sieverOfEratorthenes(n);
        sieverOfEratorthenes1(n);
    }
}
