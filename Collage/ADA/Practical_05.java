package Collage.ADA;

import java.util.Arrays;

public class Practical_05 {
    static int matMul(int [] arr,int start,int end,int [][]dp){
        if(start==end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        dp[start][end] = 10000000;
        for(int k=start;k<end;k++){

            dp[start][end] = Math.min(dp[start][end],matMul(arr,start,k,dp) + matMul(arr,k+1,end,dp) + arr[k]*arr[start-1]*arr[end]);

        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        int [] arr = {40, 20, 30, 10, 30};
        int dp[][]=new int[100][100];
        for(int i=0;i<100;i++) Arrays.fill(dp[i],-1);
        System.out.println(matMul(arr,1,arr.length-1,dp));
    }

}

