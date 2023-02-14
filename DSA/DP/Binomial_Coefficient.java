package DSA.DP;

import java.util.Arrays;

public class Binomial_Coefficient {
    static int solveRec(int n ,int k){
        //two variable check all case done base case
        if(k>n) return 0;
        if(k==n||k==0)return 1;
        return solveRec(n-1,k-1)+solveRec(n-1,k);
    }
    static int solveMem(int n ,int k,int [][] dp){
        //two variable check all case done base case
        if(k>n) return 0;
        if(k==n||k==0)return 1;
        if(dp[n][k]!=-1)return dp[n][k];
        return dp[n][k]=solveRec(n-1,k-1)+solveRec(n-1,k);
    }
    static int solveTab(int n,int k){
        int dp[][] = new int[n+1][k+1];
        //base case

        for (int ni = 0; ni <= n; ni++) {
            for (int ki = 0; ki <= k && ki <= ni; ki++) {
                if(ni==ki || ki==0) dp[ni][ki]= 1;
            }
        }
        //n was going to n----to 0
        //and k was going to k---to 0
        //we go bottom up
        for (int ni = 1; ni <= n; ni++) {
            for (int ki = 1; ki <= k && ki <= ni; ki++) {
                dp[ni][ki]=dp[ni-1][ki-1]+dp[ni-1][ki];
            }
        }

        return dp[n][k];
    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d, %d) is %d \n", n, k, solveRec(n, k));
        int dp[][] = new int[n+1][k+1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(dp[i],-1);
        }

        System.out.println(solveMem(n,k,dp));
        System.out.println(solveTab(n,k));
    }
}
