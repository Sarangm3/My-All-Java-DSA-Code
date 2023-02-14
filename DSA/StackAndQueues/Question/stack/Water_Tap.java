package DSA.StackAndQueues.Question.stack;

import java.util.Stack;

public class Water_Tap {
    static int trap(int[] que) {
        int [] left = leftHighest(que);
        int [] right = rightHighest(que);
        int ans = 0;
        for(int i=0;i<que.length;i++)
        {
            if(left[i]==-1||right[i]==-1)
            {
                continue;
            }
            ans+=Math.min(left[i],right[i]) - que[i];
        }
        return ans;
    }
    static int [] leftHighest(int []que)
    {
        int max = que[0];
        int [] ans = new int[que.length];
        for(int i=0;i<que.length;i++)
        {
            if(que[i]>=max)
            {
                max = que[i];
                ans[i] =-1;
            }
            else{
                ans[i]=max;
            }
        }
        return ans;
    }
    static int [] rightHighest(int []que)
    {
        int max = que[que.length-1];
        int [] ans = new int[que.length];
        for(int i=que.length-1;i>=0;i--)
        {
            if(que[i]>=max)
            {
                max = que[i];
                ans[i] =-1;
            }
            else{
                ans[i]=max;
            }
        }
        return ans;
    }
    static int maxWater(int[] height)
    {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty())
                    && (height[stack.peek()] < height[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {

        int [] que = {5,0,2,0,3};
        int ans1 = trap(que);
        System.out.println(ans1);
        ans1 = maxWater(que);
        System.out.println(ans1);
    }
}
