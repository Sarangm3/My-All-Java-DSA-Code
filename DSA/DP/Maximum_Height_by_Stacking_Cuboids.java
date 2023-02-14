package DSA.DP;

import java.util.*;

class Solution11 {

    public boolean check(int [] newBox , int [] base){
        if(base[0]>=newBox[0] && base[1]>=newBox[1] && base[2]>=newBox[2])
            return true;
        return false;
    }
    public int solveTab(int [][] nums)
    {
        int[][]dp = new int[nums.length+1][nums.length+1];

        for(int curr = nums.length-1 ; curr >= 0;curr--)
        {
            for(int prev = curr-1 ; prev >= -1 ;prev--)// prev alway less then curr we optimize solutoin
            {
                int include = 0;
                if( prev == -1 || check(nums[prev],nums[curr])){
                    include = nums[curr][2]  + dp[curr+1][curr+1];// we use [][curr+1] because show prev is col value +1
                }

                int exclude =0 + dp[curr+1][prev+1];

                dp[curr][prev+1] = Math.max(include,exclude);
            }
        }
        return dp[0][0];
    }
//    public int solveTab1(int [][] nums)
//    {
//        int [] prevRow = new int[nums.length+1];
//        int [] currRow = new int[nums.length+1];
//
//        for(int curr = nums.length-1 ; curr >= 0;curr--)
//        {
//            for(int prev = curr-1 ; prev >= -1 ;prev--)
//            {
//                int include = 0;
//                if( prev == -1 || check(nums[prev],nums[curr])){
//                    include =nums[curr][2] + prevRow[curr+1];
//                }
//
//                int exclude =0 + prevRow[prev+1];
//
//                currRow[prev+1] = Math.max(include,exclude);
//            }
//            prevRow = Arrays.copyOf(currRow,currRow.length);
//        }
//        return prevRow[0];
//    }

    public int maxHeight(int[][] cuboids) {

        for(int i= 0 ; i < cuboids.length; i++){
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        return solveTab(cuboids);
    }
}

public class Maximum_Height_by_Stacking_Cuboids {
    public static void main(String[] args) {
        Solution11 s= new Solution11();
        int [][] a  = {{50,45,20},{95,37,53},{45,23,12}};
        System.out.println(s.maxHeight(a));
    }
}
