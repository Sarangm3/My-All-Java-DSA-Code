package BasicJava;

import java.util.Scanner;

public class runtime_error_catch {
    public static void main(String[] args) {
        int a=123;
//      int b=1-->syntax error
//        logical error logical khotu hoy to
//        runtime error
        Scanner sc = new Scanner(System.in);
        int b= sc.nextInt();
        try{
            int c = a/b;
            System.out.println(c);
        }
        catch(Exception e) {
            System.out.println("We failed to divide.Reason:");
            System.out.println(e);
        }

            //specific exception
            int [] mark = new int [3];
            mark[0]=24;
            mark[1]=65;
            mark[2]=87;
            System.out.println("enter index");
            int ind= sc.nextInt();
            System.out.println("number for divide mark");
            int num=sc.nextInt();
            try
            {
                System.out.println("your mark is:"+mark[ind]);//fix first
                System.out.println("your division is:"+mark[ind]/num);
            }
            catch(ArithmeticException e1)
            {
                System.out.println("ArithmeticException occurred!");
                System.out.println(e1);
            }
            catch(ArrayIndexOutOfBoundsException e1)
            {
                System.out.println("ArrayIndexOutOfBoundsException occurred!");
                System.out.println(e1);
            }

            catch(Exception e1)//vadarni koi problem ave to
            {
                System.out.println("some other exception occurred!");
                System.out.println(e1);
            }



            //Nested Try-Catch
            System.out.println("enter index");
            int ind1= sc.nextInt();
            try
            {
                System.out.println("any other error possible statement");
                try
                {
                    System.out.println(mark[ind1]);
                }
                catch(Exception e)
                {
                    System.out.println("sorry index not exist");
                    System.out.println("level 2 error");
                    System.out.println(e);
                }
            }
            catch(Exception e)
            {
                System.out.println("other error");
                System.out.println("level 1 error");
                System.out.println(e);
            }
        }
    }

