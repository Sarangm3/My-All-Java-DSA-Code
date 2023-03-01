package DSA.Trie;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
class Node5{
    Node5 []links = new Node5[2];
    Node5(){}
    boolean containsKey(int ind){
        return (links[ind]!=null);
    }
    void put(int ind){
        links[ind] = new Node5();
    }
    Node5 get(int ind){
        return links[ind] ;
    }
}
class Trie4 {
    static private Node5 root = null;
    Trie4 (){root = new Node5();}
    void insert(int number){
        Node5 node = root;
        for(int i = 31 ; i>=0;i--){
            int bit = (number>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit);
            }
            node = node.get(bit);
        }
    }
    int getMax(int num){
        int maxNum = 0;
        Node5 node = root;
        for(int i=31;i>=0;i--){
            int bit = num>>i&1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | 1<<i;
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution2 {
    public int findMaximumXOR(int[] nums) {
        Trie4 t = new Trie4();
        for(int i=0;i<nums.length;i++){
            t.insert(nums[i]);
        }
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int maxNum =t.getMax(nums[i]);
            if(ans<maxNum){
                ans = maxNum;
            }
        }
        return ans;
    }
}
public class Maximum_XOR_of_Two_Numbers_in_an_Array {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
