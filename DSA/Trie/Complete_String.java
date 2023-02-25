package DSA.Trie;
import java.util.* ;
import java.io.*;

//https://www.codingninjas.com/codestudio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
class Node3{
    Node3 [] links =  new Node3[26];
    boolean flag = false;
    Node3(){}

    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    public void put(char ch){
        links[ch-'a'] = new Node3();
    }

    public Node3 get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean getFlag(){
        return flag;
    }
}
class Trie2{
    private Node3 root;
    Trie2(){
        root = new Node3();
    }
    void insert(String word){
        Node3 node3 = root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            if(!node3.containsKey(ch)){
                node3.put(ch);
            }
            node3 = node3.get(ch);
        }
        node3.setEnd();
    }
    boolean isCompleteString(String word){
        Node3 node3 = root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            node3 = node3.get(ch);
            if(!node3.getFlag()){
                return false;
            }
        }
        return true;
    }
}
class Solution {

    public static String completeString(int n, String[] a) {
        Trie2 t = new Trie2();
        for(int i=0;i<n;i++){
            t.insert(a[i]);
        }
        String longest = "";
        for (int i = 0; i < n; i++) {
            if(t.isCompleteString(a[i])){
                if(a[i].length() > longest.length()){
                    longest = a[i];
                }
                else if(a[i].length()==longest.length() && a[i].compareTo(longest) < 0){
                    longest = a[i];
                }
            }
        }
        if(longest == "") return "None";
        return longest;
    }
}