package DSA.binary_and_binarySearch;

import java.util.Arrays;

public class bin_in_2D {
    static int [] binarySearch2D(int [][] array,int target)
    {
        int row=0;
        int col=array[0].length-1;
        int count=0;
        while(col>=0 && row <array[0].length)
        {
            if (target==array[row][col])
            {
                System.out.println(count);
                return new int [] {row,col};
            }
            if (target>array[row][col])
            {
                row++;
            }
            else if (target<array[row][col])
            {
                col--;
            }
            count++;
        }
        System.out.println(count);
        return new int [] {-1,-1};
    }
    static int [] binarySearch2D2(int [][] array, int target){
        int s =0;
        int e = (array.length*array[0].length)-1;
        int mid;
        int row,col;
        while(s<=e)
        {
            mid = s + (e-s)/2;
            row =mid/ array.length;
            col=mid% array.length;
            if (target==array[row][col])
            {
                return new int[] {row,col};
            }
            if (target>array[row][col])
            {
                s = mid + 1;
            }
            if (target<array[row][col])
            {
                e = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int [][] array = { {10,15,20,25},
                           {26,27,28,29},
                           {30,31,36,38},
                           {39,40,44,48}};
        binarySearch2D(array,25);
        System.out.println();
        binarySearch2D2(array,25);

    }
}
