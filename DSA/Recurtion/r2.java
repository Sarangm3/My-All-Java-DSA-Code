package DSA.Recurtion;

import java.util.Scanner;

public class r2 {
    static void powerset(String s,int i,String current)
    {

        if (s.length()==i)
        {
            System.out.println(current);
            return ;
        }
        powerset(s,i+1,current+s.charAt(i));
        powerset(s,i+1,current);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter string:");
        String str=sc.nextLine();
        String a=" ";
        powerset(str,0,a);
    }

}
