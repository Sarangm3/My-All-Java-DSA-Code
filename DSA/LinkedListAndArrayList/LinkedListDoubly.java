package DSA.LinkedListAndArrayList;

public class LinkedListDoubly {

    private class Node{
        private int value;
        private  Node next;// default is null
        private Node prev;

        public Node(int value)//next = // default is null
        {
            this.value = value;
        }
        public Node(int value, Node next , Node prev)
        {
            this.value=value;
            this.next = next;
            this.prev = prev;
        }
    }
    private  Node Head;//only point Node class  //default is null
    private  Node Tail;//only point Node class
    private int size;                          //default is 0

    public int getSize(){
        return size;
    }

    public void insertFirst(int value)//
    {
        Node newNode = new Node(value);
        newNode.next = Head;
        newNode.prev = null;

        if (Tail == null) {  // for first
            Head = newNode;
            Tail = Head;// or newNode
            size+=1;
            return;
        }
        Head.prev = newNode;
        Head = newNode;
        this.size+=1;
    }
    public void pushElement (int value)
    // insertAtLast
    {
        if (Tail == null)
        {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.prev=Tail;
        Tail.next = newNode;
        Tail = newNode;
        this.size+=1;
    }
    public void isertAtIndex(int index,int value) //oppp
    {
        if (index==0 && Tail==null)
        {
            insertFirst(value);
            return;
        }

        if (index<size) {
            if (index<=size/2) {
                Node newNode = new Node(value);
                Node temp = Head;
                int count = 1;//tested on paper
                while (index > count) {
                    temp = temp.next;
                    count++;
                }
                newNode.prev = temp;
                newNode.next = temp.next;
                temp.next = newNode;
                newNode.next.prev = newNode;
            }
            else {
                        Node newNode = new Node(value);
                Node temp = Tail;
                int count = size-2;
                while (index<count)
                {
                    temp = temp.prev;
                    count--;
                }
                newNode.next = temp;
                newNode.prev = temp.prev;
                newNode.prev.next = newNode;
                temp.prev = newNode;
            }
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
        Tail = Tail.prev;
        Tail.next = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public  void display()
    {
        Node temp = Head;
        while (temp!=null)
        {
            System.out.print(temp.value+" <=> ");
            temp = temp.next;
        }
        System.out.printf("\b\b\b\b<=> End");
        System.out.println();

    }

}
