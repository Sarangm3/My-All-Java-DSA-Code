package OOPs.Collage.Practical5;

import java.util.Scanner;
import java.lang.Exception;

public class Practical_03 {
        public static void main(String[] args) {
            int r;
            double area;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Value of Radius: ");
            try {
                r=sc.nextInt();
                if (r<0)
                    throw new ArithmeticException("Circle radius cannot be negative");
                else {
                    area = Math.PI * Math.pow(r, 2);
                    System.out.println("The Area of circle is: " + area);
                }
            }
            catch (Exception e){
                System.out.println("Please Enter only Integer Value"+e);
            }
        }
    }


