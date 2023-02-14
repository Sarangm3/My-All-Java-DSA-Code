package DSA.BinaryTree.BST;


import java.util.*;

class Node {
    int data;
    Node left,right;
    public Node(int data) {
        this.data = data;
    }
}
class MyTree {
    Node Root;

    ////////////////////////////insertion ////////////////////////////////////////////////////
    void insert(int value)
    {
        insertRecution(Root,value);
    }
    Node insertRecution(Node root,int value) {
        if(Root==null)
        {
            Root = new Node(value);
        }
        if(root==null)
        {
            return new Node(value);
        }
        if (value>root.data)
        {
            root.right=insertRecution(root.right,value);
        }
        if(value<=root.data)
        {
            root.left = insertRecution(root.left,value);
        }
        return root;
    }
    void insertItretive(int value) {
        Node root = Root;
        Node newNode = new Node(value);
        Node perant = null;

        while(root!=null)
        {
            perant = root;
            if(value<=root.data)
            {
                root= root.left;
            }
            else if(value>root.data)
            {
                root = root.right;
            }
        }
        if(perant==null)
        {
            Root = newNode;
        }
        else{
            if(value>perant.data)
            {
                perant.right = newNode;
            }
            else{
                perant.left = newNode;
            }
        }
    }
    //////////////////////////////////deletion/////////////////////////////////////////////////////

    void deletion(int value) {
        if(Root==null)
        {
            return;
        }
        else{
            Root = deletionRecurtion(Root,value);
        }
    }
    Node min(Node root) {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    private Node deletionRecurtion(Node root,int value) {


        if(value<root.data)
        {
            root.left = deletionRecurtion(root.left,value);
        }
        else if(value>root.data)
        {
            root.right = deletionRecurtion(root.right,value);
        }
        else if(root.data==value)
        {
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null || root.right==null)
            {
                return root.left==null ? root.right : root.left;
            }
            else{
                root.data = min(root.right).data;
                root.right = deletionRecurtion(root.right,root.data);
            }
        }
        return root;
    }

    ////////////////////////////////////////////print///////////////////////////////////////////////
    void print(){
        System.out.println();
        inorder(Root);
        System.out.println();
    }
    void inorder(Node root) {
        if(root==null)return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //////////////////////////////////////////quetion////////////////////////////////////////////////
    ////////
    int floor(int target) {
        Node root = Root;
        int ans = Integer.MAX_VALUE;
        while(root!=null)
        {
            if(root.data==target)
            {
                ans = root.data;
                break;
            }
            else if(target < root.data)
            {
                root = root.left;
            }
            else if(target > root.data) //small my be answer but big value not answer
            {
                ans = root.data;
                root = root.right;
            }
        }
        return ans;
    }
    int ceil(int target) {
        Node root = Root;
        int ans = Integer.MIN_VALUE;
        while(root!=null)
        {
            if(root.data==target)
            {
                ans = root.data;
                break;
            }
            else if(target < root.data) // big data may be answer but small data not posible
            {
                ans = root.data;
                root = root.left;
            }
            else if(target > root.data)
            {
                root = root.right;
            }
        }
        return ans;
    }
    /////////
    boolean isPairPresent(int target) {
        Set<Integer> set = new HashSet<>();
        return until(Root,target,set,0);
    }
    private boolean until(Node root, int sum, Set<Integer> set,int i) {
        if(root == null) return false;

        System.out.println(i);
        if(until(root.left,sum,set,i+1)==true)
        {
            return true;
        }
        if(set.contains(sum-root.data))//you can't do it any traversal
        {
            set.clear();
            return true;
        }
        set.add(root.data);

        return until(root.right,sum,set,i+1);
    }
    ////////
    ArrayList<Integer> verticalOrder(){
        Queue<Pair> queue= new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        Node root = Root;
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
                queue.add(new Pair(curr.stap+1,curr.node.left));
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
    ////////
    Node Find(Node root, int data){

        if (root==null) return root;
        if (data<root.data) return Find(root.left,data);
        if (data>root.data) return Find(root.right,data);
        else return root;
    }
    Node mini(Node root){

        Node temp=root;
        while(temp.left!=null)
        {
            temp=temp.left;
        }
        return temp;
    }
    Node successorf(int data)
    {
        return successorr(Root,data);
    }
    Node successorr(Node root, int data) {
        Node current = Find(root,data);
        if (root==null)
        {
            System.out.println("empty");
            return null;
        }
        if(current.right!=null){
            return mini(current.right);
        }
        else//nearest ancester which current node contain in right side of ancester
        {
            Node succ=null;
            Node ancester=root;
            while(ancester!=current)
            {
                if (ancester.data < current.data) {
                    ancester = ancester.right;
                }
                else {
                    succ = ancester;
                    ancester = ancester.left;
                }
            }
            return succ;
        }
    }

    ///
    private class Pair {
        int stap;
        Node node;

        public Pair(int stap, Node node) {
            this.stap = stap;
            this.node = node;
        }
    }
}
public class BSTsProgram {
    public static void main(String[] args) {
        MyTree T  = new MyTree();
//        insertion in bts
//        T.insert(8);
//        T.insert(6);
////        T.insert(2);
////        T.insert(4);
//        T.insertItretive(21);
//        T.insertItretive(15);
//        T.insertItretive(26);
//        T.insertItretive(13);
//        deletion in bts
//        1.no child
//        2.one child
//        3.two child
//        T.print();
//        T.deletion(10);
//         T.print();
//        System.out.println(T.floor(25));
//        System.out.println(T.ceil(25));
//                T.insert(60);
//                T.insert(40);
//                T.insert(100);
//                T.insert(30);
//                T.insert(50);
//                T.insert(80);
//                T.insert(90);
//                T.insert(70);
//
//        System.out.println(T.isPairPresent(70));
        T.insertItretive(10);
        T.insertItretive(20);
        T.insertItretive(30);
        T.insertItretive(50);
        T.insertItretive(40);

        T.verticalOrder();
        System.out.println(T.successorf(10).data);
    }
}

