package DSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    static void margesortInPlace(int [] array,int s,int e)
    {
        if (e==s)
        {
            return;
        }
        int mid = (s+e)/2;
        margesortInPlace(array,s,mid);
        margesortInPlace(array,mid+1,e);

        margeInPlace(array,mid,s,e);

    }
    static void margeInPlace(int [] array , int mid, int s , int e)
    {
        int [] ans=new int[e-s+1];
        int i = s;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <=e ) {
            if (array[i] < array[j]) {
                ans[k] = array[i];
                i++;
            } else {
                ans[k] = array[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            ans[k] = array[i];
            k++;i++;
        }
        while(j<=e){
            ans[k] = array[j];
            k++;j++;
        }

        for (i=0 ; i<ans.length;i++)
        {
            array[s+i] = ans[i];
        }
    }

    static int [] merge( int [] array1,int [] array2)
    {
        int n = array1.length + array2.length;
        int [] ans = new int[n];
        int i1=0,i2=0;
        int i=0;
        while(i1< array1.length && i2 <array2.length ) {
            if (array1[i1] < array2[i2]) {
                ans[i] = array1[i1];
                i1++;
            } else {
                ans[i] = array2[i2];
                i2++;
            }
            i++;
        }
        while(i1 < array1.length )
        {
            ans[i]=array1[i1];
            i1++;
            i++;
        }
        while(i2 < array2.length )
        {
            ans[i]=array2[i2];
            i2++;
            i++;
        }

        return ans;
    }
    static int [] marge_sort(int [] array)
    {
        if (array.length==1)
        {
            return array;
        }
        int left[];
        int right[];
        int mid = array.length/2;
        left=marge_sort(Arrays.copyOfRange(array,0,mid));
        right=marge_sort(Arrays.copyOfRange(array,mid,array.length));

        return merge(left,right);
    }
    public static void main(String[] args) {
        int [] array  = {5,4,3,2,1};
        int [] ans = marge_sort(array);
        System.out.println(Arrays.toString(ans));
        margesortInPlace(array,0,array.length-1);
    }
}
