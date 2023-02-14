package DSA.Recurtion;

import java.util.Arrays;

public class RecurtionPatten {
    static void patten2(int r,int c)
    {
        if (r==0)
        {
            return;
        }
        if (c<r)
        {
            patten2(r,c+1);
            System.out.print("*");
        }
        else
        {
            patten2(r-1,0);
            System.out.println();
        }
    }
    static void swipe(int [] array,int a,int b)
    {
        array[a] = array[b] ^ array[a];
        array[b] = array[b] ^ array[a];
        array[a] = array[b] ^ array[a];
    }
    static void insertSort(int [] array,int s,int e)
    {
        if (e==0)
        {
            return;
        }
        if (s<e)
        {
            if (array[s]>array[s+1])
            {
                swipe(array,s,s+1);
            }
            insertSort(array,s+1,e);
        }
        else
        {
            insertSort(array,0,e-1);
        }
    }
    public static void main(String[] args) {
        int [] array = {3,2,4,7,8,1};
        insertSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
