package DSA.DP;

import java.util.ArrayList;
import java.util.Arrays;

class Solution9 {

    public int solveRec(int [] nums,int curr,int prev)
    {
        if(curr == nums.length)
            return 0;
        int include = 0;
        if(prev == -1 || nums[prev]<nums[curr]){
            include =1 + solveRec(nums,curr+1,curr);
        }
        int exclude =0 + solveRec(nums,curr+1,prev);

        return Math.max(include,exclude);
    }
    public int solveMem(int [] nums,int curr,int prev,int [][]dp)
    {
        if(curr+1 == nums.length)
            return 0;
        if(dp[curr][prev]!=-1)
            return dp[curr][prev];

        int include = 0;
        if(prev == 0 || nums[prev]<nums[curr]){
            include =1 + solveMem(nums,curr+1,curr,dp);
        }
        int exclude =0 + solveMem(nums,curr+1,prev,dp);

        return dp[curr][prev] = Math.max(include,exclude);
    }
    public int solveTab(int [] nums)
    {
        int[][]dp = new int[nums.length+1][nums.length+1];

        for(int curr = nums.length-1 ; curr >= 0;curr--)
        {
            for(int prev = curr-1 ; prev >= -1 ;prev--)// prev alway less then curr we optimize solutoin
            {
                int include = 0;
                if( prev == -1 || nums[prev]<nums[curr]){
                    include = nums[curr]  + dp[curr+1][curr+1];// we use [][curr+1] because show prev is col value +1
                }

                int exclude =0 + dp[curr+1][prev+1];

                dp[curr][prev+1] = Math.max(include,exclude);
            }
        }
        return dp[0][0];
    }
    public int solveTab1(int [] nums)
    {
        int [] prevRow = new int[nums.length+1];
        int [] currRow = new int[nums.length+1];

        for(int curr = nums.length-1 ; curr >= 0;curr--)
        {
            for(int prev = curr-1 ; prev >= -1 ;prev--)// prev alway less then curr we optimize solutoin
            {
                int include = 0;
                if( prev == -1 || nums[prev]<nums[curr]){
                    include =1+ prevRow[curr+1];// we use [][curr+1] because show prev is col value +1
                }

                int exclude =0 + prevRow[prev+1];

                currRow[prev+1] = Math.max(include,exclude);
            }
            prevRow = Arrays.copyOf(currRow,currRow.length);
        }
        return prevRow[0];
    }

    // we can use solve in o(n) space complexity

    //but can also done in o(n*logn) and o(n) space complexity
    //we go with row greedy add all value but then we use
    // binary search for add number at there position
    //we find size of array.

    public int optimizeSolv(int []nums){
        int [] ans = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if(size ==0 || ans[size-1] < nums[i])
            {
                ans[size] =nums[i];
                size++;
            }
            else {
//                int index =  binarySearch0(ans,0,size, nums[i]) ;
                int index = Arrays.binarySearch(ans,0,size,nums[i]);
                if(index<0) index = -(index+1);
                ans[index] = nums[i];
            }
        }
        return size;
    }
    public int lengthOfLIS(int[] nums) {
        // return solveRec(nums,0,-1);
        // int [][] dp = new int[nums.length+1][nums.length+1];
        // for(int i = 0;i<nums.length+1;i++)
        //     Arrays.fill(dp[i],-1);
        // return solveMem(nums,0,-1,dp);
        return solveTab(nums);
//        return optimizeSolv(nums);
//        return solveTab1(nums);
    }
    public int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return low;  // key not found.
    }
}
public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        Solution9 s = new Solution9();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
