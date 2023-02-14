package DSA.Sorting;

import java.util.Arrays;

public class practise {
    static void swap(int [] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static int smallest_element(int [] array,int i){
        int mini = i;
        for (int j = i; j < array.length; j++) {
            if (array[j]<array[mini]){
                mini = j;
            }
        }
        return mini;
    }
    static int [] selection_sort(int [] array){
        int n = array.length;;
        for (int i = 0; i < n-1; i++) {
            int mini = smallest_element(array,i);
            swap(array,i,mini);
        }
        return array;
    }
    static int [] bubble_sort(int [] array){
        int n= array.length-1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (array[j]<array[j-1]){
                    swap(array,j,j-1);
                    count++;
                }
            }
            if (count==0) return array;
            count = 0;
        }
        return array;
    }
    static int [] insertion_sort(int [] array){
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >=1; j--) {
                if (array[j-1]>array[j])
                {
                    swap(array,j-1,j);
                }
                else {
                    break;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {-3, -2, -1, 0, 1, 2, 3,5, 5, 4, 3, 2, 1, 1};
        int [] sortedarr = {5,4,3,2,1};

        System.out.println("Original array: " + Arrays.toString(array));

        int a [] = selection_sort(Arrays.copyOf(array,array.length));

        System.out.println("Sorted array: " + Arrays.toString(a));

        int b [] = bubble_sort(Arrays.copyOf(array,array.length));

        System.out.println("Sorted array: " + Arrays.toString(b));

        int c [] = insertion_sort(Arrays.copyOf(array,array.length));

        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}
