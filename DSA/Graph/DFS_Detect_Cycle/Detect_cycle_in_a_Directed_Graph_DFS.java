package DSA.Graph.DFS_Detect_Cycle;

import java.util.ArrayList;

public class Detect_cycle_in_a_Directed_Graph_DFS {
    static boolean isCycleD(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis [] = new boolean[v];
        boolean [] recS = new boolean[v];
        //check for all node's
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfs(i,adj,vis,recS)) return true;
            }
        }
        return false;
    }

     static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis,boolean [] recS) {
         vis[src] = true;
         recS[src] = true;
         for (Integer neighbour : adj.get(src)) {
            if(!vis[neighbour])
            {
                if(dfs(neighbour,adj,vis,recS)) return true;
            }
            else if(recS[neighbour])//check visited but in same stack or not.
            {
                return true;
            }
         }
         //there is no cycle in all node of this stack
         //so we false the value of all node in recS array
         //so remain node can understand this node is visited, but it not contains in their stack
         recS[src] = false;
         return false;
    }

    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj3.add(new ArrayList<>());
        }
        addEdgeD(adj3,0,1);
        addEdgeD(adj3,2,1);
        addEdgeD(adj3,2,3);
        addEdgeD(adj3,3,4);
        addEdgeD(adj3,4,2);
        if(isCycleD(V,adj3)) System.out.println("Graph have cycle");
        else System.out.println("Graph don't have cycle");
    }
    static void addEdgeD(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
    }
}
