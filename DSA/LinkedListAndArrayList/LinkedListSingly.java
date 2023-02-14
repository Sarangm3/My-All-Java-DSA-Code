package DSA.LinkedListAndArrayList;

public class  LinkedListSingly {

    class Node{
        private int value;
        private Node next;// default is null
        public Node(){}
        public Node(int value)//next = // default is null
        {
            this.value = value;
        }
        public Node(int val,Node next){
            this.value = val;
            this.next = next;
        }
    }

    Node Head;//only point Node class //default is null
    //if you want change head you change directly without passing
    //if you pass head another function and other function take copy of head pointer not
    //head pointer show you change copy of head to pointer different head but main head not
    //if you give any pointer in perimeter so pointer copy create then you use because main pointer not change

    private Node Tail;//only point Node class
    private int size;                          //default is 0


    public int getSize(){
        return size;
    }
    Node temp = Head;
    public void insertRec(int value,int index)
    {
//        return helper(value,index,Head); form helper viod
        Head = helper(value,index,Head);
    }
    public Node helper(int value ,int index,Node temp)
    {
        if (index==0)
        {
            Node node = new Node(value,temp);
            size++;
            return node;
        }

        temp.next = helper(value,index-1,temp.next);
        return temp;
    }
    public void insertFirst(int value)
    {
        Node newNode = new Node(value);
        newNode.next = Head;
        Head = newNode;
        if (Tail == null) {
            Tail = Head;// or newNode
        }
        this.size+=1;
    }
    public void pushElement (int value) // insertAtLast
    {
        if (Tail == null)
        {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Tail.next = newNode;
        Tail = newNode;
        this.size+=1;
    }
    public void isertAtIndex(int index,int value)
    {
        if (index==0 && Tail==null)
        {
            insertFirst(value);
            return;
        }
        if (index<size) {
            Node newNode = new Node(value);
            Node temp = Head;
            int count = 1;//tested on paper
            while (index > count) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        else
        {
            System.out.println("error");
        }

        this.size+=1;
    }

    public void popElement () { // you don't think about node free Unlike c
        if (isEmpty()){
            System.out.println("error");
            return;
        }
        if (size==1)
        {
            Head = null;
            Tail = null;
            return;
        }
        Node temp = Head;
        while (temp.next.next != null)//use pan paper
        {
            temp = temp.next;
        }
        Tail = temp;
        Tail.next = null;

        this.size-=1;
    }
    void deleteNode(int position)
    {
        if (Head == null)
            return;

        Node temp = Head;

        if (position == 0) {
            Head = temp.next; // Change head
            return;
        }

        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public  void display()
    {
        Node temp = Head;
        while (temp!=null)
        {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.printf("\b\b\b-> End");
        System.out.println();
    }

    void reversList(){
        if (Head.next==null)
        {
            return;
        }
        Tail = Head;
        Head.next=null;
        Node temp1 = Head;        //prev
        Node temp2 = temp1.next;        //current
        Node temp3 = temp2.next;  //next
        while (temp3!=null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;//for travle linked list
        }
        temp2.next = temp1;
        Head = temp2;
    }
    void reversListrec(){
        helper(Head);
    }
    void helper(Node head) // for give Head
    {
        if (head==Tail)
        {
            Head = Tail;
            return;
        }
        helper(head.next);
        Tail.next = head;
        Tail = head;
        Tail.next = null;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    void rotateRight(){
        Head = rotateRighthelper(Head,2);
    }
    public Node rotateRighthelper(Node head, int k) {

        int length = lengthLL(head);
        int tailPosition = length - (k%length);
        Node tail = tail(head);
        tail.next = head;
        tail = get(tailPosition,head);
        head = tail.next;
        tail.next = null;

        return head;
    }

    int lengthLL(Node head)
    {
        int count =0;
        while(head!=null)
        {
            head = head.next;
            count++;
        }
        return count;
    }
//    private Node get(int index , Node head){
//        int count = 1;
//        while(index>count)
//        {
//            head = head.next;
//            count++;
//        }
//        return head;
//    }

    Node tail(Node head)
    {
        while(head.next!=null)
        {
            head = head.next;
        }
        return head;
    }
     public void reverseKGroup(int k)
     {
         Head = helper(Head,k);
     }
        public Node helper(Node head, int k) {

            int length = lengthLL(head);
            int left = 1;
            int right = k;

            while(length>=k)
            {
                head = reverseBetween(head,left,right);
                left +=k;
                right+=k;
                length -=k;
            }

            return head;
        }

//        private int lengthLL(Node head)
//        {
//            int count = 0;
//            while(head!=null)
//            {
//                head = head.next;
//                count++;
//            }
//            return count;
//        }

        // k is lessthen lenght and =
        // if remaining node is less then k then don't do andy thing
        // 1 - we use reverse list function
        // 2 - logic when revers which pointer // do by four pointer


    public Node reverseBetween(Node head, int left, int right) {
        // head nathi reverse list
        // end nathi reverse list

        Node end = get(right,Head);
        end = end.next;

        if(left==1)
        {
            Head = reverse(head,end);
        }
        else{
            head = get(left-1,Head);
            head.next = reverse(head.next,end);
        }

        Node newEnd = get(right,Head);
        newEnd.next = end;


        return Head;
    }

    private Node get(int index , Node head){
        int count = 1;
        while(index>count)
        {
            head = head.next;
            count++;
        }
        return head;
    }

    private Node reverse(Node head,Node end) {
        if (head.next == null) {
            return head;
        }

        Node temp1 = head;
        Node temp2 = temp1.next;
        Node temp3 = temp2.next;
        while (temp3 != end) {
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;//for travle linked list
        }
        temp2.next = temp1;
        return temp2;
    }

    // extra stuff

//    public static void main(String[] args) {
//        // make object of nested class
//        // (for static nested class:
//        // OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass() )
//
//        LL l = new LL();
//        LL.Node linked_node = l.new Node(23);
//
//        System.out.println(linked_node.next);
//
//    }
    public static void main(String[] args) {
        LinkedListSingly list = new LinkedListSingly();
//        list.pushElement(1);
//        list.pushElement(8);
//        list.pushElement(3);
//        list.pushElement(4);
//        list.pushElement(0);
//        list.pushElement(0);
//        list.pushElement(7);
//
//        list.display();
//        list.reversList();
//        list.display();
//        list.reversListrec();
//        list.display();
//        1->4->3->2->5->2
        list.pushElement(1);
        list.pushElement(4);
        list.pushElement(3);
        list.pushElement(2);
        list.pushElement(5);
        list.pushElement(2);
//        list.pushElement(6);
//        list.pushElement(7);
//        list.pushElement(8);
//        list.pushElement(9);

        list.display();
//        list.reverseBetween();
//        list.re();
//        list.reverseKGroup(3);
//        list.rotateRight();
        list.display();


    }
}
