package BasicJava;

import java.util.*;
public class arrylist {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();//min 10
        ArrayList<Integer> l2 = new ArrayList<>(5);
        l2.add(12);
        l2.add(18);
        l2.add(14);

        l1.add(1);
        l1.add(4);
        l1.add(1);
        l1.add(5);
        l1.add(7);
        l1.add(8);
        l1.add(2);
        l1.addAll(l2);
        System.out.println(l1.isEmpty());
        System.out.println(l1.contains(7));
        l1.remove(new Integer(1));
        l1.remove(3);

        for (int i=0;i<l1.size();i++)
        {
            System.out.println(l1.get(i));
        }
        System.out.println(l1);
        int [] array = {12,34,56,67};
        System.out.println(new Integer(32)+""+new ArrayList<>());

    }
}
