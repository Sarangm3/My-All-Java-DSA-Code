package DSA.DP;

import java.util.Arrays;

class Solution6 {

    int solveRec(int [] sat, int index, int time){
        if(index==sat.length)
            return 0;
        int incl = sat[index]* (time+1) + solveRec(sat,index+1,time+1);
        int excl = 0 + solveRec(sat,index+1,time);

        return Math.max(incl,excl);
    }

    int solveMem(int [] sat, int index, int time,int[][]dp){
        if(index==sat.length)
            return 0;
        if(dp[index][time]!=-1)
            return dp[index][time];

        int incl = sat[index]* (time+1) + solveMem(sat,index+1,time+1,dp);
        int excl = 0 + solveMem(sat,index+1,time,dp);

        return dp[index][time]=Math.max(incl,excl);
    }

    int solveTab(int [] sat)
    {
        int [][] dp = new int[sat.length+1][sat.length+1];

        for(int index = sat.length-1;index>=0;index--)
        {
            for(int time = sat.length-1;time>=0;time--)
            {
                int incl = sat[index]* (time+1) + dp[index+1][time+1];
                int excl = 0 + dp[index+1][time];

                dp[index][time]=Math.max(incl,excl);
            }
        }
        return dp[0][0];
    }

    int optimized(int [] sat)
    {
        int [] next = new int[sat.length+1];
        int [] curr = new int[sat.length+1];

        for(int index = sat.length-1;index>=0;index--)
        {
            for(int time = sat.length-1;time>=0;time--)
            {
                int incl = sat[index]* (time+1) + next[time+1];
                int excl = 0 + next[time];

                curr[time]=Math.max(incl,excl);
            }
            next = Arrays.copyOf(curr,curr.length);
        }
        return next[0];
    }

    int optimized1(int [] sat)
    {
        int [] curr = new int[sat.length+1];

        for(int index = sat.length-1;index>=0;index--)
        {
            for(int time = 0 ;time<=sat.length-1;time++)
            {
                int incl = sat[index]* (time+1) + curr[time+1];
                int excl = 0 + curr[time];

                curr[time]=Math.max(incl,excl);
            }

        }
        return curr[0];
    }



    //greedy solution is answer


    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // return solveRec(satisfaction,0,0);
        // int [][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        // for(int i=0 ; i <= satisfaction.length; i++)
        //     Arrays.fill(dp[i],-1);
        // return solveMem(satisfaction,0,0,dp);
//         return solveTab(satisfaction);
//        return optimized(satisfaction);
        return optimized1(satisfaction);
    }
}

public class Reducing_Dishes {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.maxSatisfaction(new int []{-1,-8,0,5,-7}));
    }
}
