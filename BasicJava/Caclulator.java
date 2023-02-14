package BasicJava;
import java.util.Scanner;

public class Caclulator {
    public static void main(String[] args) {
        int num1,num2,num3,num4,num5;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter subject 1 mark:");
        num1=sc.nextInt();
        System.out.print("Enter subject 2 mark:");
        num2=sc.nextInt();
        System.out.print("Enter subject 3 mark:");
        num3=sc.nextInt();
        System.out.print("Enter subject 4 mark:");
        num4=sc.nextInt();
        System.out.print("Enter subject 5 mark:");
        num5=sc.nextInt();
        int sum=(num1+num2+num3+num4+num5)*100;
        System.out.print("your % is:");
        System.out.print((float) sum/500);
        System.out.print("%");

    }
}
