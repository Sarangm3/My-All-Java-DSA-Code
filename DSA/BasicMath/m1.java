package DSA.BasicMath;


import java.math.BigInteger;

public class m1 {
//    static BigInteger fac(long n)
    static long fac(long n)
    {
//        BigInteger f = new BigInteger("1");
//        for(int i=1; i<=n  ;i++)
//        {
//            f=f.multiply(BigInteger.valueOf(i));
//        }
//        return f;
        double r = Math.pow(((1+Math.sqrt(5))/2),n);
        double l = Math.pow(((1-Math.sqrt(5))/2),n);
        double n1 = 1/Math.sqrt(5);

        long i = (int)(n1*(r-l));
        return i;
    }
    static boolean isprime(int n)
    {

        if (n<=1)
        {
            return false;
        }
        // if n= 37
        // n^1/2 = 6. something
        // i = 2
        // i = 3
        // i = 4
        // i = 5
        // i = 6
        for (int i=2; i<=Math.sqrt(n);i++)
        {
            if (n%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(fac(46));
        System.out.println(isprime(32));
    }
}
