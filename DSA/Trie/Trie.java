package DSA.Trie;
class Node {
    Node [] links = new Node[26];
    boolean flag=false;
    Node(){}
    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    public void put(char ch){
        links[ch-'a'] = new Node();
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }

}
public class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    public static void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }


    public static boolean search(String word) {
        Node node = root;
        for(int i =0 ;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }



    public static boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String args[]) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}