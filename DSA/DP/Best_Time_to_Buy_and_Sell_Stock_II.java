package DSA.DP;

class Solution19 {
    int solveRec(int []prices,int index,boolean buy){
        if(index==prices.length) return 0;
        int incl,excl = 0;
        int profite = 0;
        if(buy==false){
            //buy or ignore
            incl = solveRec(prices,index+1,true);
            excl = solveRec(prices,index+1,false);
            profite = Math.max(-prices[index]+incl,excl);
        }
        else{
            //sell or ignore
            incl = solveRec(prices,index+1,false);
            excl = solveRec(prices,index+1,true);
            profite = Math.max(prices[index]+incl,excl);
        }
        return profite;
    }
    int solveMem(int []prices,int index,int buy,int [][]dp){
        if(index==prices.length) return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        int incl,excl = 0;
        int profite = 0;

        if(buy==0){
            //buy or ignore
            incl = solveMem(prices,index+1,1,dp);
            excl = solveMem(prices,index+1,0,dp);
            profite = Math.max(-prices[index]+incl,excl);
        }
        else{
            //sell or ignore
            incl = solveMem(prices,index+1,0,dp);
            excl = solveMem(prices,index+1,1,dp);
            profite = Math.max(prices[index]+incl,excl);
        }
        return dp[index][buy]=profite;
    }

    int solveTab(int[]prices){
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        for(int index=n-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){

                int incl,excl = 0;
                int profite = 0;

                if(buy==0){
                    //buy or ignore
                    incl = dp[index+1][1];
                    excl = dp[index+1][0];
                    profite = Math.max(-prices[index]+incl,excl);
                }
                else{
                    //sell or ignore
                    incl = dp[index+1][0];
                    excl = dp[index+1][1];
                    profite = Math.max(prices[index]+incl,excl);
                }
                dp[index][buy]=profite;
            }
        }
        return dp[0][0];
    }

    int solveOpt(int [] prices){
        int n = prices.length;
        int prev_incl=0,prev_excl=0,curr_incl=0,curr_excl=0;

        for(int index=n-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){

                int incl,excl = 0;
                int profite = 0;

                if(buy==0){
                    //buy or ignore
                    incl = prev_incl;
                    excl = prev_excl;
                    profite = Math.max(-prices[index]+incl,excl);
                    curr_excl = profite;
                }
                else{
                    //sell or ignore
                    incl = prev_excl;
                    excl = prev_incl;
                    profite = Math.max(prices[index]+incl,excl);
                    curr_incl = profite;
                }
            }
            prev_incl = curr_incl;
            prev_excl = curr_excl;
        }
        return prev_excl;
    }
    public int maxProfit(int[] prices) {
        // return solveRec(prices,0,false);
        // int n = prices.length;
        // int [][] dp =new int[n+1][2];
        // for(int i =0;i<=n;i++) Arrays.fill(dp[i],-1);
        // return solveMem(prices,0,0,dp);
//         return solveTab(prices);
        return solveOpt(prices);
    }
}

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        Solution19 s = new Solution19();
        System.out.println(s.maxProfit(new int []{7,1,5,3,6,4}));
    }
}
