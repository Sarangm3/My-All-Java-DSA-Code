package DSA.StackAndQueues.Question.stack;

import java.util.Stack;

public class Largest_Rectangle_Area_In_Hisrogram {

    //O(n^2) and O(1)
    static int largestRectangleArea(int [] array){ //brut force
        //we take all number(colmn) take right and left pointer check for big column then
        //till column gone small then current column
        int ans = array[0] ;
        for (int i = 0; i < array.length; i++) {
            int left = i;
            int right = i;

            while(left>=0 && array[left]>=array[i])
            {
                left--;
            }
            while(right< array.length && array[right]>=array[i])
            {
                right++;
            }
            int area = (right-left-1)*array[i];
            if(ans<area) {
                ans = area;
            }
        }
        return ans;
    }
    //O(n) and O(n)
    static int largestRectangleAreaOpt(int [] array)
    {
        int [] prev = prevSmallersIndex(array);
        int [] next = nextSmallerIndex(array);
        int ans = array[0];
        for (int i = 0; i < array.length; i++) {
            int area = (next[i]-prev[i]-1) * array[i];
            if(ans<area)
            {
                ans = area;
            }
        }
        return ans;
    }
    static int [] prevSmallersIndex(int [] arr){
        Stack<Integer> stack =new Stack<>();
        int [] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty()&&arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    static int [] nextSmallerIndex(int [] arr)
    {
        Stack<Integer> stack= new Stack<>();
        int [] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i]) // for next greater change in this and done
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans[i] = arr.length;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int array[] = {4,2,1,5,6,3,2,4,2};
//        int ans = largestRectangleArea(array);
        int ans = largestRectangleAreaOpt(array);
        System.out.println(ans);
    }
}
