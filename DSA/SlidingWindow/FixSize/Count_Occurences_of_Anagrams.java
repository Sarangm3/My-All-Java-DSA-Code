package DSA.SlidingWindow.FixSize;
import java.util.*;

//both solution are valid but
// second solution is more efficient
// because use less space(one hash map )
// and less time(don't add element like first one)

// class Solution {
//     Map buildMap(String t){
//             Map<Character,Integer> m = new HashMap<>();
//             for(char ch : t.toCharArray()){
//                 int count = m.getOrDefault(ch,0);
//                 m.put(ch,count+1);
//             }
//             return m;
//         }
//     void addCharacter(Map<Character, Integer> map, Character c) {
//             int occurrences = map.getOrDefault(c, 0);
//             map.put(c, occurrences + 1);
//         }
//     int search(String pat, String txt) {
//         Map<Character,Integer> windowtxt = new HashMap<>();
//         Map<Character,Integer> requiredpat = buildMap(pat);
//         int m = txt.length();
//         int reqOcc = requiredpat.size();
//         int currOcc = 0;
//         int right = 0;
//         int ans = 0;
//         while(right<m){
//             //new element
//             char ch = txt.charAt(right);
//             addCharacter(windowtxt,ch);
//             if(requiredpat.containsKey(ch)){
//                 boolean characterFillRequirment
//                     =windowtxt.get(ch).intValue()
//                     == requiredpat.get(ch).intValue();
//                 if(characterFillRequirment){
//                     currOcc++;
//                 }
//             }
//             if(reqOcc==currOcc){
//                 ans++;
//             }
//             //old element
//             if(right>=pat.length()-1){
//                 char left = txt.charAt(right-pat.length()+1);
//                 windowtxt.put(left,windowtxt.get(left)-1);
//                 if(requiredpat.containsKey(left)){
//                     currOcc--;
//                 }
//             }
//             right++;
//         }
//         return ans;
//     }
// }


class Solution {
    int search(String s, String p) {
        int result=0;

        // Create a map of character counts for the pattern
        Map<Character, Integer> patternCounts = new HashMap<>();
        for (char c : p.toCharArray()) {
            patternCounts.put(c, patternCounts.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = patternCounts.size();
        int k = p.length();

        while (right < s.length()) {

            //remove element from map
            char c = s.charAt(right);
            if (patternCounts.containsKey(c)) {
                patternCounts.put(c, patternCounts.get(c) - 1);
                if (patternCounts.get(c) == 0) {
                    count--;
                }
            }
            right++;

            //create map again
            if (right - left > k) {
                char d = s.charAt(left);
                if (patternCounts.containsKey(d)) {
                    patternCounts.put(d, patternCounts.get(d) + 1);
                    if (patternCounts.get(d) == 1) {
                        count++;
                    }
                }
                left++;
            }

            if (count == 0) {
                result++;
            }
        }

        return result;
    }
}
public class Count_Occurences_of_Anagrams {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search("forxxorfxdofr","for"));
    }
}
