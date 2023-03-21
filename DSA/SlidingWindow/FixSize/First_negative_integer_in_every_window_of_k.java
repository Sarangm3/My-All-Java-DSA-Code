package DSA.SlidingWindow.FixSize;

import java.util.*;

public class First_negative_integer_in_every_window_of_k {
    static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long [] ans = new long[N-K+1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<A.length;i++){
            //when remove only one case where element go out of bound
            if(!q.isEmpty() && q.getFirst()==i-K) {
                q.removeFirst();
            }

            if(A[i]<0) {
                // System.out.println(i);
                q.addLast(i);
            }

            if(i>=K-1){
                if(!q.isEmpty())
                    ans[i-K+1] = A[q.getFirst()];
                else
                    ans[i-K+1] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10},5,2)));
    }
}
