package DSA.Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Cmp implements Comparator<Job>
{
public int compare(Job o1,Job o2){
        return o2.profit - o1.profit;
}
}
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
class Solution2
{
    //Function to find the maximum profit and the number of jobs done.

    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new Cmp());
        int maxi = 0;
        for(int i=0;i<n;i++)
        {
            maxi = Math.max(maxi,arr[i].deadline);
        }

        int [] dline = new int[maxi+1];
        Arrays.fill(dline,-1);

        int maxProfit = 0;
        int maxJob = 0;

        for(int i=0;i<n;i++)
        {
            for(int k = arr[i].deadline;k>0;k--)
            {
                if(dline[k]==-1)
                {
                    maxProfit += arr[i].profit;
                    dline[k] = arr[i].id;
                    maxJob++;
                    break;
                }
            }
        }
        return new int[]{maxJob,maxProfit};
    }
}
public class JobScheduling {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        Job [] arr = new Job[4];
        arr[0] = new Job(1,4,20);
        arr[1] = new Job(2,1,10);
        arr[2] = new Job(3,1,40);
        arr[3] = new Job(4,1,30);

        System.out.println(Arrays.toString(s.JobScheduling(arr,4)));
    }
}
