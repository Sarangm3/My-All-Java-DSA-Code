package DSA.Two_pointer;

import java.util.ArrayList;

class Solution1 {
    int margeSort(int [] nums,int s,int e){
        if(s==e) return 0;
        int mid = s + (e-s)/2;
        int ans = margeSort(nums,s,mid);
        ans += margeSort(nums,mid+1,e);
        ans += marge(nums,s,mid,e);
        return ans;
    }
    int marge(int [] nums,int s,int mid,int e){
        int i = s;
        int j = mid+1;
        int count = 0;
        for(;i<=mid;i++){
            int cnt=  0;
            while(j<=e && nums[i]>2* (long)nums[j]){
                j++;
            }
            cnt = j-(mid+1);
            count+=cnt;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        i=s;
        j=mid+1;
        while(i<=mid&&j<=e){
            if(nums[i]<nums[j]){
                ans.add(nums[i]);
                i++;
            }
            else{
                ans.add(nums[j]);j++;
            }
        }
        while(i<=mid) {
            ans.add(nums[i]);i++;
        }
        while(j<=e) {
            ans.add(nums[j]);j++;
        }
        for(i = s; i<=e;i++){
            nums[i] = ans.get(i-s);
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return margeSort(nums,0,nums.length-1);
    }
}

public class Reverse_Pairs {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.reversePairs(new int[]{40,25,19,12,9,6,2}));
    }
}
