package DSA.Graph;

import java.util.*;

class Solution3 {
    void dfs(ArrayList<ArrayList<Integer>> adj,int node,int timer,int parent,int []disc,int []lowd,boolean[]vis,int []ans){
        vis[node] = true;
        disc[node] = lowd[node] = timer++;
        int child=0;//for root node articulation point check

        for (int nbr : adj.get(node)) {
            if(nbr==parent) continue;
            if(!vis[nbr]){
                dfs(adj,nbr,timer,node,disc,lowd,vis,ans);
                lowd[node] = Math.min(lowd[node],lowd[nbr]);
                if(lowd[nbr]>=disc[node] && parent!=-1){
                    ans[node] = 1;
                }
                child++;
            }
            else{
                lowd[node] = Math.min(lowd[node],disc[nbr]);
            }
        }
        if(child>1 && parent==-1)  ans[node] = 1;

    }
    void printArticulation(ArrayList<ArrayList<Integer>>adj,int v){
        boolean vis[] = new boolean[v];
        int disc[] = new int[v];
        int lowd[] = new int[v];
        int timer = 0;
        int parent =-1;
        int ans[] = new int[v];
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                dfs(adj,i,timer,parent,disc,lowd,vis,ans);
            }
        }
        for (int i = 0; i < v; i++) {
            if (ans[i]==1) {
                System.out.println(i);
            }
        }
    }
}
public class Articulation_Point_in_graph {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,3);
        addEdge(adj,0,2);
        addEdge(adj,3,5);
        addEdge(adj,3,4);
        addEdge(adj,2,1);
        Solution3 s = new Solution3();
        s.printArticulation(adj,v);
//         0-------1
//         |       |
//         |       |
//     5---3-------2
//         |
//         4
//            3 and 0 is answer
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list, int source, int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
