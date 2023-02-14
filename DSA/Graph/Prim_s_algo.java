package DSA.Graph;
import java.util.*;

class Pair1 implements Comparable<Pair1>{
    int v;
    int wt;
    Pair1(int v,int wt)
    {
        this.v = v; this.wt = wt;
    }
    public int compareTo(Pair1 ob2)
    {
        return this.wt-ob2.wt;
    }
}
class Solution1
{
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean [] vis = new boolean[V]; // so that we don't visit same node
        //so now we use PriorityQueue of Pair contain vertex and weight
        // because we want always minimum weight
        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        pq.add(new Pair1(0,0));
        int ans = 0;
        while(pq.size()>0)
        {
            Pair1 curr = pq.remove();

            if(vis[curr.v])
                continue;
            ans += curr.wt;
            ArrayList<ArrayList<Integer>> node = adj.get(curr.v);
            for(ArrayList<Integer> neighbour : node)
            {
                int vertex = neighbour.get(0);
                int wt = neighbour.get(1);

                pq.add(new Pair1(vertex,wt));
            }
            vis[curr.v] = true;
        }
        return ans;
    }
}
public class Prim_s_algo {
    public static void main(String[] args) {
        Solution1 s =new Solution1();
        int V = 3;
        int E = 3;
//        u = 0, v = 1, w = 5
//        u = 1, v = 2, w = 3
//        u = 0, v = 2, w = 1
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ArrayList<ArrayList<Integer>> list= new ArrayList<>();
            adj.add(list);
        }
        addEdge(adj,0,1,5);
        addEdge(adj,1,2,3);
        addEdge(adj,0,2,1);
        System.out.println(s.spanningTree(V,adj));
    }
    static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int source,int dest,int weight)
    {
        adj.get(source).add(new ArrayList<>(Arrays.asList(dest,weight)));
        adj.get(dest).add(new ArrayList<>(Arrays.asList(source,weight)));
    }
}
