package Collage.ADA;


import java.util.ArrayList;

public class Practical_10_01 {
    private static void     dfs(ArrayList<ArrayList<Integer>> adj, int i, int v, boolean[] visited) {
        visited[i] = true;
        System.out.print(i);
        ArrayList<Integer> neb = adj.get(i);
        for (int element : neb) {
            if(!visited[element])
            {
                dfs(adj,element,v,visited);
            }
        }
    }
    public static void main(String[] args) {
        int v = 9;
        int e = 8;
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
                dfs(adj2,i,v,visited);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(compnents);
    }
    static void addEdgeE(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
}
