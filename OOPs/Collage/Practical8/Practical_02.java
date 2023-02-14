package OOPs.Collage.Practical8;

import java.util.PriorityQueue;

class MyPriorityQueue<I extends Number> extends PriorityQueue implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Practical_02 {
    public static void main(String[] args) throws Exception {
        MyPriorityQueue<Integer> PriorityQueue1 = new MyPriorityQueue<>();

        PriorityQueue1.offer(3);
        PriorityQueue1.offer(6);
        PriorityQueue1.offer(9);
        System.out.println("PriorityQueue1 after insert element:");
        System.out.println(PriorityQueue1);
        MyPriorityQueue<Integer> PriorityQueue2 = (MyPriorityQueue<Integer>) PriorityQueue1.clone();
        System.out.println("PriorityQueue2 after clone first");
        System.out.print(PriorityQueue2);

    }
}
