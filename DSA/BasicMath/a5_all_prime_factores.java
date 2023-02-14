package DSA.BasicMath;


import java.util.Scanner;

public class a5_all_prime_factores {

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
    static void primeFactors(int n)
    {
        int i=2;
        while(i<=n)
        {
            if (isPrime(i) && n%i==0)
            {
                n=n/i;
                System.out.print(i+" ");
            }
            else
            {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Enter number:");
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        primeFactors(n);

    }

}