package DSA.LinkedListAndArrayList;

public class Main {
    public static void main(String[] args) {

        //make our lindedlist help to understand quetion

//        LinkedListSingly Slist = new LinkedListSingly();
//        Slist.isertAtIndex(0,0);// for first place
//        Slist.pushElement(10);
//        Slist.insertFirst(1);// for first place
//        Slist.isertAtIndex(2,3);
//        Slist.display();
//
//        System.out.println();
//        Slist.popElement();
//        Slist.display();
//
//        System.out.println();
//        System.out.println();
//
//        LinkedListDoubly Dlist = new LinkedListDoubly();
//        Dlist.isertAtIndex(0,0);// for first place
//        Dlist.pushElement(10);
//        Dlist.pushElement(3);
//        Dlist.pushElement(23);
//        Dlist.pushElement(53);
//        Dlist.insertFirst(11);// for first place
//        Dlist.insertFirst(31);// for first place
//        Dlist.insertFirst(12);// for first place
//        Dlist.insertFirst(13);// for first place
//        Dlist.isertAtIndex(2,3);
//        Dlist.isertAtIndex(3,19);
//        Dlist.isertAtIndex(6,33);
//
//        Dlist.display();
//        Dlist.popElement();
//        Dlist.display();
//        Dlist.isertAtIndex(7,2003);
//        Dlist.display();
//
//        System.out.println();
//        LinkedListCircular Clist = new LinkedListCircular();
//        Clist.pushElement(23);
//        Clist.pushElement(3);
//        Clist.pushElement(19);
//        Clist.pushElement(75);
//        Clist.display();
//        Clist.delete(19);
//        Clist.display();


        // que
        LinkedListSingly list = new LinkedListSingly();
        list.insertRec(21,0);
        list.insertRec(2,1);
        list.insertRec(1,2);
        list.insertRec(3,3);
        list.insertRec(0,0);
        list.display();

    }
}
