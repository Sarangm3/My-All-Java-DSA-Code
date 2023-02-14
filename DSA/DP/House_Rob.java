package DSA.DP;

import java.util.*;

class Solution2 {

    public int solveMem(int [] nums,int n,int [] dp)
    {
        if(n<0)
            return 0;
        if(n==0)
            return nums[n];
        if(dp[n]!=-1)
            return dp[n];
        int incl = solveMem(nums,n-2,dp)+nums[n];
        int excl = solveMem(nums,n-1,dp);

        return dp[n]=Math.max(incl,excl);
    }
    public int solveTab(int [] nums)
    {
        int n = nums.length;
        int [] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1 ; i<n ;i++)
        {
            if(i-2<0){
                dp[i] = Math.max(dp[0],nums[i]);
            }
            else{
                int incl = dp[i-2] + nums[i];
                int excl = dp[i-1] + 0;
                dp[i] = Math.max(incl,excl);
            }
        }
        return dp[n-1];
    }
    public int opt(int [] nums)
    {
        int first=0;
        int second=nums[0];
        if(nums.length==0)
            return nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int incl = first + nums[i];
            int excl = second + 0;
            int ans = Math.max(incl,excl);

            first = second;
            second = ans;
        }
        return second;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        // return solveMem(nums,n-1,dp);
        // return solveTab(nums);
        return opt(nums);
    }

}

public class House_Rob {
    public static void main(String[] args) {

        Solution2 s =new Solution2();
        System.out.println(s.rob(new int[]{2,7,9,3,1}));

    }
}
