package DSA.DP;
class Solution13 {
    void swap(int [] nums1,int [] nums2,int i){
        int temp = nums1[i];
        nums1[i] = nums2[i];
        nums2[i] = temp;
    }
    int solveRec(int [] nums1,int [] nums2,int index){

        if(index==nums1.length)
            return 0;
        int prev1=-1;
        int prev2=-1;
        if(index!=0){
            prev1 = nums1[index-1];
            prev2 = nums2[index-1];
        }
        int ans = 0;
        if(nums1[index] > prev1 && nums2[index]>prev2)
            ans = solveRec(nums1,nums2,index+1);
        else{
            swap(nums1,nums2,index);
                ans = 1+ solveRec(nums1,nums2,index+1);
        }
        return ans;
    }
    public int minSwap(int[] nums1, int[] nums2) {
        return solveRec(nums1,nums2,0);
    }
}
public class Minimum_Swap_To_Make_Sequences_Increasing {
    public static void main(String[] args) {
        Solution13 s =new Solution13();
        System.out.println(s.minSwap(new int[]{0,1,8,9,10},new int[]{0,5,5,8,9}));
    }
}
