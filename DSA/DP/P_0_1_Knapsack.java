package DSA.DP;

import java.util.Arrays;

class Solution8{
    static int solveRec(int[] weight, int[] value, int n, int index,int maxWeight)
    {
        if(index==0)
        {
            if(weight[0]<=maxWeight)
                return value[0];
            return 0;
        }
        int include=0;
        if(weight[index]<=maxWeight)
            include = value[index] + solveRec(weight,value,n,index-1,maxWeight-weight[index]);

        int exclude = 0 + solveRec(weight,value,n,index-1,maxWeight);

        return Math.max(include,exclude);
    }

    static int solveMem(int[] weight, int[] value, int n, int index,int maxWeight,int[][]dp)
    {
        if(index==0)
        {
            if(weight[0]<=maxWeight)
                return value[0];
            return 0;
        }
        if(dp[index][maxWeight]!=-1)
            return dp[index][maxWeight];

        int include=0;
        if(weight[index]<=maxWeight)
            include = value[index] + solveMem(weight,value,n,index-1,maxWeight-weight[index],dp);

        int exclude = 0 + solveMem(weight,value,n,index-1,maxWeight,dp);

        return dp[index][maxWeight]=Math.max(include,exclude);
    }

    static int solveTab(int[] weight, int[] value, int n,int maxWeight){
        int[][]dp = new int[n][maxWeight+1];

        //base case
        for(int w = weight[0] ;w<=maxWeight;w++)
        {
            if(maxWeight>=weight[0])
                dp[0][w] = value[0];
            else
                dp[0][w] = 0;
        }

        for(int index=1;index<n;index++){
            for(int w = 0 ; w<=maxWeight;w++){
                int include=0;
                if(weight[index]<=w)
                    include = value[index] + dp[index-1][w-weight[index]];

                int exclude = 0 + dp[index-1][w];

                dp[index][w]=Math.max(include,exclude);
            }
        }
        return dp[n-1][maxWeight];
    }
    static int optimize(int[] weight, int[] value, int n,int maxWeight){

        int []next = new int[maxWeight+1];
        int []curr = new int[maxWeight+1];

        //base case
        for(int w = weight[0] ;w<=maxWeight;w++)
        {
            if(maxWeight>=weight[0])
                next[w] = value[0];
            else
                next[w] = 0;
        }
        for(int index=1;index<n;index++){
            for(int w = 0 ; w<=maxWeight;w++){
                int include=0;
                if(weight[index]<=w)
                    include = value[index] + next[w-weight[index]];

                int exclude = 0 + next[w];

                curr[w]=Math.max(include,exclude);
            }
            next = Arrays.copyOf(curr,curr.length);
        }
        return next[maxWeight];
    }
    static int optimize1(int[] weight, int[] value, int n,int maxWeight){

        int []curr = new int[maxWeight+1];

        //base case
        for(int w = weight[0] ;w<=maxWeight;w++)
        {
            if(maxWeight>=weight[0])
                curr[w] = value[0];
            else
                curr[w] = 0;
        }
        for(int index=1;index<n;index++){
            for(int w = maxWeight ; w>=0;w--){
                int include=0;
                if(weight[index]<=w)
                    include = value[index] + curr[w-weight[index]];

                int exclude = 0 + curr[w];

                curr[w]=Math.max(include,exclude);
            }
        }
        return curr[maxWeight];
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//            return solveRec(weight,value,n,n-1,maxWeight);
//         int [][] dp = new int[n+1][maxWeight+1];
//         for(int i=0;i<n+1;i++)
//             Arrays.fill(dp[i],-1);
//         return solveMem(weight,value,n,n-1,maxWeight,dp);
//        return solveTab(weight,value,n,maxWeight);
//        return optimize(weight,value,n,maxWeight);
        return optimize1(weight,value,n,maxWeight);
    }
}

public class P_0_1_Knapsack {
    public static void main(String[] args) {
        System.out.println(Solution8.knapsack(new int[]{1,5,6,9,7,9,7},new int[]{1,7,1,5,1,7,7},7,37));
        }
}
