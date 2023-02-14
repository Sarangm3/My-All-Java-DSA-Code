package OOPs.Collage.Practical2;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Practicale2 {
    public static void main(String[] args) {
        for(int i = 0; i<args.length; i++)
        {
            for (int j = i+1; j<args.length; j++)
            {
                //compares each elements of the array to all the remaining elements
                if(args[i].compareTo(args[j])>0)
                {
                    //swapping array elements
                    String temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]+" ");
        }
//            String exp = "3+5";
//            int a = exp.charAt(0)-48;
//            int b = exp.charAt(2)-48;
//            System.out.println(function(a,b,exp.charAt(1)));
//            for (int i = 0; i < exp.length(); i++) {
//                System.out.print(exp.charAt(i)+" ");
//            }

        }
//    static int function (int a,int b,char opt)
//    {
//        switch(opt) {
//            case '+':
//                return a+b;
//            case '-':
//                return a-b;
//            case '*':
//                return a*b;
//            case '/':
//                return a/b;
//            default:
//                return -1;
//        }
//    }
    }

