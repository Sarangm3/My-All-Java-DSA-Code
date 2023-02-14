package OOPs.Collage.Practical5;

import java.util.Scanner;

public class Practical_01 {
    public static void main(String[] args) {
        int a, b, c;
        double x1, x2;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter Value of a:");
            a = input.nextInt();
            System.out.println("Enter Value of b:");
            b = input.nextInt();
            System.out.println("Enter Value of c:");
            c = input.nextInt();
        }
        double D = Math.sqrt(Math.pow(b, 2) - 4 * a * c);

        try {
            x1 = (-b + D) / (2 * a);
            x2 = (-b - D) / (2 * a);
            if (a == 0)
                throw new ArithmeticException();
            System.out.println("Value of x1 is: " + x1);
            System.out.println("Value of x2 is: " + x2);
        } catch (ArithmeticException e) {
            System.out.println("a=0 is not valid, please enter another number");
        }
    }
}



