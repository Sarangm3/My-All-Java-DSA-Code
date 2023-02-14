package DSA.BasicMath;

import java.util.Scanner;

public class a6 {
    static void DivisorsOfNumver(int n) {
        int i = 1;
        for (i = 1; i * i <= n; i++)//i^2<=n == i<N^1/2 or (int)sqrt(n)
        {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        for (; i > 0; i--)//i=(int)Math.sqrt(n); i= root ln pela thi chhe
        {
            if (n % i == 0) {
                if (n / i != i)
                    System.out.print(n / i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n;
        System.out.println("enter number:");
        Scanner  sc= new Scanner(System.in);
        n=sc.nextInt();
        DivisorsOfNumver(n);
    }
}
