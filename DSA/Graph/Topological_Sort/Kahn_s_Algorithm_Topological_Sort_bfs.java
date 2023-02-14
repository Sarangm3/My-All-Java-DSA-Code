package DSA.Graph.Topological_Sort;

import java.util.*;

public class Kahn_s_Algorithm_Topological_Sort_bfs {
    static void bfs(ArrayList<ArrayList<Integer>> adj,int [] inDeg,int [] ans,int V)
    {
        int index=0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (inDeg[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans[index++] = curr;
            for(Integer neighbor:adj.get(curr)){
                if(--inDeg[neighbor]==0)
                    queue.add(neighbor);
            }

        }
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
        int [] inDeg = new int[V];
        for (int i = 0; i < V; i++) {

            for(Integer nbr:adj.get(i))
            {
                inDeg[nbr]++;
            }
        }
        System.out.println(Arrays.toString(inDeg));
        int [] ans = new int[V];
        bfs(adj,inDeg,ans,V);
        System.out.println(Arrays.toString(ans));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
    }
}
