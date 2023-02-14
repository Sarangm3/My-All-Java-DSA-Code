package DSA.Two_pointer;
import java.util.*;
//two pointer or two sum is main
//then 3 sum after 4sum

class Solution {
    //first solution using tree for loop
    //first we sort array so that if duplicate element arrive set remove them
    //you can sort all array or only tree tuple(increase time complexity of solution) as your wish
    //time complexity of solution is O(n^3) and space complexity(A.S.C) of k - number of tuple
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> ans= new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum==0)
                    {
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                        ans.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
    List<List<Integer>> threeSum2(int [] nums){
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            //or use can use hashset also
            for (int j = i+1; j < n; j++) {
                int newTarget = -(nums[i]+nums[j]);
                //set.contains(newTarget) for set
                if(hm.containsKey(newTarget)){
                    //newTarget is always smaller than nums[j]
                    //because newTarget past element add in hash map
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],newTarget,nums[j])));
                }
                hm.put(nums[j],j);//because hash map only check for key so that this order
            }
        }
        return new ArrayList<>(ans);
    }
    List<List<Integer>> threeSum(int []nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            if(i==0 || nums[i-1] != nums[i]){
                int l = i+1;
                int h = n-1;
                while (l<h){
                    int sum = nums[i]+nums[l]+nums[h];
                    if(sum==0){
                        ans.add(Arrays.asList(nums[i],nums[l],nums[h]));
                        l++;
                        h--;
                        while(l<h && nums[l-1]==nums[l])l++;
                        while(l<h && nums[h]==nums[h+1])h--;
                    }
                    else if(sum<0){
                        l++;
                    }
                    else {
                        h--;
                    }
                }
            }
        }
        return ans;
    }

}
public class sum_of_3_element {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum1(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(s.threeSum2(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
