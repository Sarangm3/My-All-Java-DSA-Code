package DSA.Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Huffman {
    public static void printCode(HuffmanNode root, String s)
    {
        if (root.left== null && root.right == null&& Character.isLetter(root.c)) {

            System.out.print(s+" ");

            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        int n = 25;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'};
        int[] charfreq = { 8, 9, 14 ,19 ,20, 21 ,21 ,25 ,33, 45, 50, 50, 66, 68, 70 ,73 ,74 ,75 ,76 ,82 ,85 ,90 ,94 ,97, 100 };

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root, "");
    }
}
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
        return x.data - y.data;
    }
}
public class test {
}
