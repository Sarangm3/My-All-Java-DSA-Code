package BasicJava;

import java.util.Scanner;

public class Java_ifelase {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("enter name:");
        String name= s.nextLine();

//        if (name.equalsIgnoreCase("sarang"))
//        {
//            System.out.println("hello sarang");
//        }


        String sarang = "hello ";
        if (sarang.charAt(0) =='h' )
            {
                System.out.println("misson is done bye");
            }

            switch (name) {
                case "DSA" -> {
                    System.out.println("hello sarang");
                    System.out.println("how are you?");
                }
                case "nischal" -> System.out.println("hello nischal");
                case "nishchal" -> {
                    System.out.println("hello nishchal");
                    System.out.println("hello nishchal");
                    System.out.println("hello nishchal");
                    System.out.println("hello nishchal");
                }
                default -> System.out.println("hello bro");
            }

        //you can use also this
//    switch(name) {
//
//        case "sarang":
//        System.out.println("hello sarang");
//        break;
//        case "nischal":
//        System.out.println("hello nischal");
//        break;
//        default:
//        System.out.println("hello bro");
//    }


        //////////Question 3/////////////this program is not true in real life/////
        long income;
        System.out.print("Enter your income:");
        income=s.nextLong();
        float tax;
        if (income<=250000)
            System.out.println("you not pay any tax and your income is:"+income);

        else if( income>250000 && income <= 500000)
        {
            tax=0.05f;
            System.out.println("your income is:"+ (income-(tax*income)));
        }
        else if( income>500000 && income <= 1000000)
        {
            tax=0.2f;
            System.out.println("your income is:"+ (income-(tax*income)));
        }
        else if( income>1000000)
        {
            tax=0.3f;
            System.out.println("your income is:"+ (income-(tax*income)));
        }


    }
    }

