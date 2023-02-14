package DSA.Sorting;
//cycle sort is only use went number is between 1->n in n size of array
//we can make number of question like cycle sort using 1->n in n size of array
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Quetion
class Solution1  {
    void swip(int [] array,int a, int b)    {
        array[a]=array[a]^array[b];
        array[b]=array[a]^array[b];
        array[a]=array[a]^array[b];
    }
    //m//////////////////
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length)
        {
            int currect = nums[i]-1; //number's currect possition
            if(currect>=0 && currect <nums.length && nums[i]!=nums[currect])
            {
                swip(nums,i,currect);
            }
            else i++;
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]-1!=i)
            {
                return i+1;
            }
        }
        return nums.length+1;
    }
    //m/////////////////
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int i =0;
        while(i<nums.length)
        {
            if (nums[i]!=nums[nums[i]-1])
            {
                swip(nums,i,nums[i]-1);
            }
            else{
                i++;
            }
        }
        for (i=0 ; i<nums.length;i++)
        {
            if (nums[i]-1!=i)
            {
                list.add(nums[i]);
            }
        }
        return list;

    }
    //m///////////////
    public int findDuplicate(int[] nums) {
        int i=0;
        int list=0;

        while(i<nums.length)
        {
            if(nums[i]!=i+1){
                if (nums[i]!=nums[nums[i]-1])
                {
                    swip(nums,i,nums[i]-1);
                }
                else return nums[i];
            }
            else{
                i++;
            }
        }
        //also you can use for loop
        return 0;
    }
    //m////////////////
    public int[] findErrorNums(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index=0;
        int i =0;
        while(i<nums.length)
        {
             if (nums[i]!=nums[nums[i]-1])
             {
                  swip(nums,i,nums[i]-1);
             }
             else{
                  i++;
            }
            }
        for (i=0 ; i<nums.length;i++)
        {
             if (nums[i]-1!=i)
             {
                  return new int [] {nums[i],i+1};
             }
        }
        return new int []{0,0};
          /////some some space complexity/////
//            for (i=0 ; i<nums.length;i++)
//            {
//                if (nums[i]-1!=i)
//                {
//                    list.add(nums[i]);
//                    list.add(i+1);
//                }
//            }
//            int [] ans = new int[list.size()];
//            for(i=0;i<list.size();i++)
//            {
//                ans[i]=list.get(i);
//            }
//            return ans;

    }
    //m///////////////
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        List<Integer> list = new ArrayList<>();

        while(i<nums.length)
        {
            int currect = nums[i]-1;
            if (nums[i]!=nums[currect])
            {
                swip(nums,i,currect);
            }
            else{
                i++;
            }
        }
        for (i=0 ; i<nums.length;i++)
        {
            if (nums[i]-1!=i)
            {
                list.add(i+1);
            }
        }
        return list;
    }
    public int missingNumber(int [] nums) {
        //not range is [0,n]
        int i=0;
        while(i<nums.length)
        {
            if( nums[i]!=nums.length && nums[i]!=nums[nums[i]] )
            {
                swip(nums,i,nums[i]);
            }
            else i++;
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=i)
            {
                return i;
            }
        }
        return nums.length;
    }
}
//basic
class cycle_sort {
    int [] array;
    static void print_array(int [] array)
    {
        System.out.println(Arrays.toString(array));
    }
    void swipe(int [] array,int a,int b)    {
        array[a]=array[a]^array[b];
        array[b]=array[a]^array[b];
        array[a]=array[a]^array[b];
    }
    void cyclesort(int [] array)    {
        int i=0;
        while(i<array.length)
        {
            int currect = array[i]-1; //currect index
            if (array[i]!=array[currect])
            {
                swipe(array,i,currect);
            }
            else
            {
                i++;
            }
        }
    }
}

public class CycleSort {
    public static void main(String[] args) {

        int [] array = {5,3,4,2,1};
        cycle_sort s = new cycle_sort();

        // sort
        s.print_array(array);
        s.cyclesort(array);
        s.print_array(array);

        int [] array1 = {7,4,4,2,1,3,6};
        Solution1 cs = new Solution1();
//        int [] array1 = {9,6,4,2,3,5,7,0,1};
//        System.out.println(cs.missingNumber(array1));
//        System.out.println(cs.findDisappearedNumbers(array1));
//        System.out.println(cs.findDuplicate(array1));
//        System.out.println(cs.findDuplicates(array1));
        int [] nums = {3,4,-1,1};
        System.out.println(cs.firstMissingPositive(nums));

    }
}
