package DSA.DP;

class Solution17 {
    int solveRec(int start,int end)
    {
        if(end<=1||start>=end)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i =start ; i<= end;i++)
        {
            ans=Math.min(ans,i + Math.max(solveRec(start,i-1),solveRec(i+1,end)));
        }
        return ans;
    }
    int solveMem(int start,int end,int[][]dp)
    {
        if(end<=1||start>=end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];

        int ans = Integer.MAX_VALUE;
        for(int i =start ; i<= end;i++)
        {
            ans=Math.min(ans,i + Math.max(solveMem(start,i-1,dp),solveMem(i+1,end,dp)));
        }
        return dp[start][end] = ans;
    }
    int solveTab(int n){
        int [][] dp = new int[n+1][n+1];

        //we can easily see start and end two varibale in question
        //start gose 1 to n in tab n to 1
        //and end n to 1 so in tab 1 to n
        //but end always greater then start according  to base condition

        for(int start=n;start>=1;start--){
            for(int end = start+1; end<=n;end++){

                int ans = Integer.MAX_VALUE;
                for(int i =start ; i<= end;i++)
                {
                    if(i+1<=n)
                        ans=Math.min(ans,i + Math.max(dp[start][i-1],dp[i+1][end]));
                }
                dp[start][end] = ans;
            }
        }
        return dp[1][n];
    }

    //space optimization not possible

    public int getMoneyAmount(int n) {
        // return solveRec(1,n);
        // int [][] dp = new int[n+1][n+1];
        // for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        // return solveMem(1,n,dp);
        return solveTab(n);
    }
}

public class Guess_Number_Higher_or_Lower_II {
    public static void main(String[] args) {
        Solution17 s  =new Solution17();
        System.out.println(s.getMoneyAmount(10));
    }
}
