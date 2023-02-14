package OOPs.Collage.Practical5;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Practical_04{

    public static void main(String[] args) {

        int a[] = new int[10];
        int a1[] = new int[10];
        int a2[] = new int[10];
        int index, i;

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the value of 10 integer:");
            for (i = 0; i < a.length; i++)
                a[i] = input.nextInt();
            System.out.println("Array:");

            for (i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println("\nEnter index no Which you want to divide the array:");
            try {
                index = input.nextInt();

                for (i = 0; i < index; i++)
                    a1[i] = a[i];
                System.out.println("Array1:");

                for (i = 0; i < index; i++)
                    System.out.print(a1[i] + " ");


                for (i = index; i < a.length; i++)
                    a2[i] = a[i];
                System.out.println("\nArray2:");

                for (i = index; i < a.length; i++)
                    System.out.print(a2[i] + " ");

            } catch (InputMismatchException |
                    ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
    }
}

