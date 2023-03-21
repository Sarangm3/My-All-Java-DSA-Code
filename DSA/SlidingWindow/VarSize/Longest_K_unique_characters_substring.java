package DSA.SlidingWindow.VarSize;
import java.util.*;
public class Longest_K_unique_characters_substring {

    //brut force have O(n^3) time complexity
    //O(n^2) for all possible substring and O(n) for checking this s.substring(i,j)
    //by traversing all character

    static int longestkSubstr(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, right = 0, maxLen = -1;
        while (right < s.length()) {
            char ch = s.charAt(right);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            //after while loop may be got answer
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                int count = charCount.get(leftChar);
                if (count == 1) {
                    charCount.remove(leftChar);
                } else {
                    charCount.put(leftChar, count - 1);
                }
                left++;
            }
            //check for answer or not
            if (charCount.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe",3));
    }
}
