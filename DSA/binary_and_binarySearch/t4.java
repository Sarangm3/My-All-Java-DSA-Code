package DSA.binary_and_binarySearch;

import java.util.Scanner;

public class t4 {
    static int getNext(int n)
    {
    /* Compute c0
    and c1 */
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0))
        {
            c0 ++;
            c >>= 1;
        }
        while ((c & 1) == 1)
        {
            c1++;
            c >>= 1;
        }

        // If there is no bigger number
        // with the same no. of 1's
        if (c0 + c1 == 31 || c0 + c1 == 0)
            return -1;

        return n + (1 << c0) +
                (1 << (c1 - 1)) - 1;
    }


    static int getPrev(int n)
    {
        // Compute c0 and
        // c1 and store N
        int temp = n;
        int c0 = 0;
        int c1= 0;

        while((temp & 1) == 1)
        {
            c1++;
            temp = temp >> 1;
        }

        if(temp == 0)
            return -1;

        while(((temp & 1) == 0) &&
                (temp!= 0))
        {
            c0++;
            temp = temp >> 1;
        }

        // position of rightmost
        // non-trailing one.
        int p = c0 + c1;

        // clears from bit p onwards
        n = n  &( (~0)<<(p +1));

        // Sequence of (c1+1) ones
        int mask = (1 << (c1 + 1)) - 1;

        n = n | mask << (c0 - 1);

        return n;
    }
    static int closestGreater(int x)
    {
        int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;

        if(x > 0)
        {

            // right most set bit
            rightOne = x & -x;

            // reset the pattern and set next higher bit
            // left part of x will be here
            nextHigherOneBit = x + rightOne;

            // nextHigherOneBit is now part [D] of the above explanation.

            // isolate the pattern
            rightOnesPattern = x ^ nextHigherOneBit;

            // right adjust pattern
            rightOnesPattern = (rightOnesPattern)/rightOne;

            // correction factor
            rightOnesPattern >>= 2;

            // rightOnesPattern is now part [A] of the above explanation.

            // integrate new pattern (Add [D] and [A])
            next = nextHigherOneBit | rightOnesPattern;
        }

        return next;
    }

    static int closestSmaller(int x)
    {
        int rightOne, beforeHigherOneBit, rightOnesPattern, before = 0;

        if(x > 0)
        {

            // right most set bit
            rightOne = x & -x;

            // reset the pattern and set next higher bit
            // left part of x will be here
            beforeHigherOneBit = x + rightOne;
            beforeHigherOneBit>>=1;
            // nextHigherOneBit is now part [D] of the above explanation.

            // isolate the pattern
            rightOnesPattern = x ^ beforeHigherOneBit;

            // right adjust pattern
            rightOnesPattern = (rightOnesPattern)/rightOne;

            // rightOnesPattern is now part [A] of the above explanation.

            // correction factor
                rightOnesPattern >>= 0;

            // integrate new pattern (Add [D] and [A])
            before = beforeHigherOneBit | rightOnesPattern;
            if (before>x)
            {
                rightOnesPattern>>=2;
                before=0;
                before=beforeHigherOneBit|rightOnesPattern;
            }

        }

        return before;
    }

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();

        System.out.println(closestGreater(n));
        System.out.println(closestSmaller(n));
        System.out.println(getNext(n));
        System.out.println(getPrev(n));

    }
}
