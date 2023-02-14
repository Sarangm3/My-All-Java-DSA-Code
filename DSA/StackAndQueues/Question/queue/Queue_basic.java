package DSA.StackAndQueues.Question.queue;

import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val){
        this.val = val;
    }

};
class Solution {
    public Node flatten(Node head) {
        if(head.next==null || head==null)
        {
            return head;
        }

        Queue<Node> queue = new ArrayDeque<>();
        Node curr = head;
        while(curr!=null)
        {
            if(curr.next==null)
            {
                Node nextNode = queue.poll();
                curr.next = nextNode;
                nextNode.prev = curr;
            }
            if(curr.child!=null)
            {
                queue.add(curr.child);
            }
            curr = curr.next;
        }
        return head;
    }

    public Node flatten1(Node head) {
        if(head.next==null || head==null)
        {
            return head;
        }

        Node curr = head;
        Node tail = head;
        Node temp = null;
        while(tail.next !=null)
        {
            tail = tail.next;
        }

        while(curr!=tail)
        {
            if(curr.child!=null)
            {
                tail.next = curr.child;

                temp = curr.child;
                while(temp.next !=null)
                {
                    temp = temp.next;
                }

                tail = temp;
                tail.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
public class Queue_basic {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
