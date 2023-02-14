package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class test {
    static ArrayList<Integer> list()
    {
        int a = 1;
        int b = 2;
        return new ArrayList<>(Arrays.asList(a,b));
    }

    public static void main(String[] args) {
        int [][] arrays = {{1,2,3},
                            {2,3,4},
                            {2,3,1}};
//        for (int i = 0; i < arrays.length; i++) {
//            Arrays.fill(arrays[i],-1);
//        }
//        int [] array ={1,3,4};
//        int Total = Arrays.stream(array).sum();
//        System.out.println(Total);
//        System.out.println(list());

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
        }
        for(int i= 0 ; i < arrays.length; i++){
            Arrays.sort(arrays[i]);
        }
        System.out.println();
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
        }
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[2];
            }
        });
        System.out.println();
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(arrays[i]));
        }
    }
}
