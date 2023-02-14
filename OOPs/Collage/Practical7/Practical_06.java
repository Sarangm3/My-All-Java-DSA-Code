package OOPs.Collage.Practical7;
import java.util.Arrays;

class CircularQueue {
    protected int [] data;
    private static final int DEFAULT_SIZE = 10;

    int front =0;//point front element
    int end = 0;//rear + 1 point next of rear element
    private int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size)
    {
        this.data = new int[size];
    }

    public void insert(int item)
    {
        if(isFull())
        {
            System.out.println("Queue is full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
    }
    public int remove() throws Exception {
        if(isEpty())
        {
            throw new Exception("Queue is empty");
        }
        int removeItem = data[front];
        front++;
        front = front % data.length;
        size--;
        return removeItem;
    }

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEpty(){
        return size == 0;
    }
    public void display(){
        int i = front;
        if (isFull())
        {
            System.out.print(data[i]+" ");
            i++;
            i = i% data.length;
        }
        while (i != end)
        {
            System.out.print(data[i]+" ");
            i++;
            i = i% data.length;
        }
    }
    @Override
    public String toString() {
        return "CircularQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", end=" + end +
                ", size=" + size +
                '}';
    }
}

public class Practical_06 {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue();
        System.out.println("Inserting element in queue");
        queue.insert(3);
        queue.insert(6);
        queue.insert(9);
        queue.insert(12);
        queue.insert(15);
        System.out.println(queue.toString());
        queue.remove();
        queue.remove();
        System.out.println("Front move ahead because of remove function");
        System.out.println(queue.toString());
        queue.remove();
        queue.remove();
        queue.remove();
        try {
            queue.remove();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
