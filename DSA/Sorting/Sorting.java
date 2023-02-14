package DSA.Sorting;

import java.util.Arrays;

class sort
{
    int [] array;
    public void Set_arry(int [] arr)
    {
        array = arr.clone();
    }
    void print_array()
    {
        System.out.println(Arrays.toString(array));
    }
    void swipe(int a,int b)    {
        array[a]=array[a]^array[b];
        array[b]=array[a]^array[b];
        array[a]=array[a]^array[b];
    }
    int min_index(int [] list,int start)    {
        int index=start;
        int min = list[start];
        for (int i=start ; i < list.length;i++)
        {
            if (list[i]<=min)
            {
                min=list[i];
                index=i;
            }
        }
        return index;
    }
    /////////////////////////////////
    void Bubble_Sort()    {
        int count=0;
        for (int i=0; i<array.length; i++)
        {
            for (int j=0; j<(array.length-i)-1; j++)
            {
                if (array[j]>array[j+1])
                {
                    swipe(j,j+1);
                    count++;
                }
            }
            if (count==0)
            {
                return;
            }
            count=0;
        }
    }
    /////////////////////////////////
    void Selection_Sort()    {
        for (int i=0 ; i<array.length;i++)
        {
            if (min_index(array,i)==i)
            {
                continue;
            }
            swipe(min_index(array,i),i);
        }
    }
    ////////////////////////////////
    void Insertion_Sort()    {
        for (int i=0;i< array.length-1;i++)
        {
            for (int j=i+1; j>0;j--)
            {
                if (array[j-1]>array[j])
                {
                    swipe(j-1,j);
                }
                else
                {
                    break;
                }
            }
        }
    }
}

public class Sorting {

    public static void main(String[] args) {

        int [] array = {1,3,5,4,2};
        sort s = new sort();
        s.Set_arry(array);

        //
//        System.out.println("bubble sort");
//        s.print_array();
//        s.Bubble_Sort();
//        s.print_array();

//        //
//        System.out.println("Selection Sort");
//        s.print_array();
//        s.Selection_Sort();
//        s.print_array();
        //
        System.out.println("Insertion Sort");
        s.print_array();
        s.Insertion_Sort();
        s.print_array();
    }
}
