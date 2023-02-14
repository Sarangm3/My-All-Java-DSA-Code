package DSA.DP;

import java.util.Arrays;

class Solution {

    public int solveRec(int[] coins, int amount)
    {
        if(amount==0)
            return 0;
        if(amount<0)
            return Integer.MAX_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i=0; i< coins.length;i++)
        {
            int ans = solveRec(coins,amount-coins[i]);
            if(ans!=Integer.MAX_VALUE)
            {
                mini = Math.min(mini,ans+1);
            }
        }
        return mini;
    }
    public int solveMem(int [] coins,int amount,int [] dp)
    {
        if(amount==0)
            return 0;
        if(amount<0)
            return Integer.MAX_VALUE;
        if(dp[amount]!=-1)
            return dp[amount];

        int mini = Integer.MAX_VALUE;
        for(int i=0; i< coins.length;i++)
        {
            int ans = solveMem(coins,amount-coins[i],dp);
            if(ans!=Integer.MAX_VALUE)
            {
                mini = Math.min(mini,ans+1);
            }
        }
        dp[amount] = mini;
        return mini;
    }
    public int solveTab(int [] coins,int amount)
    {
        int [] dp = new int[amount+1];
        //bottom up so we use all max element
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]>=0 && dp[i-coins[j]] != Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1); // we use all max element
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
//         if(solveRec(coins,amount)==Integer.MAX_VALUE)
//         {
//             return -1;
//         }

//         return solveRec(coins,amount);
//         int [] dp = new int[amount+1];
//         Arrays.fill(dp,-1);

//         if(solveMem(coins,amount,dp)==Integer.MAX_VALUE)
//         {
//             return -1;
//         }

//         return solveMem(coins,amount,dp);
        return solveTab(coins,amount);
    }
    public int solveOS(int [] nums)
    {
        int first = 0;
        int second = nums[0];
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
        int [] first =new int[n-1];
        int [] last  =new int[n-1];
        for(int i=0 ; i<n ;i++)
        {
            if(i==0)
            {
                first[i] = nums[i];
                continue;
            }
            if(i==n-1)
            {
                last[i-1] = nums[i];
                continue;
            }
            first[i] = nums[i];
            last[i-1] = nums[i];
        }
        return Math.max(solveOS(first),solveOS(last));
    }

}
public class Change_Coin {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.coinChange(new int[]{2,5},11));
        System.out.println(s1.rob(new int[]{0}));
    }

}
