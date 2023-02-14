package DSA.DP;

public class Wildcard_Matching {
    static boolean solveTab(String s, String p){
        int n = s.length();
        int m = p.length();
        boolean [][] dp = new boolean[n+1][m+1];

        dp[0][0]= true;
        //know we handle case where i==0
        for(int j=1;j<=m;j++){
            //what is j then , j is patter at
            //i length finish and know check remain length of pettern
            //we don't if i finsh at time where j was
            //so, done calcultion on all j valuse then there know problem
            boolean flag=true;
            for(int k = 1; k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    //don't ckeck ferther
                    flag=false;
                    break;
                }
            }
            dp[0][j]=flag;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                boolean ans = false;
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    ans =  dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    ans = ( dp[i-1][j] || dp[i][j-1]);
                }
                else
                    ans = false;
                dp[i][j] = ans;
            }
        }

        return  dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(solveTab("adceb","*a*b"));
    }
}
