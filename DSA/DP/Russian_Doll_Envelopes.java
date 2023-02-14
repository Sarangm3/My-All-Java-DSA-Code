package DSA.DP;

import java.util.Arrays;
import java.util.Comparator;

//class Solution10 {
//    public int optimizeSolv(int []nums){
//        int [] ans = new int[nums.length];
//        int size = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(size ==0 || ans[size-1] < nums[i])
//            {
//                ans[size] =nums[i];
//                size++;
//            }
//            else {
//                int index = Arrays.binarySearch(ans,0,size,nums[i]);
//                if(index<0) index = -(index+1);
//                ans[index] = nums[i];
//            }
//        }
//        return size;
//    }
//    public int lengthOfLIS(int[] nums) {
//        return optimizeSolv(nums);
//    }
//    public static void sortbyColumn(int arr[][], int col,int col1)
//    {
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(final int[] entry1,final int[] entry2) {
//                if (entry1[col] > entry2[col])
//                    return 1;// swap them
//                else if (entry1[col] < entry2[col])
//                    return -1;
//                else if(entry1[col1] < entry2[col1])
//                    return 1; // swap them
//                return -1;
//            }
//        });
//    }
//
//    public int maxEnvelopes(int[][] envelopes) {
//        sortbyColumn(envelopes,0,1);
//        int [] ans = new int[envelopes.length];
//        for (int i = 0; i < envelopes.length; i++) {
//            ans[i] = envelopes[i][1];
//            System.out.print(envelopes[i][1]+" ");
//        }
//        return lengthOfLIS(ans);
//    }
//}
class Solution10{

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1]; //a1[1] < a2[1] //des
                else
                    return arr1[0] - arr2[0]; //a1[0] > a2[0] // asc
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
}
public class Russian_Doll_Envelopes {
    public static void main(String[] args) {
        Solution10 s = new Solution10();

        int [][] arr = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(s.maxEnvelopes(arr));
    }
}
