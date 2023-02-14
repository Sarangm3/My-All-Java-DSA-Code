package DSA.DP;

import java.util.HashMap;

class Solution15 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int length = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i < arr.length;i++)
        {
            int diff = arr[i] - difference ;
            length = 1 ;
            if(hm.containsKey(diff))
                length+=hm.get(diff);
            hm.put(arr[i],length);
            ans = Math.max(ans,length);
        }
        return ans;
    }
}

public class Longest_Arithmetic_Subsequence_of_Given_Difference {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        System.out.println(s.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }
}
