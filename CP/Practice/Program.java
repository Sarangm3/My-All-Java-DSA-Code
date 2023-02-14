package CP.Practice;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        boolean flag = false;
        for (char a: str.toCharArray()) {
            if(a=='Y' || a=='E' || a=='S' || a=='e' || a=='s' || a=='y')
            {

            }
            else {
                System.out.println("NO");
                flag = true;
                break;
            }
        }
        if(!flag) System.out.println("YES");
    }
}
