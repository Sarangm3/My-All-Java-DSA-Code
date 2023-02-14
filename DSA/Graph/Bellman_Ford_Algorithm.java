package DSA.Graph;
import java.util.* ;
import java.io.*;
class Solution5 {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int [] dis = new int[n+1];
        Arrays.fill(dis,1000000000);
        dis[src] = 0;
        for(int i=1 ; i < n;i++){
            for(int j=0 ; j<m;j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt= edges.get(j).get(2);
                if(dis[u]!=1000000000 && (dis[u]+wt)<dis[v]){
                    dis[v] = dis[u] + wt;
                }
            }
        }
        boolean flag = false;
        for(int j=0 ; j<m;j++){
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt= edges.get(j).get(2);
            if(dis[u]!=1000000000 && (dis[u]+wt)<dis[v]){
                flag = true;
            }
        }
        if(flag)
            return -1;
        return dis[dest];
    }

}


public class Bellman_Ford_Algorithm {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        int [][] edges1 = {{1,2,4},{1,3,3},{2,4,7},{3,4,-2}};
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add(new Integer(edges1[i][j]));
            }
            edges.add(list);
        }
        System.out.println(s.bellmonFord(4,4,1,4,edges));
    }
}
