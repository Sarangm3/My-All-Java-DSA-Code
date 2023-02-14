package BasicJava;

import java.util.Scanner;

public class JAVA_04_literals {
    public static void main(String[] args) {
        byte age = 10;
        char ch = 'A';
        long num3 = 4544444444444L;
        float num1 = 10.2f;//f_or_F rakhavoj pade
        double num2 = 10.33;//d_or_D rakhi toy chale na rakhi toy chale
        boolean a = true;
        String str= "DSA";//S moto
        System.out.println("your number is" + num3);
        System.out.println("your string is:" + str + " bye");
        Scanner s = new Scanner(System.in);
        System.out.print("enter number in float:");
        float num4 = s.nextFloat();
        System.out.println(num4 % 1.1);

    }
}