package DSA.Graph.DFS_Detect_Cycle;

import java.util.ArrayList;

public class Detect_Cycle_in_Undirected_Graph_DFS {

    static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean [] vis = new boolean[V+1];
        //by changes many graph available
        //check for all but they get cycle in graph return true | (not check further)
        for (int i = 0; i < V; i++) {//                         |
            if(dfs(i,adj,vis,-1)) return true;//---------|
        }
        return false;
    }

    static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[src] = true;
        for (Integer neighbour : adj.get(src)) {
            if (!vis[neighbour])
            {
                if(dfs(neighbour,adj,vis,src)) return true;//break recursion(not check further)
            }
            else if(parent!=neighbour)
            {
                return true;
            }
        }
        //check all node if they don't get true then return false
        return false;
    }

    public static void main(String[] args) {
        int V = 5; //node v-1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdgeE(adj,0,1);
        addEdgeE(adj,0,3);
        addEdgeE(adj,2,4);
        addEdgeE(adj,2,3);
        addEdgeE(adj,3,4);
        if (isCycle(V,adj)) System.out.println("Graph have cycle");
        else System.out.println("Graph don't have cycle");
    }
    static void addEdgeE(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
