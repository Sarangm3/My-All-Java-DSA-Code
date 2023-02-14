package DSA.DP;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int n= 3;
        HashMap<Integer,Integer>[] dp = new HashMap[n+1];
        for(int i =0;i<=n;i++) dp[i] = new HashMap<>();
//        dp[0].put(10,2);
//        dp[0].put(14,3);
//        dp[0].put(1045,4);
//        dp[0].put(12,5);
        if(dp[0].get(2)!=null)
            System.out.println(dp[0].get(2));

    }
}
