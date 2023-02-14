package Collage.ADA;

import java.io.*; import java.util.*;
public class Practical_03 {
//    static void binarySearch(int v[], int To_Find)
//
//    {
//        int lo = 0, hi = v.length - 1;
//
//        while (hi - lo > 1) {
//            int mid = (hi + lo) / 2;
//            if (v[mid] < To_Find) {
//                lo = mid + 1;
//            }
//            else {
//                hi = mid;
//            }
//        }
//        if (v[lo] == To_Find) {
//            System.out.println("Found At Index " + lo );
//        }
//        else if (v[hi] == To_Find) {
//            System.out.println("Found At Index " + hi );
//        }
//        else {
//            System.out.println("Not Found" );
//        }
//    }
    public static void linearSearch(int []v, int To_Find){
        for (int i = 0; i < v.length; i++) {
            if(v[i]==To_Find)
            {
                System.out.println("Found At Index " + i );
            }
        }
        System.out.println("Not Found" );
    }
    public static void main (String[] args) {

        int v[]={1, 3, 4, 5, 6};

        long f = System.nanoTime();
        linearSearch(v,6);
        long s=System.nanoTime();

        System.out.print("Total time taken by binary search in nano second :");
        System.out.print(s-f);
    }
}

