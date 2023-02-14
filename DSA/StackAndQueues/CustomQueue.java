package DSA.StackAndQueues;

import java.util.Arrays;

public class CustomQueue {
    protected int [] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size)
    {
        this.data = new int[size];
    }

    public void insert(int item){
        if(isFUll())
        {
            System.out.println("queue is full");
            return;
        }
        data[end++] = item;
    }

    public int remove() throws Exception {
        if (isEmpty())
        {
            throw new Exception("Queue is empty");
        }
        int removeItem = data[0];
        //shift element
        for (int i = 1; i < end; i++) { //is  1 3 5 4 0 so end is 5
            data[i-1] = data[i];
        }
        end--;
        return removeItem;
    }


    public boolean isFUll(){
        return end == data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return "CustomQueue{" +
                "data=" + Arrays.toString(data) +
                ", end=" + end +
                '}';
    }
}
