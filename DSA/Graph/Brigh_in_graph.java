package DSA.Graph;

import java.util.*;

class Solution {

    static void dfs (List<List<Integer>> adj, int curr, int timer, int[]dis, int []lowd, boolean []vis, int parent, List<List<Integer>> ans)
    {
        vis[curr] = true;
        dis[curr] = lowd[curr] =timer++;

        for(int neighbour : adj.get(curr)){
            if(!vis[neighbour]){
                dfs(adj,neighbour,timer,dis,lowd,vis,curr,ans);
                lowd[curr] = Math.min(lowd[curr],lowd[neighbour]);
                if(lowd[neighbour]>dis[curr]){
                    ans.add(new ArrayList<>(Arrays.asList(curr,neighbour)));
                }
            }else{
                if(parent==neighbour){
                    continue;
                }
                lowd[curr] = Math.min(lowd[curr],dis[neighbour]);
            }

        }
    }
    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i< v;i++){
            List<Integer> node = new ArrayList<>();
            adj.add(node);
        }
        for(int i=0; i<edges.length;i++){
            int u = edges[i][0];
            int u1 = edges[i][1];
            adj.get(u).add(u1);
            adj.get(u1).add(u);
        }

        int [] disc = new int[v];
        int [] lowd = new int[v];
        boolean [] vis = new boolean[v];
        int parent=-1;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<v;i++){
            disc[i]= -1;
            lowd[i] = -1;
        }
        for(int i=0; i<v;i++){
            if(!vis[i]){
                dfs(adj,i,0,disc,lowd,vis,parent,ans);
            }
        }
        return ans;
    }
}
public class Brigh_in_graph {
    public static void main(String[] args) {

        int [][] edges = {{5,4},{0,1},{3,1},{1,2},{3,4}};
        int [][] edges1 = {{4,3},{0,1},{1,2},{2,3},{1,2}};
        int [][] edges2 = {{1,4},{1,5},{2,4},{4,5},{3,0},{6,3},{6,7},{7,8},{8,2}};
        int [][] edges3 = {{0,1},{0,2},{0,3},{1,2},{3,4}};
        Solution s = new Solution();
        System.out.println(s.findBridges(edges,6,edges.length));
        System.out.println(s.findBridges(edges1,6,edges.length));
        System.out.println(s.findBridges(edges2,9, edges2.length));
        System.out.println(s.findBridges(edges3,5, edges3.length));
    }
}


