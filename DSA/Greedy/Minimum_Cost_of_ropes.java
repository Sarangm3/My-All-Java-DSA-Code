package DSA.Greedy;

import java.util.PriorityQueue;

public class Minimum_Cost_of_ropes {
    static long  minCost(long arr[], int n)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);
        }

        long cost = 0;
        while(pq.size()>1)
        {
            long first = pq.poll();
            long second = pq.poll();

            long lengthR = first + second;
            cost += lengthR;
            pq.add(lengthR);
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new long[]{4,3,2,6},4));
    }
}
