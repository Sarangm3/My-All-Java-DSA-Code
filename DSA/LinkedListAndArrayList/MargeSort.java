package DSA.LinkedListAndArrayList;

public class MargeSort {

    ListNode sort(ListNode head)
    {
        if (head==null||head.next==null)
        {
            return head;
        }
        ListNode list1=sort(mid(head));//dived make new list
        ListNode list2=sort(head);

        return marge(list1,list2);
    }
    ListNode marge(ListNode list1,ListNode list2)
    {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(list1!=null && list2!= null)
        {
            if (list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = list1==null ? list2 : list1;
        return newHead.next;
    }

    ListNode mid(ListNode head)
    {
         ListNode midPrev = null;
         while(head!=null&&head.next!=null)//head fast
         {
             midPrev = midPrev==null ? head : midPrev.next; // for mid - 1
             head = head.next.next;
         }
         ListNode mid = midPrev.next; // mid
         midPrev.next = null; // half list separate parent list
        //change in main list so you can't you main list know
        return mid;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
}
