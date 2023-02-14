package DSA.DP;

class Solution7 {
    public int solveRec(int [] nums,int target,int value,int index)
    {
        if(index==nums.length)
        {
            if(target==value) return 1;
            return 0;
        }

        int nagative = solveRec(nums,target,value-nums[index],index+1);
        int positive = solveRec(nums,target,value+nums[index],index+1);

        return nagative+positive;
    }
    public int solveMem(int [] nums,int target,int value,int index,int [][] dp)
    {
        if(index==nums.length)
        {
            if(target==value) return dp[index][value]=1;
            return 0;
        }
        if(dp[index][value]!=-1)
            return dp[index][value];

        int nagative = solveRec(nums,target,value-nums[index],index+1);
        int positive = solveRec(nums,target,value+nums[index],index+1);

        return dp[index][value]=nagative+positive;
    }
//    int result = 0;
//    public int findTargetSumWays1(int[] nums, int S) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        dfs(nums, S, 0, 0);
//        return result;
//    }
//
//    public void dfs(int[] nums, int target, int calcVal, int pos) {
//        if (pos == nums.length) {
//            if (calcVal == target) {
//                result++;
//            }
//            return;
//        }
//        dfs(nums, target, calcVal + nums[pos], pos + 1);
//        dfs(nums, target, calcVal - nums[pos], pos + 1);
//    }

    public int findTargetSumWays(int[] nums, int target) {
        return solveRec(nums,target,0,0);
    }
}

public class Target_Sum {
    public static void main(String[] args) {
        Solution7 s =new Solution7();
        System.out.println(s.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
