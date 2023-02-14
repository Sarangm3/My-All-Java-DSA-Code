package DSA.DP;
class Solution12 {
    int solveRec(int index, int end , int [] slices,int n){
        if(n==0 || index>end){
            return 0;
        }
        int incl = slices[index]+solveRec(index+2,end,slices,n-1);
        int excl = solveRec(index+1,end,slices,n);
        return Math.max(incl,excl);
    }
    int solveRec1(int index,int end , int [] slices){
        if(index>end)return 0;

        int incl = slices[index] + solveRec1(index+3,end,slices);
        int excl = 0+ solveRec1(index+1,end,slices);

        return Math.max(incl,excl);
    }
    public int maxSizeSlices(int[] slices) {
        int k = slices.length;
        int case1 = solveRec(0,k-1,slices,k/3);
        int case2 = solveRec(1,k-2,slices,k/3);

        return Math.max(case1,case2);
    }
}
public class House_Pizza_With_3n_Slices {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        int [] slices = {1,2,3,4,5,6};
        System.out.println(s.maxSizeSlices(slices));

    }
}
