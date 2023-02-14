package DSA.DP;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int c=1; c<=2; c++){
                    if(buy == 1){
                        curr[buy][c] = Math.max(-prices[i] + after[0][c], after[1][c]);    // This approach requires O(1) space because we identified that the current state only depends on previous state so its not necessary to store whole 3D array
                        // We only require two 2x3 matrix to store these states
                    }
                    else{
                        curr[buy][c] = Math.max(prices[i] + after[1][c-1], after[0][c]);
                    }
                }
            }
            after = curr;
        }
        return curr[1][2];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
//        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
//        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
