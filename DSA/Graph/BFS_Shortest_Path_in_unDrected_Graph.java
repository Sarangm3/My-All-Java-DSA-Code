package DSA.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFS_Shortest_Path_in_unDrected_Graph {
    static boolean bfs(ArrayList<ArrayList<Integer>> adj,int src,int dest,int v,boolean [] visited,int [] pred, int []dist) {
        //src,adj is mandatory
        //boolean is optional we search for dest check also

        //but we have more stuff like
        //dest - end point , v
        //pred and dist - pred for pred of last node and dist distend form src node
        //pred and dist part of bfs in most case not a dfs

        Queue<Integer> queue = new ArrayDeque<>();//store visited v
        if(src==1)//first time run only
        {
            for (int i = 0; i < v + 1; i++) {
                pred[i] = -1;
                dist[i] = Integer.MAX_VALUE;
            }
        }
        queue.add(src);
        System.out.print(src);
        visited[src] = true;
        dist[src] = 0;

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
                    dist[neighbor] = dist[curr]+1;
                    pred[neighbor] = curr;
                    queue.add(neighbor);
                    if(neighbor==dest)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int v = 9;
        int e = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2,3,4,6)));
        adj.add(new ArrayList<>(Arrays.asList(1,6)));
        adj.add(new ArrayList<>(Arrays.asList(1,4,6)));
        adj.add(new ArrayList<>(Arrays.asList(1,3)));
        adj.add(new ArrayList<>(Arrays.asList(6)));
        adj.add(new ArrayList<>(Arrays.asList(1,2,3,5)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(9)));
        adj.add(new ArrayList<>(Arrays.asList(8)));

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

        int [] pred = new int[v+1];
        int [] dist = new int[v+1];
        boolean [] visited = new boolean[v+1];

        int compnents = 0;

        for (int i = 1; i <=v; i++) {
            if(visited[i]==false){
                compnents++;
                bfs(adj,i,v,v,visited,pred,dist);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(Arrays.copyOfRange(pred,1,pred.length)));//pred of nodes
        System.out.println(Arrays.toString(Arrays.copyOfRange(dist,1,dist.length)));//dist from root(src) node
        System.out.println();
        System.out.println(compnents);//find number of componets
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
