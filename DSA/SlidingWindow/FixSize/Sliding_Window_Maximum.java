package DSA.SlidingWindow.FixSize;
import java.util.*;
public class Sliding_Window_Maximum {
    static int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans = new int[nums.length-k+1];
        int maxi = 0;
        //we use deque remove element from both side
        //so we store at max k element in queue
        //Intuition

        //if new element arrive(a[i]) al(old element) <= a[i]
        //new element is answer so remove all elemnt from deque
        //insort first element is answer of that sub part
        //we store element in decreseing order BY..

        //remove element we have two type of remove first if a[i] is bigger then last element
        //second first element of queue is outof sub part

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i =0;i < nums.length;i++){
            //we got answer start from k-1 index before
            //that we maintain dcreassing order in deque

            //Removeing
            if(!deque.isEmpty() && deque.getFirst()==i-k) deque.removeFirst();

            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }

            //after all removale add a[i]
            deque.addLast(i);
            if(i>=k-1){//our time complexity is O(n)
                ans[i-(k-1)] = nums[deque.getFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
