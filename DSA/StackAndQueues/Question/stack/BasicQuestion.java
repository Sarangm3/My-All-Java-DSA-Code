package DSA.StackAndQueues.Question.stack;

import java.util.Arrays;
import java.util.Stack;

class Solution{
    public int [] prevSmallers(int [] arr){  //prev big like vise small change and then done
        //complexcity O(n) O(n)
        //you can use Ofsf(n^2) two loop method
        Stack<Integer> stack =new Stack<>();
        int [] ans = new int[arr.length];
        //max to max loop run 2n time's so complexcity O(n)
        //2n for array like {4,5,6,7,8,3}
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty()&&stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
    public int [] printNextSmallers(int [] arr)
    {
        Stack<Integer> stack= new Stack<>();
        int [] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty()&& stack.peek()>arr[i]) // for next greater change in this and done
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}

public class BasicQuestion {
    public static void main(String[] args) {
        Solution s =new Solution();
        int [] arr = {3,10,5,1,15,10,7,6};
        System.out.println(Arrays.toString(s.prevSmallers(arr)));
        s.printNextSmallers(arr);
        System.out.println();
    }
}
