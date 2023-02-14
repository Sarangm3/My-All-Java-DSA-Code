package DSA.DP;

class Solution20 {
    int solveRec(int k,int index,int buy,int [] prices){
        if(k==0) return 0;
        if(index==-1) return 0;

        int profite=0,incl =0,excl = 0;
        if(buy == 1){
            incl = solveRec(k,index-1,0,prices);
            excl = solveRec(k,index-1,1,prices);
            profite = Math.max(prices[index]+incl , excl);
        }

        else{
            incl = solveRec(k-1,index-1,1,prices);
            excl = solveRec(k,index-1,0,prices);
            profite = Math.max(-prices[index]+incl , excl);
        }
        return profite;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return solveRec(k,n-1,1,prices);
    }
}
public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.maxProfit(2,new int[]{2,4,1}));

    }
}
