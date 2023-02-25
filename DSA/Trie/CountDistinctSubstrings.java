package DSA.Trie;
import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
class Node4{
    Node4 [] links = new Node4[26];
    Node4(){}

    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    void put(char ch){
        links[ch - 'a'] = new Node4();
    }

    Node4 get(char ch){
        return links[ch - 'a'];
    }

}
class Trie3{
    static Node4 root;
    int count;
    Trie3(){
        root = new Node4();
    }
    void insert(String word){
        Node4 node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch);
                count++;
            }
            node = node.get(ch);
        }
    }
}
public class CountDistinctSubstrings
{

    public static int countDistinctSubstrings(String s)
    {
        Trie3 t = new Trie3();
        for(int i = 0;i<s.length();i++){
            t.insert(s.substring(i,s.length()));
        }
        int ans = t.count + 1;
        return ans;
    }
}
