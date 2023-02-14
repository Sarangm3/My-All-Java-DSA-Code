package DSA.Greedy;

import java.util.*;

class Item implements Comparable<Item>{
    int weight;  int value;
    Item(int weight,int value){
        this.weight = weight;this.value=value;
    }
    public int compareTo(Item o2){
        double r1 = (double)this.value / this.weight;
        double r2 = (double)o2.value / o2.weight;
        double ans = r2-r1;
        if(ans>0)
            return 1;
        return -1;
    }
}

public class FractionalKnapsack {

    static double fractionalKnapsack(int W, Item arr[], int n)
    {
        Arrays.sort(arr);

        double ans = 0;
        for(int i = 0;i<n;i++)
        {
            if(W<arr[i].weight)
            {
                ans+= W * (1.0*arr[i].value/arr[i].weight);
                W =0;
            }
            else{
                ans += arr[i].value;
                W = W - arr[i].weight;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Item[] arr = { new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120) };

        int capacity = 50;

        double maxValue = fractionalKnapsack(capacity,arr,arr.length);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
