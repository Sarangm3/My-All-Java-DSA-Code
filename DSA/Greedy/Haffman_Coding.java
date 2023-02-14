package DSA.Greedy;

import java.util.*;
//there some problem with gfg compler not give right answers
class Node{
    int data;
    Node left;
    Node right;
    Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class HComparator implements Comparator<Node>{
    public int compare(Node o1 , Node o2)
    {
        return o1.data-o2.data; // o1 > o2
        //asc
    }
}
class Solution1 {
    public void traverse(Node root, ArrayList<String> ans, String s){
        if(root.left == null && root.right ==null){
            ans.add(s);
            return;
        }
        traverse(root.left,ans,s+"0");
        traverse(root.right,ans,s+"1");
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>(new HComparator());

        for(int i=0 ; i<N;i++)
        {
            Node node = new Node(f[i],null,null);
            pq.add(node);
        }

        while(pq.size()>1)
        {
            Node l = pq.peek();
            pq.poll();
            Node r =pq.poll();

            int ans = r.data + l.data;
            Node node = new Node(ans,l,r);
            pq.add(node);
        }
        Node root = pq.peek();
        pq.poll();
        ArrayList<String> ans = new ArrayList<>();
        String temp ="";
        traverse(root,ans,temp);
        return ans;
    }
}
public class Haffman_Coding {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.huffmanCodes("abcdefghijklmnopqrstuvwxy",new int[]{8, 9, 14 ,19 ,20, 21 ,21 ,25 ,33, 45, 50, 50, 66, 68, 70 ,73 ,74 ,75 ,76 ,82 ,85 ,90 ,94 ,97, 100},25));
    }
}
