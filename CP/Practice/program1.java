package CP.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class program1 {
    
    public static void main(String[] args) {
        String name = "sarang";
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        for (char a:name.toCharArray()) 
        {
            if (hm.containsKey(a))
            {
                hm.put(a,(hm.get(a)+1));
            }
            else {
                hm.put(a,1);
            }
        }
        System.out.println(hm);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(23);
        list.add(23);
        list.add(23);
        System.out.println(list);
            int [] array = new int[3];
            Arrays.fill(array,-1);
        System.out.println(Arrays.toString(array));
    }
}
