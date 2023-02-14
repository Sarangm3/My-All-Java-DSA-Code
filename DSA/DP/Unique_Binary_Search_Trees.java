package DSA.DP;
class Solution16 {
    int solveRec(int n){
        if(n==0||n==1)
            return 1;
        int ans=0;

        for(int i=1;i<=n;i++){
            int left  = solveRec(i-1);
            int right = solveRec(n-i);
            ans+=left*right;
        }
        return ans;
    }
    int solveMem(int n,int []dp){
        if(n==0||n==1)
            return 1;

        if(dp[n]!=-1)
            return dp[n];

        int ans=0;
        for(int i=1;i<=n;i++){
            int left  = solveMem(i-1,dp);
            int right = solveMem(n-i,dp);
            ans+=left*right;
        }
        return dp[n]=ans;
    }
    int solveTab(int n){
        int [] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int ans=0;
            for(int j=1;j<=i;j++){
                ans+=dp[j-1]*dp[i-j];
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public int numTrees(int n) {
        // return solveRec(n);
        // int [] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return solveMem(n,dp);
        return solveTab(n);
    }
}
public class Unique_Binary_Search_Trees {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        System.out.println(s.numTrees(3));
    }
}
