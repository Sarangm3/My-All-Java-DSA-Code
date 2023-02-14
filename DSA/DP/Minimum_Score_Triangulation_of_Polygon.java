package DSA.DP;

import java.sql.SQLOutput;
import java.util.Arrays;

class Solution4 {
    int solveRec(int [] v,int i,int j){
        if(i+1==j)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            ans =Math.min(ans,(v[k]*v[i]*v[j]) + solveRec(v,i,k) + solveRec(v,k,j));
        }

        return ans;
    }
    int solveMem(int [] v,int i,int j,int [][] dp){
        if(i+1==j)
            return 0;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            ans =Math.min(ans,(v[k]*v[i]*v[j]) + solveRec(v,i,k) + solveRec(v,k,j));
        }
        return dp[i][j]=ans;
    }
    int solveTab(int [] v)
    {
        int [][] dp = new int[v.length][v.length];

        for (int i = v.length-1; i >=0; i--) {
            for (int j = i+2; j < v.length; j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    ans =Math.min(ans,(v[k]*v[i]*v[j]) + dp[i][k] + dp[k][j]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][v.length-1];
    }
    public int minScoreTriangulation(int[] values) {
//        return solveRec(values,0,values.length-1);
//        int [][] dp = new int[values.length][values.length];
//        for (int i = 0; i < values.length; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//        return solveMem(values,0,values.length-1,dp);
        return solveTab(values);
    }
}
public class Minimum_Score_Triangulation_of_Polygon {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        System.out.println(s.minScoreTriangulation(new int[]{3,7,4,5}));
    }
}
