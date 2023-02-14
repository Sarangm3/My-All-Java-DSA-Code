package OOPs.Collage.Practical8;

class  LinkedListSingly {
    class Node {
        private int value;
        private Node next;// default is null

        public Node() {
        }
        public Node(int value)//next = // default is null
        {
            this.value = value;
        }
        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }

    Node Head;//only point Node class  //default is null

    private Node Tail;//only point Node class
    private int size;//default is 0
    public int getSize() {
        return size;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = Head;
        Head = newNode;
        if (Tail == null) {
            Tail = Head;// or newNode
        }
        this.size += 1;
    }

    public void pushElement(int value) // insertAtLast
    {
        if (Tail == null) {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Tail.next = newNode;
        Tail = newNode;
        this.size += 1;
    }

    public void isertAtIndex(int index, int value) {
        if (index == 0 && Tail == null) {
            insertFirst(value);
            return;
        }
        if (index < size) {
            Node newNode = new Node(value);
            Node temp = Head;
            int count = 1;
            while (index > count) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("error");
        }

        this.size += 1;
    }

    public void popElement() { // you don't think about node free Unlike c
        if (isEmpty()) {
            System.out.println("error");
            return;
        }
        if (size == 1) {
            Head = null;
            Tail = null;
            return;
        }
        Node temp = Head;
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        Tail = temp;
        Tail.next = null;

        this.size -= 1;
    }

    void deleteNode(int position) {
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.printf("\b\b\b-> End");
        System.out.println();
    }
}

public class Practical_01 {
    public static void main(String[] args) {
        LinkedListSingly list = new LinkedListSingly();
        list.pushElement(3);
        list.pushElement(6);
        list.pushElement(9);
        list.pushElement(12);
        list.pushElement(15);
        list.pushElement(18);
        list.pushElement(21);
        list.display();
        list.popElement();
        list.deleteNode(0);
        list.deleteNode(1);
        list.display();
    }
}