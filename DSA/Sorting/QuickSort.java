package DSA.Sorting;

import java.util.Arrays;

class Quicks{
    void swipe(int []array,int a,int b)    {
        if (a==b)
        {
            return;
        }
        array[a] = array[a]^array[b];
        array[b] = array[a]^array[b];
        array[a] = array[a]^array[b];
    }

    public void sorting(int [] array,int low, int high)
    {
        if (low>high)
        {
            return;
        }
        int s= low;
        int e= high;
        int pivot = array[s+(e-s)/2];

        while(s<=e)
        {
            while (array[s] < pivot) {
                s++;
            }
            while (array[e] > pivot) {
                e--;
            }
            if (s<=e)
            {
                swipe(array,s,e);
                s++;
                e--;
            }
        }
        sorting(array,low,e);
        sorting(array,s,high);
    }
    int paitition(int []array,int Lb,int Ub){
        int pivot = array[Lb];
        int s = Lb;
        int e = Ub;

        while(s<e)
        {
            while(s<array.length && array[s]<=pivot){//for first pivot mathod
                s++;
            }
            //for last pivot method rather then s we use e.
            while(array[e]>pivot)
            {
                e--;
            }
            if(s<e){//one time more chack for swaping
                swipe(array, s, e);
            }
        }
        swipe(array,Lb,e);
        return e;
    }
    void quickSort(int [] array,int Lb,int Ub)
    {
        if(Lb<Ub) {//Lb-Ub==-1
            int pivot = paitition(array, Lb, Ub);
            quickSort(array, Lb, pivot - 1);
            quickSort(array, pivot + 1, Ub);
        }
    }

}

public class QuickSort {
    public static void main(String[] args) {
        int [] array ={7,6,-10,5,9,2,1,15,7};
        Quicks qs = new Quicks();
//        qs.sorting(array,0, array.length-1);
        qs.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }
}
