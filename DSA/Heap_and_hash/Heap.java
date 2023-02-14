package DSA.Heap_and_hash;

import java.util.Arrays;

class Heaps
{
    void swipe(int [] array,int a, int b)
    {
        array[a] = array [b] ^ array[a];
        array[b] = array [b] ^ array[a];
        array[a] = array [b] ^ array[a];
    }
    void heapSort(int [] array)
    {
        int n= array.length;
        buildHeap(array);
        for (int i = n-1;i>0;i--)
        {
            swipe(array,i,0);
            heapify(array,i,0);
        }
    }
    void buildHeap( int [] array)
    {
        for (int i= array.length/2-1;i>=0;i--)
        {
            heapify(array, array.length, i);
        }
    }

    void heapify(int [] array,int n,int i)
    {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if (l< n && array[l]>array[largest])
        {
            largest = l;
        }
        if (r< n && array[r]>array[largest])
        {
            largest = r;
        }
        if (largest!=i)//till left and right not large
        {
            swipe(array,largest,i);
            heapify(array,n,largest);
        }
    }
}
public class Heap {
    public static void main(String[] args) {
        int [] array = {12,1243,3434,30,20,10,15,25,35,70};
        System.out.println(Arrays.toString(array));
        Heaps hp = new Heaps();
        hp.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
