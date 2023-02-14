package DSA.BST;

class successor{

    class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int val)
        {
            data=val;
            left=right=null;
        }

    }
    Node root;

    successor()
    {
        root=null;
    }
    void INprint()
    {
         in_print(root);
    }
    void in_print(Node root)
    {
        if (root==null) return;
        in_print(root.left);
        System.out.print(root.data+" ");
        in_print(root.right);
    }
    Node Find(Node root, int data)
    {

        if (root==null) return root;
        if (data<root.data) return Find(root.left,data);
        if (data>root.data) return Find(root.right,data);
        else return root;
    }
    void insert(int data){
        root = Insertr(root,data);
    }
    Node Insertr(Node root,int data)
    {
        if (root==null){
            root=new Node(data);
            return root;
        }
        if (data<root.data) root.left = Insertr(root.left,data);
        if (data>root.data) root.right = Insertr(root.right,data);

        return root;
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
        return successorr(root,data);
    }
    Node successorr(Node root,int data)
    {
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
}
public class BST_successor {
    public static void main(String[] args) {

        successor s = new successor();
        s.insert(100);
        s.insert(80);
        s.insert(200);
        s.insert(250);
        s.insert(170);
        s.insert(160);
        s.insert(190);
        s.insert(180);
        s.insert(195);
        s.insert(175);
        s.insert(181);
        s.insert(191);
        s.insert(196);

        s.INprint();
        System.out.println();
        successor.Node ans = s.successorf(190);
        System.out.println(ans.data);
    }
}
