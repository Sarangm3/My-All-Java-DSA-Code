package OOPs.Collage.Practical2;

import java.util.Arrays;

class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int tope=-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size)
    {
        this.data = new int[size];
    }

    public void push(int item){
        if (isFull()) {
            int [] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i]= data[i];
            }
            data = temp;
        }
        tope++;
        data[tope] = item;
    }

    public int pop(){
        if (isEmpty())
        {
            System.out.println("Empty Stack exception for pop");
        }
        int removeData = data[tope];
        tope--;
        return removeData;
    }

    public boolean isFull() {
        return tope==data.length-1;
    }
    public boolean isEmpty(){
        return tope==-1;
    }
    public int size(){
        return data.length;
    }
    public void print(){
        System.out.println(Arrays.toString(data));
    }
}
public class Practical_02 {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(23);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println(stack.size());
        stack.push(4);
        stack.print();
        System.out.println(stack.size());
    }
}
