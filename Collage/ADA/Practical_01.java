package Collage.ADA;

import java.util.Arrays;

public class Practical_01 {
//    static void timeTakeBubbleSort(int [] arr){
//
//        Practical_01 obj = new Practical_01();
//        long start = System.nanoTime();
//        obj.bubbleSort(arr);
//        long end = System.nanoTime();
//        long execution = end - start;
//        System.out.println("Execution time of bubbleSort: " + execution + " nanoseconds");
//    }
    static void timeTakeaInsertionSort(int [] arr){

        Practical_01 obj = new Practical_01();
        long start = System.nanoTime();
        obj.insertionSort(arr);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time of insertionSort: " + execution + " nanoseconds");
    }
//    static void timeTakeSelectionSort(int [] arr){
//
//        Practical_01 obj = new Practical_01();
//        long start = System.nanoTime();
//        obj.selectionSort(arr);
//        long end = System.nanoTime();
//        long execution = end - start;
//        System.out.println("Execution time of selectionSort: " + execution + " nanoseconds");
//    }
    static void swap(int [] arr,int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
//    static void bubbleSort(int [] arr)
//    {
//        boolean flage = false;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j < arr.length - i ; j++) {
//                if(arr[j-1] > arr[j])
//                {
//                    swap(arr,j-1,j);
//                    flage = true;
//                }
//            }
//            if (flage==false)
//            {
//                break;
//            }
//        }
//    }
//    public static void selectionSort(int[] arr){
//
//        for (int i = 0; i < arr.length - 1; i++)
//        {
//            int index = i;
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[j] < arr[index]){
//                    index = j;//searching for lowest index
//                }
//            }
//            int smallerNumber = arr[index];
//            arr[index] = arr[i];
//            arr[i] = smallerNumber;
//        }
//    }
    public static void insertionSort(int array[]) {

        int n = array.length;
        for (int i = 0; i < array.length -1 ; i++) {
            for (int j = i+1; j >0; j--) {
                if(array[j] < array[j-1])
                {
                    swap(array,j-1,j);
                }
                else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println("Best case:");
//        System.out.println(Arrays.toString(new int [] {1,2,3,4,5}));
//        timeTakeaInsertionSort(new int [] {1,2,3,4,5});
//        timeTakeBubbleSort(new int [] {1,2,3,4,5});
        System.out.println("Worst case:");
        System.out.println(Arrays.toString(new int [] {5,4,3,2,1}));
//        timeTakeBubbleSort(new int [] {5,4,3,2,1});
        timeTakeaInsertionSort(new int [] {5,4,3,2,1});
//        timeTakeSelectionSort(new int [] {5,4,3,2,1});

    }
}