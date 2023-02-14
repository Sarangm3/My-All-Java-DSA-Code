package DSA.Graph;

import java.sql.SQLOutput;
import java.util.*;

class Edge implements Comparable<Edge>{
    int source,des,wt;
    Edge(int s,int des,int wt){
        this.source = s;this.des = des; this.wt = wt;
    }
    public int compareTo(Edge obj2){
        return this.wt-obj2.wt;
    }
}

class Solution2
{
    static int [] p;
    static int find(int x){ //we can improve
        if(p[x]==x) return x;
        //p[x] = find(p[x]);
        return find(p[x]);
    }
    static void union(int x,int y){//we can improve by adding three condition for merging by rank
        int hx = find(x);
        int hy = find(y);
        if(hx==hy) return ;//alredy union done
        p[hy] = hx; // hy ke head ko hx banado
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean [][]vis = new boolean[V][V];
        ArrayList<Edge> edge = new ArrayList<>();
        for(int i=0; i< adj.size() ;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                ArrayList<Integer> list = adj.get(i).get(j);
                if(!vis[i][list.get(0)]){
                    vis[i][list.get(0)] = true;
                    vis[list.get(0)][i] = true;
                    edge.add(new Edge(i,list.get(0),list.get(1)));
                }
            }
        }
        //give value to p array
        p = new int[V];
        for(int i=0; i<V;i++)
        {
            p[i] = i;
        }

        int count =1;
        int ans = 0;
        Collections.sort(edge);
        for(int i= 0; count<V;i++)
        {
            int hx = find(edge.get(i).source);
            int hy = find(edge.get(i).des);
            if(hx!=hy){
                union(hx,hy);
                ans += edge.get(i).wt;
                count++;
            }
        }
        return ans;
    }
}

public class kruskal_s_algo {
    public static void main(String[] args) {
        Solution2  s = new Solution2();
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
