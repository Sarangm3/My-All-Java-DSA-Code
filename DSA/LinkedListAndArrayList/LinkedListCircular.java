package DSA.LinkedListAndArrayList;


public class LinkedListCircular//(single)
{
    private Node head;
    private Node tail;
    private int size;

        private class Node{
            private int value;
            private Node next;
            public Node(int value)
            {
                this.value = value;
            }
            public Node(int value,Node next ,Node prev)
            {
                this.value = value;
                this.next = next;
            }
        }

    public void insertStart(int value){ //insert at start
            Node newNode = new Node(value);
            if (head==null)
            {
                head=newNode;
                tail = head;
                return;
            }
            newNode.next=head;
            tail.next = newNode;
            head = newNode;
    }
    public void pushElement(int value){ //insert at start
        Node newNode = new Node(value);
        if (head==null)
        {
            head=newNode;
            tail = head;
            return;
        }
        newNode.next=head;
        tail.next = newNode;
        tail = newNode;
    }
    public void delete(int value){
            Node temp = head;
            if(temp==null){
                System.out.println("linkded list empty");
                return;
            }
            if (head.value == value)
            {
                head = temp.next;
                tail.next = head;
                return;
            }

            do {
                Node temp2 = temp.next;
                if (temp2.value == value)
                {
                    temp.next = temp2.next;
                }
                if (temp2.value==value && tail.value == value)
                {
                    tail = temp;
                }
                temp = temp.next;
            }
            while(temp!=head);
    }
    public void display(){
            Node temp = head;
            while (temp.next != head)
            {
                System.out.print(temp.value+"->");
                temp = temp.next;
            }
            System.out.print(temp.value+"->");
            System.out.println("\b\b->END");
    }

}
