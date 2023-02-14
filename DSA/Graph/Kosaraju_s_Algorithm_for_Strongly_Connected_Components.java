package DSA.Graph;
import java.util.*;

class Solution4 {
    static void dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean [] vis,Stack<Integer> ans){
        vis[node] = true;
        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(adj,nbr,vis,ans);
            }
        }
        ans.push(node);
    }
    static void finaldfs(ArrayList<ArrayList<Integer>> trps,int node,boolean[]vis){
        vis[node]=true;
        for(int nbr : trps.get(node)){
            if(!vis[nbr]){
                finaldfs(trps,nbr,vis);
            }
        }
    }
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> adj) {

        //input first arraylist for number of edge second for edges
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for(int i =0;i<v;i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i =0;i<edges.size();i++)
//        {
//            int u = edges.get(i).get(0);
//            int u1 = edges.get(i).get(1);
//
//            adj.get(u).add(u1);
//        }

        //topo. sort
        Stack<Integer> ans = new Stack<>();
        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj,i,vis,ans);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i =0;i<v;i++){
            transpose.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int nbr : adj.get(i)){
                transpose.get(nbr).add(i);
            }
        }
        int count=0;
         Arrays.fill(vis,false);

        while(!ans.empty()){
            int i = ans.pop();
            if(!vis[i]){
                count++;
                finaldfs(transpose,i,vis);
            }
        }
        return count;
    }
}
public class Kosaraju_s_Algorithm_for_Strongly_Connected_Components {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,1,4);
        addEdge(adj,1,2);
        addEdge(adj,4,0);
        addEdge(adj,2,3);
        addEdge(adj,3,2);
        Solution4 s = new Solution4();
        System.out.println(s.stronglyConnectedComponents(v,adj));
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list, int source, int dest) {
        list.get(source).add(dest);
    }
}
