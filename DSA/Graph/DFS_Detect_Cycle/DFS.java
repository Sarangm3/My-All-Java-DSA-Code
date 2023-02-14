package DSA.Graph.DFS_Detect_Cycle;

import java.util.ArrayList;
import java.util.Arrays;
//dfs funciton is in main
//solution class have some question to solve
class Solution{
    //detect cycle in graph
    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean [] vis = new boolean[V+1];
        for (int i = 0; i < V; i++) {
            if(dfs(i,adj,vis,-1)) return true;
        }
        return false;
    }

    private boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[src] = true;
        for (Integer neighbour : adj.get(src)) {
            if (!vis[neighbour])
            {
                if(dfs(neighbour,adj,vis,src)) return true;//break recursion
            }
            else if(parent!=neighbour)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isCycleD(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis [] = new boolean[v];
        boolean [] rs = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfs(i,adj,vis,rs)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis,boolean [] rs) {
        vis[src] = true;
        rs[src] = true;
        for (Integer neighbour : adj.get(src)) {
            if(!vis[neighbour])
            {
                if(dfs(neighbour,adj,vis,rs)) return true;
            }
            else if(rs[neighbour])
            {
                return true;
            }
        }
        rs[src] = false;
        return false;
    }
}

public class DFS {
    //we can done useing stack or recurtion
    private static void     dfs(ArrayList<ArrayList<Integer>> adj, int i, int v, boolean[] visited) {
        visited[i] = true;
        System.out.print(i);
        //three mathod or more for looping
        ArrayList<Integer> neb = adj.get(i);
        for (int element : neb) {
            if(!visited[element])
            {
                dfs(adj,element,v,visited);
            }
        }
    }
    public static void main(String[] args) {


        //componets and dfs first time
        int v = 9;
        int e = 8;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
            adj1.add(new ArrayList<>());
            adj1.add(new ArrayList<>(Arrays.asList(2,3,4,6)));
            adj1.add(new ArrayList<>(Arrays.asList(1,6)));
            adj1.add(new ArrayList<>(Arrays.asList(1,4,6)));
            adj1.add(new ArrayList<>(Arrays.asList(1,3)));
            adj1.add(new ArrayList<>(Arrays.asList(6)));
            adj1.add(new ArrayList<>(Arrays.asList(1,2,3,5)));
            adj1.add(new ArrayList<>());
            adj1.add(new ArrayList<>());
            //or useing add Edge
            ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj2.add(new ArrayList<>());
            }
            addEdgeE(adj2,1,2);
            addEdgeE(adj2,1,3);
            addEdgeE(adj2,1,4);
            addEdgeE(adj2,1,6);
            addEdgeE(adj2,2,6);
            addEdgeE(adj2,3,6);
            addEdgeE(adj2,5,6);
            boolean [] visited = new boolean[v];//start useing 0
            int compnents = 0;
            for (int i = 0; i < v; i++) {
                if(visited[i]==false){
                    compnents++;
                    dfs(adj1,i,v,visited);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(compnents);//find number of componets
        //question of dfs and graph
        //cycle in no-directed graph
        Solution s = new Solution();
        int V = 5; //node v-1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdgeE(adj,0,1);
        addEdgeE(adj,0,3);
        addEdgeE(adj,2,4);
        addEdgeE(adj,2,3);
        addEdgeE(adj,3,4);
        if (s.isCycle(V,adj)) System.out.println("Graph have cycle");
        else System.out.println("Graph don't have cycle");
        //cycle in directed graph


    }
    static void addEdgeE(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
