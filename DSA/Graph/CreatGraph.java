package DSA.Graph;

import java.util.ArrayList;

public class CreatGraph {
    public static void main(String[] args) {
        //we just focus on connection because value given is easy
        int v = 5;
        int e = 10;

        //undirected graph you can go both way


        //first join by Adjacency matrix
        int[][] a = new int[v + 1][v + 1];//avoid 0 simplicity
        //space O(N^2);
        //we use in dense graph
        //because very easy in oppression
        //we use this in case of va

        //second method is Adjacency List
        //here ve can use ArrayList of Linked list or
        //ArrayList of ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //we just creat arraylist point only arraylist

        for (int i = 0; i <= v; i++) {//here also we avoid 0 index for simplicity
            list.add(new ArrayList<>()); //creat all list which pointed by outer ArrayList
        }
        //space O(E+V);
        //used in spars .graph most of graph are spars graph
        //we most of time use this because realWord problem are based on this method


    }

    static void addEdge(int [][]a,int source,int dest) {
        a[source][dest] = 1;
        a[dest][source] = 1;
    }
    static void addEdge(ArrayList<ArrayList<Integer>> list,int source,int dest) {
        list.get(source).add(dest);
        list.get(dest).add(source);
    }

}
