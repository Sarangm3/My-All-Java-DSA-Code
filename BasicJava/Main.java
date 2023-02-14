package BasicJava;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int num1,num2;
        float num3;
        Scanner sc = new Scanner(System.in);

        //print like C sort cut is souf
        //print like java sort cut is sout

//        System.out.print("enter number 1:");
//        num1= sc.nextInt();
//        System.out.print("enter number 2:");
//        num2= sc.nextInt();
//        System.out.print("enter number 3:");
//        num3= sc.nextFloat();
//
//        System.out.println(num1+num2+num3);
//
//        System.out.println("enter number:");
//        boolean b1=sc.hasNextInt();//for check for number is int for not
//        System.out.println(b1);

        System.out.print("enter string:");
        String name=sc.nextLine();//space sathe badu lese
        System.out.println("hello "+name+" how are you");//////////////////////////////////////////////////////////

        /////////////print like c///////////////////////
        System.out.printf("hello %s how are you",name);
    }
}
//cemalCase-> myNameIsSarang//function name
//pascal->    MyNameIsSarang//for class name
//normal->    my name is sarang//normal
