package DSA.Graph.Topological_Sort;

//topological sort is not array sorting algorithm
//any edge u to v , u come first in sort before v in graph.
//one graph have many topological sort answer.

//so graph must be directed acyclic graph.

import java.util.*;

public class Topological_Sort_dfs {
    static void dfs(ArrayList<ArrayList<Integer>>adj,Stack<Integer> stack,boolean[]vis,int i){
        vis[i] = true;
        ArrayList<Integer> neigbors =adj.get(i);
        for(Integer neighbor : neigbors){
            if(!vis[neighbor])
                dfs(adj,stack,vis,neighbor);
        }
        stack.push(i);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>>adj  = new ArrayList<>();
        //creating graph.
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,3);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,2,1);
        addEdge(adj,3,1);
        addEdge(adj,1,4);
        addEdge(adj,5,4);
        addEdge(adj,5,1);
        boolean [] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();//store answer
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs(adj,stack,vis,i);
        }
        int [] answer = new int[V];
        int i=0;
        while(!stack.isEmpty()){
            answer[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(answer));
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
    }
}
