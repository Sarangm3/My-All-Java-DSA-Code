package OOPs.Collage.Practical8;


import java.util.Arrays;

public class Practical_03 {

     static int[] removeElements(int[] arr, int key) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key)
                arr[index++] = arr[i];
            }
            return Arrays.copyOf(arr, index);
        }

    public static void main(String[] args)
    {
        int[] array = { 3, 6, 9, 3, 6, 9, 2, 8, 5 };
        int key = 3;
        System.out.println("orignal array is "+Arrays.toString(array));
        System.out.println("remove element as key is 3");
        array = removeElements(array, key);
        System.out.print(Arrays.toString(array));
    }
}


