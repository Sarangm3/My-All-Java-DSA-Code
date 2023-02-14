package DSA.DP;

import java.util.HashMap;

class Element{
    int value;
    int d;
    Element(int value,int d){
        this.value = value ; this.d = d;
    }
}
class Solution14 {
    int solveRec(int [] nums,int diff,int index,HashMap<Integer,Integer> [] dp){
        if(index<0)
            return 0;
        if(dp[index].containsKey(diff))
            return dp[index].get(diff);
        int ans =0;
        for(int i=index;i>=0;i--) {
            if(nums[index+1]-nums[i]==diff)
                ans = Math.max(ans,1+solveRec(nums,diff,i-1,dp));
        }
        dp[index].put(diff,ans);
        return ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n<=2)
            return n;
        HashMap<Integer,Integer> [] dp = new HashMap[n+1];
        for(int i =0;i<=n;i++) dp[i] = new HashMap<>();
        int ans = 0;
        // for(int i = 0; i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //             ans = Math.max(ans,2+solveRec(nums,nums[j]-nums[i],i-1,dp));
        //     }
        // }
        for(int i = 1; i<n;i++){
            for(int j=0;j<i;j++){
                int diff = nums[i]-nums[j];
                int cnt = 1;//for i
                if(dp[j].containsKey(diff))
                    cnt = dp[j].get(diff);
                dp[i].put(diff,1+cnt);

                ans = Math.max(ans,dp[i].get(diff));
            }
        }
        return ans;
    }
}
public class Longest_Arithmetic_Subsequence {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        System.out.println(s.longestArithSeqLength(new int[]{24,13,1,100,0,94,3,0,3}));
    }
}
