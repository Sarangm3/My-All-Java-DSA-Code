package DSA.Heap_and_hash;

import java.util.PriorityQueue;

class PQ{
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k_th_largest(int [] array,int k)
    {
        for (int i=0;i<k;i++)
        {
            q.add(array[i]);
        }
        for (int i=k;i< array.length;i++)
        {
            if (array[i]>q.peek()){
                q.poll();
                q.add(array[i]);
            }
        }
        return q.peek();
    }
    int N_ropes(int [] array)
    {
        q.clear();
        int sum = 0;
        int ans = 0;
        for (int i=0;i< array.length;i++) {
            q.add(array[i]);

            if (i == 0) {
                continue;
            }
        }
        while (q.size()>1)
        {
            int num1 = q.poll();
            int num2 = q.poll();
            sum = num1+num2;
            ans +=sum;
            q.add(sum);
        }
        return ans;
    }
}
public class Heap__PriorityQueue_concept__{
    public static void main(String[] args) {
        int [] array = {20,10,60,30,50,40};
        PQ c = new PQ();
        System.out.println(c.k_th_largest(array,3));
        int [] array2 = {2,5,4,8,6,9};
        System.out.println(c.N_ropes(array2));
    }
}
