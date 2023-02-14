package DSA.DP;

import java.util.Arrays;

class Solution21 {
    int solveRec(String s1,String s2,int i,int j){
        if(i==s1.length()||j==s2.length()) return 0;
        if(s1.charAt(i)==s2.charAt(j)) return 1+solveRec(s1,s2,i+1,j+1);
        else{
            return Math.max(solveRec(s1,s2,i+1,j),solveRec(s1,s2,i,j+1));
        }
    }
    int solveMem(String s1,String s2,int i,int j,int [][] dp){
        if(i==s1.length()||j==s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1+solveMem(s1,s2,i+1,j+1,dp);
        else{
            return dp[i][j]=Math.max(solveMem(s1,s2,i+1,j,dp),solveMem(s1,s2,i,j+1,dp));
        }
    }
    int solveTab(String s1,String s2){

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){

                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j]=1+dp[i+1][j+1];
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    int solveOpt(String s1,String s2) {

        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j))
                    curr[j] = 1 + prev[j + 1];
                else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }
            prev = Arrays.copyOf(curr, m + 1);
        }
        return prev[0];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // return solveRec(text1,text2,0,0);
        // int n = text1.length();
        // int m = text2.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        // return solveMem(text1,text2,0,0,dp);
        // return solveTab(text1,text2);
        return solveOpt(text1,text2);
    }
}

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        System.out.println(s.longestCommonSubsequence("abc","aecb"));
        int [] a = {1,2,4};
        System.out.println(Arrays.copyOf(a,2));
    }
}
