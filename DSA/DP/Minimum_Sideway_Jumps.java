package DSA.DP;

class Solution5 {

    int solveRec(int [] obs, int lane,int pos)
    {
        if(obs.length-1==pos)
            return 0;
        if(obs[pos+1]!=lane)
            return solveRec(obs, lane, pos+1);
        else {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (i != lane && i != obs[pos]) {
                    ans = Math.min(ans, 1 + solveRec(obs, i, pos));
                }
            }
            return ans;
        }
    }
    int solveMem(int [] obs, int lane,int pos,int [][] dp)
    {
        if(obs.length-1==pos)
            return 0;
        if(dp[lane][pos]!=-1)
            return dp[lane][pos];

        if(obs[pos+1]!=lane)
            return solveMem(obs,lane,pos+1  ,dp);

        int ans = Integer.MAX_VALUE;
        for(int i=1 ; i<= 3;i++)
        {
            if(i != lane && i != obs[pos])
            {
                ans = Math.min(ans,1+solveMem(obs,i,pos,dp));
            }
        }
        return dp[lane][pos]=ans;
    }

    int solveTab(int [] obs)
    {
        int [][] dp = new int [4][obs.length];

        for(int pos=obs.length-2;pos>=0;pos--)
        {
            for(int lane=3;lane>0;lane--)
            {
                if(obs[pos+1]!=lane)
                    dp[lane][pos] = dp[lane][pos+1];
                else{
                    int ans = Integer.MAX_VALUE;
                    for(int k=1 ; k<= 3;k++)
                    {
                        if(k != lane && k != obs[pos])
                        {
                            ans = Math.min(ans,1+dp[k][pos+1]);
                        }
                    }
                    dp[lane][pos]=ans;
                }
            }
        }

        return Math.min(dp[2][0],Math.min(dp[1][0]+1,1+dp[3][0]));
    }

    public int minSideJumps(int[] obstacles) {
        // return solveRec(obstacles,2,0);
        // int [][] dp = new int [4][obstacles.length];
        // for(int i=0;i<4;i++)
        //     Arrays.fill(dp[i],-1);
        // return solveMem(obstacles,2,0,dp);
        return solveTab(obstacles);
    }
}

public class Minimum_Sideway_Jumps {
    public static void main(String[] args) {
        Solution5 s =new Solution5();
        System.out.println(s.minSideJumps(new int[]{0,1,2,3,0}));
    }
}
