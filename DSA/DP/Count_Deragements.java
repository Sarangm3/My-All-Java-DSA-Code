package DSA.DP;

import java.util.*;
class Solution1 {
    static long  mod = 1000000007;

    static long solveRec(int n)
    {
        if(n==1)
            return 0;
        if(n==2)
            return 1;

        return (n-1) * (solveRec(n-1)%mod + solveRec(n-2)%mod);
    }
    static long solveMem(int n,long [] dp)
    {
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        if(dp[n]!=-1)
            return dp[n];

        return dp[n]=(n-1) * (solveMem(n-1,dp) + solveMem(n-2,dp));
    }
    static long solveTab(int n)
    {
        long [] dp = new long[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3;i<=n;i++)
        {
            dp[i]= (i-1) * (dp[i-1]%mod + dp[i-2])%mod;
        }
        return dp[n];
    }

    static long OS(int n)
    {
        long first = 0;
        long second = 1;
        for(int i=3;i<=n;i++)
        {
            long temp = second;
            second= ((i-1) * (first % mod + second % mod))%mod;
            first = temp;
        }
        return second;
    }

    public static long countDerangements(int n) {
// 		return solveRec(n);
//         long [] dp = new long[n+1];
//         Arrays.fill(dp,-1);
//         return solveMem(n,dp);
//        return solveTab(n);
        System.out.println(solveTab(n));
        return OS(n);
    }
}

public class Count_Deragements {

    public static void main(String[] args) {

        System.out.println(Solution1.countDerangements(50));

    }
}
