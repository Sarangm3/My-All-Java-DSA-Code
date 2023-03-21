package DSA.SlidingWindow.FixSize;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_Sum_Subarray_of_size_K {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        long maxi= 0;
        long sum = 0;
        int i = 0;

        while(i<Arr.size()){
            //when to remove is present in take action
            sum += Arr.get(i);

            //when take action
            if(i>=K-1){
                maxi = Math.max(maxi,sum);
                sum -= Arr.get(i-K+1);
            }
            i++;
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(maximumSumSubarray(2,new ArrayList<>(Arrays.asList(100, 200, 300, 400)),4));
    }

}
