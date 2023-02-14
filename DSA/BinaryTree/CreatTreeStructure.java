package DSA.BinaryTree;
import java.util.*;

public class CreatTreeStructure {

    static Scanner sc = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);
//
        Node root = createTree();
//        inOrder(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        System.out.println(height(root));
//        System.out.println();
//        System.out.println(max(root));
//        System.out.println();
//        levelOrder(root);
//        System.out.println();
//        leftView(root,0);
//        for (int index: map.keySet()) {
//            System.out.print(map.get(index).data+" ");
//        }
//        topView(root,0);
//        System.out.println();
//        for (int index: map2.keySet()) {
//            System.out.print(map2.get(index).data+" ");
//        }

        System.out.println();
//        Flatten_Tree(root);
//        Node temp = head;
//        while(temp!=null)
//        {
//            System.out.print(temp.data+" ");
//            temp = temp.right;
//        }
//        System.out.println();
//        Node ans = LCA(root,4,3);
//        System.out.println(ans.data);
//
//        System.out.println();
//        System.out.println();
//        runtimeVurn(root,2);
//        System.out.println(ans3);
        System.out.println(BST_or_Not(root));
        verticalOrder(root);
    }

    static Node createTree() {

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for "+ data);
        root.right = createTree();

        return root;
    }

    static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    //you can do by recursion under loop call recursion function
    static void levelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
    }

    static HashMap<Integer,Node> map = new HashMap<>();

    static void leftView(Node root,int level){
        if (root==null) return;

        map.putIfAbsent(level,root); //for left just remove ifAbsent

        leftView(root.left,level+1);
        leftView(root.right,level+1);
    }

    static HashMap<Integer,Node> map2 = new HashMap<>();

    static void topView(Node root,int step){
        if(root==null) return;

        map2.putIfAbsent(step,root);

        topView(root.left,step-1);
        topView(root.right,step+1);
    }
    static int height(Node root){
        if(root==null) return 0;
        int h1 = height(root.left);
        int h2 = height(root.right);

        return Math.max(h1,h2)+1;
    }
    static Node head = null;
    static Node prev = null;
    //Flatten binary tree convert into doubly linked list
    //doubly linked list store node in inorder menary
    static void Flatten_Tree(Node root) {
        if(root==null) return;
        Flatten_Tree(root.left);
        if(prev==null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        Flatten_Tree(root.right);
    }

    //lowest common ancestor in binary tree
    static Node LCA(Node root,int a,int b) {
        if(root==null) return null;
        if(root.data==a||root.data==b) return root;

        Node l = LCA(root.left,a,b);
        Node r = LCA(root.right,a,b);
        if(l==null || r==null)
        {
            return l==null ? r : l;
        }
        if(l==null&&r==null)
        {
            return null;
        }
        return root;
    }

    //burn tree
    static int ans3=-1;
    static void runtimeVurn(Node root , int target) {
        Node depth = new Node(-1);
        Burn(root,target,depth);
    }
    static int Burn(Node root,int target,Node depth) {
        if(root==null) return 0;
        if(root.data==target){
            depth.data = 1;
            return 1;
        }
        Node ld = new Node(-1);
        Node rd = new Node(-1);
        int lh = Burn(root.left,target,ld);
        int rh = Burn(root.right,target,rd);

        if(ld.data!=-1){
            ans3 = Math.max(ans3,rh+ld.data+1);
            depth.data = ld.data+1;
        }
        else if(rd.data!=-1){
            ans3 = Math.max(ans3,lh+rd.data+1);
            depth.data = rd.data+1;
        }
        return Math.max(lh,rh)+1;
    }

    static boolean BST_or_Not(Node root) {

        if(root==null) return false;
        if(root.left!=null && root.left.data < root.data)
        {
            BST_or_Not(root.left);
        }
        else if(root.right!=null && root.right.data < root.data)
        {
            BST_or_Not(root.right);
        }
        else{
            return false;
        }
        return true;
    }

    static int max(Node root) {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        if(root.left==null&&root.right==null) return root.data;
        return (Math.max(root.data,Math.max(max(root.left),max(root.right))));
    }

    static ArrayList<Integer> verticalOrder(Node root){
        Queue<Pair> queue= new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0,root));
        while(!queue.isEmpty())
        {
            Pair curr = queue.poll();
            //if pela thi chhe map or nathi
            if(map.containsKey(curr.stap))
            {
                //arraylist made just add onemore item in list
                map.get(curr.stap).add(curr.node.data);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.node.data);
                map.put(curr.stap,list);
            }
            if(curr.node.left!=null)
            {
                queue.add(new Pair(curr.stap-1,curr.node.left));
            }
            if(curr.node.right!=null)
            {
                queue.add(new Pair(curr.stap+1,curr.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (Integer number: map.keySet()) {
            ans.addAll(map.get(number));
        }
        System.out.println(ans);
        return ans;
    }
}
class Pair {
    int stap;
    Node node;

    public Pair(int stap, Node node) {
        this.stap = stap;
        this.node = node;
    }
}
class Node {
    Node left, right;
    int data;
    public Node(int data) {
        this.data = data;
    }
}a


