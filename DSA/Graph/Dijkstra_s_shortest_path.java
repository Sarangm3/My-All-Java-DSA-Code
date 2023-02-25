package DSA.Graph;

import java.util.*;

//for competition purposes we can make comparator class
// in case make two class pair for ds and comparator for compare
class Pair implements Comparable<Pair>{
    int v;
    int dis;
    Pair(int v,int dis)
    {
        this.v=v;this.dis=dis;
    }
    public int compareTo(Pair obj2){
        return this.dis- obj2.dis;
    }
}
public class Dijkstra_s_shortest_path {
    static int [] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>>adj,int S)
    {
        int [] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        //so now we use PriorityQueue of Pair contain vertex and distance
        // because we want always minimum distance
        ans[S] = 0;
        boolean []vis =new boolean[V];//for box the node.

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));

        while(pq.size()>0)
        {
            Pair cur = pq.remove();
            if(vis[cur.v])//so that we can check only one time for all nodes.
                continue;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(cur.v);
            for(ArrayList<Integer> neighbour : neighbours)
            {
                int vertex = neighbour.get(0);
                int dis = neighbour.get(1);
                if(ans[vertex]> dis+cur.dis){
                    ans[vertex] = dis+ cur.dis;
                    pq.add(new Pair(vertex,ans[vertex]));
                }
            }
            vis[cur.v] = true;
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 3;
        int E = 3;
//        u = 0, v = 1, w = 1
//        u = 1, v = 2, w = 3
//        u = 0, v = 2, w = 6
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        //first array list for different source node
        //second Arraylist store object of arraylist which is third arraylist
        //third store different dest node with weight pair

        for (int i = 0; i < V; i++) {
            ArrayList<ArrayList<Integer>> list= new ArrayList<>();
            adj.add(list);
        }
        addEdge(adj,0,1,1);
        addEdge(adj,1,2,3);
        addEdge(adj,0,2,6);
        //or quetion have ArrayList<ArrayList<Pair>>> adj///////////////////////////
        System.out.println(Arrays.toString(dijkstra(V,adj,0)));
    }
    static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int source,int dest,int weight)
    {
        //store pair of dest and weight
        adj.get(source).add(new ArrayList<>(Arrays.asList(dest,weight)));
        adj.get(dest).add(new ArrayList<>(Arrays.asList(source,weight)));
    }
}
