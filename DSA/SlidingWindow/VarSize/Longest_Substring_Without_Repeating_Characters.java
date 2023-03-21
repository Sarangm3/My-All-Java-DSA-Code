package DSA.SlidingWindow.VarSize;
import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {
    static int lengthOfLongestSubstring(String s) {
        int maxi = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        //you can use right var
        for(char ch : s.toCharArray()){
            //after while loop may be got answer
            //because if one duplicate element come
            //we don't got answer till front duplicate element was removed
            while(!set.isEmpty() && set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            //check for answer
            maxi = Math.max(maxi,set.size());
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
