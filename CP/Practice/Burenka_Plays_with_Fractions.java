package CP.Practice;

import java.util.*;

public class Burenka_Plays_with_Fractions {
    static void solve(long a,long b,long c,long d) {

        Scanner s =new Scanner(System.in);
        double x = a * d, y = b * c;
        if (x == y)
            System.out.println("0");
        else if (y != 0 && x % y == 0 || x != 0 && y % x == 0)
            System.out.println("1");
        else
            System.out.println("2");
    }
    public static void main(String[] args) {

        Scanner s =new Scanner(System.in);
        int t = s.nextInt();
        long a, b, c, d;
        while (t!=0) {
            a = s.nextLong();
            b = s.nextLong();
            c = s.nextLong();
            d = s.nextLong();
            solve(a,b,c,d);
            t--;
        }
    }
}
