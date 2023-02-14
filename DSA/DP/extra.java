package DSA.DP;

public class extra {

    static int knapsack(int [] weight,int [] value,int n,int W){
//        int n = weight.length;
        int dp [][] = new int[n+1][W+1];

        for(int w = 0 ;w<=W; w++)
        {
            if(w>=weight[0])
                dp[0][w] = value[0];
            else
                dp[0][w] = 0;
        }

        for (int i = 1; i <= n-1; i++) {
            for (int w = 0; w <= W; w++) {
                int incl = 0;
                if(w-weight[i]>=0)
                    incl = value[i] + dp[i-1][w-weight[i]];
                int excl = dp[i-1][w];
                dp[i][w] = Math.max(incl,excl);
            }
        }
        return dp[n-1][W];
    }
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1,5,6,9,7,9,7},new int[]{1,7,1,5,1,7,7},7,37));
    }
}
