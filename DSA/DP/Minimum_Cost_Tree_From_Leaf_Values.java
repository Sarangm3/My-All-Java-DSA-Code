package DSA.DP;

class Solution18 {
    int maxLeafNode(int [] arr,int start,int end){
        if(end==0||start==end)
            return arr[end];
        int maxi = arr[start];

        for(int i=start;i<=end;i++){
            if(arr[i]>maxi)maxi = arr[i];
        }
        return maxi;
    }
    int solveRec(int[]arr,int start,int end){
        if(end==0||start==end)
            return 0;
        int ans = Integer.MAX_VALUE;
        int maxi = 0;
        for(int i=start;i<end;i++)
        {   maxi = maxLeafNode(arr,start,i)*maxLeafNode(arr,i+1,end);
            ans = Math.min(ans,maxi+solveRec(arr,start,i)+solveRec(arr,i+1,end));
        }
        return ans;
    }
    int solveMem(int[]arr,int start,int end,int[][]dp){
        if(end==0||start==end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        int ans = Integer.MAX_VALUE;
        int maxi = 0;
        for(int i=start;i<end;i++)
        {   maxi = maxLeafNode(arr,start,i)*maxLeafNode(arr,i+1,end);
            ans = Math.min(ans,maxi+solveRec(arr,start,i)+solveRec(arr,i+1,end));
        }
        return dp[start][end]=ans;
    }
    int solveTab(int[]arr){
        int n = arr.length;
        int [][]dp = new int[n+1][n+1];
        for(int start=n-1;start>=0;start--){
            for(int end = start+1;end<=n-1;end++){
                int ans = Integer.MAX_VALUE;
                int maxi = 0;
                for(int i=start;i<end;i++)
                {   maxi = maxLeafNode(arr,start,i)*maxLeafNode(arr,i+1,end);
                    ans = Math.min(ans,maxi+dp[start][i]+dp[i+1][end]);
                }
                dp[start][end]=ans;
            }
        }
        return dp[0][n-1];
    }
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        // return solveRec(arr,0,n-1);
        // int [][] dp = new int[n+1][n+1];
        // for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        // return solveMem(arr,0,n-1,dp);
        return solveTab(arr);
    }
}

public class Minimum_Cost_Tree_From_Leaf_Values {
    public static void main(String[] args) {
        Solution18 s = new Solution18();
        System.out.println(s.mctFromLeafValues(new int[]{6,2,4}));
    }
}
