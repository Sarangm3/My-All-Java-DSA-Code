package DSA.DP;

class Solution22 {

    int solveRec(String s1,String s2,int i,int j){
        if(s1.length()==i)
            return s2.length()-j;
        if(s2.length()==j)
            return s1.length()-i;

        int ans = 0;

        if(s1.charAt(i)==s2.charAt(j)) return solveRec(s1,s2,i+1,j+1);
        else{
            //replace
            int replace = 1+solveRec(s1,s2,i+1,j+1);
            //delete
            int delete =  1+solveRec(s1,s2,i+1,j);
            //insert
            int insert =  1+solveRec(s1,s2,i,j+1);

            ans = Math.min(replace,Math.min(delete,insert));
        }
        return ans;
    }

    public int minDistance(String word1, String word2) {
        return solveRec(word1,word2,0,0);
    }
}

public class Edit_Distance {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        System.out.println(s.minDistance("horse","ros"));
    }
}
