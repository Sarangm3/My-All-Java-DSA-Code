package DSA.binary_and_binarySearch;

import java.util.Scanner;

public class t3 {
    static long insertNumber(long n,long m,int i,int j)
    {
        //now we making mask
        //if i=10  and j=16
        //linke 1111111111111110000001111111111

        int mask=~0;
        mask=mask<<(j+1);//11..0000000000000000
        int endPart = ((1<<i)-1);
        mask=mask|endPart;
        n=n&mask;
        m=m<<i;
        return n|m;
    }
    public static void main(String[] args) {

        System.out.println(insertNumber(5,1,1,2));

    }
}
