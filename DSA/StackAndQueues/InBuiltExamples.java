package DSA.StackAndQueues;


import java.util.*;
class Node{
    int value;

    public Node(int value) {
        this.value = value;
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
//        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                stack.push(s.charAt(i));
            }
            else {
                if(!(stack.isEmpty()) && helper(stack.peek())==s.charAt(i))
                {
                    stack.pop();
//                    count++;
                }
                else{
                    return false;
                }
            }

        }
//        if(count==0)
//        {
//            return false;
//        }
        return true;
    }
    private char helper(char ch)
    {
        if(ch=='[')
        {
            return ']';
        }
        if(ch=='{')
        {
            return '}';
        }
        if(ch=='(')
        {
            return ')';
        }
        return '.';
    }
}
public class InBuiltExamples {
    public static void main(String[]  rgs) {

        Solution s = new Solution();
        boolean ans = s.isValid(")]");
        System.out.println(ans);

        //
        Stack<Integer> stack = new Stack<>(); // In internal implementation its class extand vector class
        //and vector class have array
        //insert at last and pop at last
//         stack.add(2);
//         stack.add(4);
//         stack.add(6);
         stack.add(8);
         stack.push(8);//same use push to more understandable
         stack.pop();
        System.out.println(stack.isEmpty());

//
//        System.out.println(stack.pop());
//        stack.pop();
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        //
//        Queue<Integer> queue = new Queue<Integer>() not possible because Queue is interface
        //so we use LinkedList because LL implement deque and deque implement queue
        Queue<Integer> queue = new LinkedList<>();
        //insert at last(Tail) and remove remove from first(Head)
//        queue.add(3);
//        queue.add(6);
//        queue.add(9);
//        queue.add(12);
//        queue.add(15);
//
//        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.peek());

    //when do we use queue and stack?
        //binary tree
        //bsf and dsf
        //Dynamic programing
        //....

        Deque<Integer> deque = new ArrayDeque<>();//deque is interface
        //so we required class implement deque its name ArrayDeque and use some property of ArrayDeque
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(12);
        pq.add(13);
        pq.add(1);
        pq.add(16);
        pq.add(7);
        pq.add(23);
        pq.add(35);
        System.out.println(pq);
        pq1.add(23);
        pq1.add(2);
        pq1.add(3);
        pq1.add(13);
        pq1.add(43);
        pq1.add(26);
        pq1.add(28);
        pq1.add(23);
        pq1.add(23);
        pq1.add(90);
        pq1.add(100);
        pq1.add(123);
        pq1.add(243);
        pq1.add(2354);
        pq1.add(263);
        pq1.add(23);
        System.out.println(pq1);
        deque.add(34);
        deque.addFirst(43);
        deque.addLast(1);
        deque.removeFirst();
        System.out.println(deque.removeLast());
        //.....
    }
}
