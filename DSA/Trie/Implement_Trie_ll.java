package DSA.Trie;
import java.util.* ;
import java.io.*;
class Node1{
    Node1 [] links = new Node1[26];
    int endWith = 0;
    int countPref= 0;
    Node1(){}

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch){
        links[ch - 'a'] = new Node1();
    }

    public Node1 get(char ch){
        return links[ch - 'a'];
    }

    public void setCw(){
        countPref++;
    }

    public void setEw(){
        endWith++;
    }

    public int getCw(){
        return countPref;
    }

    public int getEw(){
        return endWith;
    }
    public void drCw(){
        countPref--;
    }

    public void drEw(){
        endWith--;
    }
}
public class Implement_Trie_ll {
    private Node1 root;
    public Implement_Trie_ll() {
        root = new Node1();
    }

    public void insert(String word) {
        Node1 node1 = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node1.containsKey(ch)){
                node1.put(ch);
            }
            node1 = node1.get(ch);
            node1.setCw();
        }
        node1.setEw();
    }

    public int countWordsEqualTo(String word) {
        Node1 node1 = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node1.containsKey(ch)){
                node1.put(ch);
            }
            node1 = node1.get(ch);
        }
        return node1.getEw();
    }

    public int countWordsStartingWith(String word) {
        Node1 node1 = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node1.containsKey(ch)){
                node1 = node1.get(ch);
            }
            else return 0;
        }
        return node1.getCw();
    }

    public void erase(String word) {
        Node1 node1 = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node1.containsKey(ch)){
                node1 = node1.get(ch);
                node1.drCw();
            }
            else return;
        }
        node1.drEw();
    }
    public static void main(String args[]) {
        Implement_Trie_ll T=new Implement_Trie_ll();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");
        String word1 = "apps";
        System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith
                (word3));
        String word4 = "appl";
        System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith
                (word4));
        T.erase(word1);
        System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));

    }
}
