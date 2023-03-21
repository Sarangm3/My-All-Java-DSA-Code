package DSA.SlidingWindow.VarSize;


//this answer for only +ve
//for handle +ve and -ve then we can do in O(n) and O(n) useing
//hashmap this may be the coolest way to use hashmap I like it.
public class Longest_Sub_Array_with_Sum_K {
    static int lenOfLongSubarr (int A[], int N, int K) {
        int sum = 0;
        int right = 0;
        int left = 0;
        int maxi = 0;
        while(right<A.length){
            sum += A[right];
            //after while loop may be got answer
            while(sum>K){
                sum -= A[left];
                left++;
            }
            //check for answer
            if(sum==K){
                maxi = Math.max(maxi,right-left+1);
            }
            right++;
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{1,1,4},3,5));
    }
}
