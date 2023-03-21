package DSA.SlidingWindow.VarSize;
import java.util.*;
public class Fruit_Into_Baskets {
    //904 leetcode
    //https://leetcode.com/problems/fruit-into-baskets/description/
    //same as logest k unique character just little modification

    //brut force same as longest k unique character
    static int longestkSubstr(int [] s, int k) {
        Map<Integer, Integer> charCount = new HashMap<>();
        int left = 0, right = 0, maxLen = -1;
        while (right < s.length) {
            int num = s[right];
            charCount.put(num, charCount.getOrDefault(num, 0) + 1);
            //after while loop may be got answer
            while (charCount.size() > k) {
                int leftInt = s[left];
                int count = charCount.get(leftInt);
                if (count == 1) {
                    charCount.remove(leftInt);
                } else {
                    charCount.put(leftInt, count - 1);
                }
                left++;
            }
            //check for answer or not
            //here
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
    static int totalFruit(int[] fruits) {
        //here
        return longestkSubstr(fruits,2);
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,1}));
    }
}

