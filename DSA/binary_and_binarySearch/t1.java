package DSA.binary_and_binarySearch;

import java.util.Scanner;

public class t1{
    static long reverse(long a) {
        int count=0;
        long temp=a;
        while(a>0)
        {
            count++;
            a=a>>1;
        }
        int num= 32-count;
        long res= temp<<(32-count);
        return res;
    }
    static long reverse1(long A)
    {
            long rev = 0;

            for (int i = 0; i < 32; i++) {
                rev <<= 1;
                if ((A & (1 << i)) != 0)
                    rev |= 1;
            }

            return rev;

    }
    static long reverse2(long a)
    {
        long rev=0;
        int count=0;
        while(a>0)
        {
            rev=rev*2+(a&1);
            a=a>>1;
            count++;
        }
        return rev<<(32-count);
    }

    public static void main(String[] args) {
        long n;
        System.out.println("enter number:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println(reverse(n));
        System.out.println(reverse1(n));
        System.out.println(reverse2(n));

    }
}
