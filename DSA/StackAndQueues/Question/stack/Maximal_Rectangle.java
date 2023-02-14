package DSA.StackAndQueues.Question.stack;

import java.util.Stack;

//or max sub_matrix or this question have various other name
public class Maximal_Rectangle {
    static int largestRectangleArea(int [] array)
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
    static int sub_matrixArea(int [][] array){
        int [] curr = array[0];
        int ans = largestRectangleArea(curr);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]==1)
                {
                    curr[j] +=1;
                }
                else{//for if 0
                    curr[j] = 0;
                }
                int currans = largestRectangleArea(curr);
                ans  = Math.max(currans,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int [][] matrix = {
                {1,1,0,1,1},
                {1,1,1,1,1},
                {0,1,1,1,1},
                {1,1,1,1,1},
                {1,0,1,1,1},
                {1,1,1,1,1}
        };
        System.out.println(sub_matrixArea(matrix));
    }
}
