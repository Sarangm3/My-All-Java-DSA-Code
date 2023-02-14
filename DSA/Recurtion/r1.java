package DSA.Recurtion;
import java.util.Scanner;
import java.lang.String;


public class r1 {
    static boolean isPalindrome(String s,int l,int r)//l=left and r=right
    {
            if (l>=r)
            {
                return true;
            }
            if (s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            return isPalindrome(s,l+1,r-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter string:");
        String str=sc.nextLine();

        if (isPalindrome(str,0,str.length()-1))
        {
            System.out.println("string is palindrome");
        }
        else
        {
            System.out.println("string is not palindrome");
        }
    }
}
