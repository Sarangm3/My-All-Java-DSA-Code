package Collage.ADA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Practical_10_02 {
    static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src,int v, boolean [] visited) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(src);
        System.out.print(src);
        visited[src] = true;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            for (int i=0 ; i<adj.get(curr).size();i++)
            {
                int neighbor = adj.get(curr).get(i);
                if(visited[neighbor]==false)
                {
                    visited[neighbor] = true;
                    System.out.print(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int v = 9;
        int e = 8;
        //or useing add Edge
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj2.add(new ArrayList<>());
        }
        addEdge(adj2,1,2);
        addEdge(adj2,1,3);
        addEdge(adj2,1,4);
        addEdge(adj2,1,6);
        addEdge(adj2,2,6);
        addEdge(adj2,3,6);
        addEdge(adj2,5,6);
        addEdge(adj2,8,9);

        boolean [] visited = new boolean[v+1];

        int compnents = 0;

        for (int i = 1; i <=v; i++) {
            if(visited[i]==false){
                compnents++;
                bfs(adj2,i,v,visited);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(compnents);//find number of componets
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
