package DSA.SlidingWindow.VarSize;
import java.util.*;

public class Minimum_Window_Substring {
    //O(n^2) for all possible substring and O(n) for checking this s.substring(i,j)
    //by traversing all character
    static Map buildMap(String t)   {
        Map<Character,Integer> m = new HashMap<>();
        for(char ch : t.toCharArray()){
            int count = m.getOrDefault(ch,0);
            m.put(ch,count+1);
        }
        return m;
    }
    static void addCharacter(Map<Character, Integer> map, Character c) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }

    static String minWindow(String s, String t) {
        Map<Character,Integer> windowCharacter = new HashMap<>();
        Map<Character,Integer> requiredCharacters = buildMap(t);
        int left = 0;
        int right = 0;
        int required = requiredCharacters.size();
        int currentWindow = 0;
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while(right<s.length()){
            char rightChar = s.charAt(right);
            addCharacter(windowCharacter,rightChar);

            boolean rightCharRequired=requiredCharacters.containsKey(rightChar);

            if(rightCharRequired){
                boolean characterFailsRequirement
                        =windowCharacter.get(rightChar).intValue()
                        == requiredCharacters.get(rightChar).intValue();

                if (characterFailsRequirement) {
                    currentWindow++;
                }
            }

            while(currentWindow == required  && left <= right){
                int windowSize = right - left + 1;
                char charAtLeft = s.charAt(left);
                if(minWindowLengthSeenSoFar > windowSize){
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = s.substring(left,right+1);
                }

                //we check for it remove that char
                windowCharacter.put(charAtLeft,windowCharacter.get(charAtLeft)-1);

                //know check it still worth increase left or just breack
                //a loop by checking worthness or removed element
                boolean leftCharRequired=requiredCharacters.containsKey(charAtLeft);
                if(leftCharRequired){
                    //we run loop till window < requiredment
                    boolean characterFailsRequirement
                            =windowCharacter.get(charAtLeft).intValue()
                            < requiredCharacters.get(charAtLeft).intValue();
                    if (characterFailsRequirement) {
                        currentWindow--;
                    }
                }
                left++;
            }
            right++;
        }
        return minWindow;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
