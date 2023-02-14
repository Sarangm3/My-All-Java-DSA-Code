package DSA.Heap_and_hash;

import java.util.*;

class HM
{
    HashMap<Integer,Integer> hs = new HashMap<>();
    int [] findSub(int []array,int targetSum)
    {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum + array[i] ;
            if (sum==targetSum)
            {
                return Arrays.copyOfRange(array,0,i+1);
            }
            if (hs.containsKey(sum-targetSum))
            {
                return Arrays.copyOfRange(array,hs.get(sum-targetSum)+1,i+1);
            }
            hs.put(sum,i);
        }
        return new int[]{};
    }

    int [] findEqual10Sub(int [] array)
    {
        hs.clear();
        int sum = 0;
        int [] ans = new int[2];
        ans[0]=0;
        ans[1]=-1;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==0)
            {
                array[i]=-1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i] ;
            if (sum==0)
            {
                ans[1]=i;
            }
            if (hs.containsKey(sum))
            {
                if (ans[1]-ans[0]<i-(hs.get(sum)+1))
                {
                    ans[0]=hs.get(sum)+1;
                    ans[1]=i;
                }
            }
            else
            {
                hs.put(sum,i);
            }

        }
        return ans;
    }
    List<Integer> func(int [] array,int k)
    {
        hs.clear();
        List<Integer> list = new ArrayList<>();
        int count=0;

        for (int i=0; i< array.length;i++)
        {
            if (i<k)
            {
                if (hs.containsKey(array[i]))
                {
                    hs.put(array[i],(hs.get(array[i])+1));
                }
                else
                {
                    hs.put(array[i],1);
                }
                continue;
            }
            list.add(hs.size());
            if (hs.containsKey(array[i]))
            {
                hs.put(array[i],(hs.get(array[i])+1));
            }
            else hs.put(array[i],1);
            if (hs.containsKey(array[count])&& hs.get(array[count])>1)
            {
                hs.put(array[count],hs.get(array[count])-1);
            }
            else
            {
                hs.remove(array[count]);
            }
            count++;
        }
        list.add(hs.size());
        hs.clear();
        return list;
    }
}

public class Hashmapjava {
    public static void main(String[] args) {
//        int [] array = {10,15,-5,15,-10,5};
//        //find sub array's all sum == 5
        HM h = new HM();
//        System.out.println(Arrays.toString(h.findSub(array,5)));
        int [] array1 = { 1,1,0,1,1,0,0};
        //find the largest subarray with equal number of 1 and 0
        System.out.println(Arrays.toString(h.findEqual10Sub(array1)));
        System.out.println(Arrays.toString(array1));
        int [] array2 = {1,2,2,1,3,1,1,3};
        System.out.println(h.func(array2,4));

    }
}
