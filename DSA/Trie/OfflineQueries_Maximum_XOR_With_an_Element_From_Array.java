package DSA.Trie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
class Node6{
    Node6 []links = new Node6[2];
    boolean containsKey(int ind){
        return (links[ind]!=null);
    }
    void put(int ind){
        links[ind] = new Node6();
    }
    Node6 get(int ind){
        return links[ind];
    }
}
class Trie5{
    static Node6 root = null;
    Trie5(){root = new Node6();}
    void insert(int ind){
        Node6 node = root;
        for(int i=31;i>=0;i--){
            int bit = (ind>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit);
            }
            node = node.get(bit);
        }
    }

    int maxXOR(int x){
        Node6 node = root;
        int maxNum = 0;
        for(int i =31;i>=0;i--){
            int bit = (x>>i) & 1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution3 {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {

        //we add only element which is less then equl AI in trie
        //so that we convert over question in find max for x in trie
        //                                                   |
        //sort AI so that we add element according to that ---
        //but if we sort then order well loss so maintain that we creat one var
        //sort arr so that we well search in O(n) rather then O(n^2)

        //first sort queries and for order we make var
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        for(int i =0;i<queries.size();i++){
            int xi = queries.get(i).get(0);
            int ai = queries.get(i).get(1);
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(xi,ai,i));
            offlineQueries.add(list);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a ,ArrayList<Integer> b){
                return a.get(1).compareTo(b.get(1));
            }
        });
        //make array for answer
        int [] array = new int[queries.size()];

        //make try for each queries but before that we want sort arr
        Collections.sort(arr);
        Trie5 t = new Trie5();
        int j = 0;
        for(int i=0 ; i<offlineQueries.size();i++){
            while(j < arr.size() && offlineQueries.get(i).get(1) >= arr.get(j)){
                t.insert(arr.get(j));
                j++;
            }
            if(j==0){
                array[offlineQueries.get(i).get(2)] = -1;
            }
            else{
                int maxNum = t.maxXOR(offlineQueries.get(i).get(0));
                array[offlineQueries.get(i).get(2)] = maxNum;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : array) {
            result.add(num);
        }
        return result;

    }
}
public class OfflineQueries_Maximum_XOR_With_an_Element_From_Array {

}
