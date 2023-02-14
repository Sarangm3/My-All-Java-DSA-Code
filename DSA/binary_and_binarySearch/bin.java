package DSA.binary_and_binarySearch;
import java.util.Arrays;

public class bin {

    static int [] searchRange(int [] array , int target)    {
        int s = 0;
        int e = array.length-1;
        int mid;
        int num1=-1;
        int num2 =-1;
        int [] ans = {-1,-1};
        while(s<=e)
        {
            mid = s+ (e-s)/2;
            if (target>array[mid])
            {
                s= mid+1;
            }
            else if (target<array[mid])
            {
                e = mid-1;
            }
            else
            {
                num1 = mid ;
                e = mid-1;
            }
        }
        //or you make onther function for while loop
        s=0;
        e=array.length-1;
        while(s<=e)
        {
            mid = s+ (e-s)/2;
            if (target>array[mid])
            {
                s= mid+1;
            }
            else if (target<array[mid])
            {
                e = mid-1;
            }
            else
            {
                num2 = mid ;
                s = mid+1;
            }
        }
        ans[0]=num1;
        ans[1] =num2;

        return ans;
    }
    static char nextGreatestLetter(char[] letters, char target)    {

        int s=0;
        int e = letters.length-1;
        int m;
        if(target>letters[e])
        {
            return '0';
        }
        boolean asc = letters[s]<letters[e];
        while(s<=e)
        {
            m = s +(e-s)/2;

            if(asc)
            {
                if(target>=letters[m])
                {
                    s=m+1;
                }
                else
                {
                    e=m-1;
                }
            }
            else{
                if(target<=letters[m])
                {
                    s=m+1;
                }
                else
                {
                    e=m-1;
                }
            }
        }
        return letters[s];

    }
    static int infiniteBinarySearch(int [] array,int target)    {
            int start = 0;
        int end = 1;
        while(target>array[end])
        {
            int temp_start = end+1;
            end = end + (end - start + 1) *2;
            start = temp_start;
        }
        return binarySearch(array,target,start,end);
    }
    static int peekIndexOfMountain(int []arr)    {
        int s = 0;
        int e = arr.length-1;
        int mid;
        while(s<e) // s = e = mid
        {
            mid = s + (e-s)/2;

            if (arr[mid]>=arr[mid+1])
            {
                // we in dec order
                e = mid ;// bcoz e may answer
            }
            else
            {
                // we in asc order
                s = mid+1;
            }
        }
        return s;
    }
    static int findPivot(int []arr)    {
        int s = 0;
        int e = arr.length-1;
        int mid ;
        while(s<=e)
        {
            mid= s + (e-s)/2;
            if (mid<e && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            if (s<mid && arr[mid]<arr[mid-1])
            {
                return mid-1;
            }
            if (arr[s]>=arr[mid])
            {
                e = mid-1;
            }
            if (arr[s]<arr[mid])
            {
                s = mid +1;
            }
        }
        return -1;
    }
    static int findPivotWithDuplicates(int []arr)    {
        int s = 0;
        int e = arr.length-1;
        int mid ;
        while(s<=e)
        {
            mid= s + (e-s)/2;
            if (mid<e && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            if (s<mid && arr[mid]<arr[mid-1])
            {
                return mid-1;
            }
            if (arr[s]==arr[mid] && arr[mid]==arr[e])
            {
                if (arr[s]>arr[s+1]){
                    return s;
                }
                s++;
                if (arr[e]<arr[e-1])
                {
                    return e-1;
                }
                e--;
            }
            else if (arr[s]>arr[mid] || (arr[s]==arr[mid] && arr[mid] < arr[e]))
            {
                e = mid-1;
            }
            else
            {
                s= mid+1;
            }
        }
        return -1;
    }
    static int splitArrayMaxValue(int [] array,int m)    {
        int start=0;
        int end=0;
        int mid;
        int piecess,sum;
        for (int i = 0; i < array.length; i++) {
            start = Math.max(array[i],start);//max number in array
            end = end + array[i];
        }
        if (m==1)
        {
            return end;
        }
        if (m==array.length)
        {
            return start;
        }
        while (start<end)
        {
            mid= start + (end-start)/2;
            piecess=1;
            sum=0;
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
                if (sum > mid) {
                    sum = array[i];
                    piecess++;
                }
            }
            if(piecess<=m)
            {
                end = mid;
            }
            else
            {
               start = mid +1;
            }
        }
        return start;
    }
    static int binarySearch(int [] array,int target,int s,int e)    {

        int m ;
        boolean asc = array[s]<array[e];
        while(s<=e)
        {
            m=s+(e-s)/2;// we use (s+e)/2 but it might exide int rage because sum
            if (target==array[m])
            {
                return m;
            }
            if(asc)
            {
                if(target>=array[m])
                {
                    s=m+1;
                }
                else
                {
                    e=m-1;
                }
            }
            else{
                if(target<=array[m])
                {
                    s=m+1;
                }
                else
                {
                    e=m-1;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args)    {
    int array [] ={1,4,5,7,10,11,15,25,30,33,39,43,45,49,50,51};
    //             0 1 2 3  4 5  6  7  8  9  10 11 12 13 14 15
        Arrays.sort(array);
        System.out.println(binarySearch(array,33,0,array.length-1));
        char chara  [] ={'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(chara,'c'));
        int [] que = {3,6,7,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(que,7)));
        int [] arr = {2,4,6,8,10,12};
        System.out.println(infiniteBinarySearch(arr,10));
        int [] arr1 = {1};
        System.out.println(peekIndexOfMountain(arr1));
        System.out.println(arr1[peekIndexOfMountain(arr1)]);
        int [] arr2 = {0,2,3,4,5,6};
                    //0 1  2 3 4 5 6 7 8 9 10111213141516171819202122
        System.out.println(findPivot(arr2)+1);//count how many time array routed
//        System.out.println(findPivotWithDuplicates(arr2));
        int [] arr3 ={1,2,3,4,5};
        System.out.println(splitArrayMaxValue(arr3,2));

    }
}
