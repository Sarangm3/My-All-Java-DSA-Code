package DSA.DP;

class Solution3 {
    public int solveRec(char[][] matrix,int i,int j,int [] ans)
    {
        if(i>=matrix.length || j>= matrix[0].length)
        {
            return 0;
        }

        int right = solveRec(matrix,i,j+1,ans);
        int diag = solveRec(matrix,i+1,j+1,ans);
        int down = solveRec(matrix,i+1,j,ans);

        if(matrix[i][j]=='1')
        {
            int maxi = 1 + Math.min(right,Math.min(diag,down));
            ans[0] = Math.max(maxi,ans[0]);
            return maxi;
        }
        else{
            return 0;
        }
    }

    public int solveMem(char[][] matrix,int i,int j,int [] ans,int [][] dp)
    {
        if(i>=matrix.length || j>= matrix[0].length)
        {
            return 0;
        }

        if(matrix[i][j]==-1)
        {
            return matrix[i][j];
        }
        int right = solveMem(matrix,i,j+1,ans,dp);
        int diag =  solveMem(matrix,i+1,j+1,ans,dp);
        int down =  solveMem(matrix,i+1,j,ans,dp);

        if(matrix[i][j]=='1')
        {
            int maxi = 1 + Math.min(right,Math.min(diag,down));
            ans[0] = Math.max(maxi,ans[0]);
            return dp[i][j]=maxi;
        }
        else{
            return dp[i][j]=0;
        }
    }
    public int solveTab(char[][] matrix,int [] ans)
    {
        int [][] dp = new int[(matrix.length)+1][(matrix[0].length)+1];

        for(int i=(matrix.length)-1;i>=0;i--){
            for(int j=(matrix[0].length)-1;j>=0;j--)
            {
                int right = dp[i][j+1];
                int diag =  dp[i+1][j+1];
                int down =  dp[i+1][j];

                if(matrix[i][j]=='1')
                {
                    int maxi = 1 + Math.min(right,Math.min(diag,down));
                    ans[0] = Math.max(maxi,ans[0]);
                    dp[i][j]=maxi;
                }
                else{
                    dp[i][j]=0;
                }
            }
        }

        return dp[0][0];
    }
    public int optimizedSolution(char[][] matrix,int [] ans)
    {
        //opt O(m*n) and O(1)
        return 0;
    }
    public int maximalSquare(char[][] matrix) {
        int [] ans = new int[1];
        // solveRec(matrix,0,0,ans);

        // int [][] dp = new int[matrix.length][matrix[0].length];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // solveMem(matrix,0,0,ans,dp);
        solveTab(matrix,ans);

        return (int)Math.pow(ans[0],2);
    }
}
public class Maximal_Square {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));

    }
}
