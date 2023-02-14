package Collage.ADA;

import DSA.Sorting.QuickSort;

import java.util.Arrays;

public class Practical_02 {
//    static void timeTakeMergeSort(int [] arr){
//
//        Practical_02 obj = new Practical_02();
//        long start = System.nanoTime();
//        obj.mergeSort(arr,0, arr.length-1);
//        long end = System.nanoTime();
//        long execution = end - start;
//        System.out.println("Execution time of MergeSort: " + execution + " nanoseconds");
//    }

    static void timeTakeQuickSort(int [] arr){

        Practical_02 obj = new Practical_02();
        long start = System.nanoTime();
        obj.quickSort(arr,0, arr.length-1);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time of QuickSort: " + execution + " nanoseconds");
    }
    static void quickSort(int [] array,int low, int high)
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
        quickSort(array,low,e);
        quickSort(array,s,high);
    }

    static void swipe(int []array,int a,int b)    {
        if (a==b)
        {
            return;
        }
        array[a] = array[a]^array[b];
        array[b] = array[a]^array[b];
        array[a] = array[a]^array[b];
    }
//    static void mergeSort(int [] array,int s,int e)
//    {
//        if (e==s)
//        {
//            return;
//        }
//        int mid = s + (e-s)/2;
//        mergeSort(array,s,mid);
//        mergeSort(array,mid+1,e);
//
//        merge(array,mid,s,e);
//
//    }
//    static void merge(int [] array , int mid, int s , int e)
//    {
//        int [] ans=new int[e-s+1];
//        int i = s;
//        int j = mid+1;
//        int k = 0;
//        while(i <= mid && j <=e ) {
//            if (array[i] < array[j]) {
//                ans[k] = array[i];
//                i++;
//            } else {
//                ans[k] = array[j];
//                j++;
//            }
//            k++;
//        }
//
//        while(i<=mid){
//            ans[k] = array[i];
//            k++;i++;
//        }
//        while(j<=e){
//            ans[k] = array[j];
//            k++;j++;
//        }
//
//        for (i=0 ; i<ans.length;i++)
//        {
//            array[s+i] = ans[i];
//        }
//    }

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1,20};
        System.out.println("Array is :"+Arrays.toString(array));
//        timeTakeMergeSort(array);
        timeTakeQuickSort(array);
        System.out.println("After Sorting :"+Arrays.toString(array));

    }
}
