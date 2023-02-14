package OOPs.Collage.Extra;

import java.util.Arrays;
import java.util.Scanner;
class reper{
    int val;

    public reper(int val) {
        this.val = val;
    }
}
public class main {
    static int num4;
    static void sum(){
        System.out.println("sarang2343");
    }
    static int x = 34;
    static void sum(int s){
        System.out.println("sarang"+s);
    }
    public static void main(String[] args) {
        System.out.println(x);
        int x = 45;
        System.out.println(x);
        System.out.println("hello");
        Scanner s = new Scanner(System.in);
        System.out.print("enter input: ");
        int num = s.nextInt();
        System.out.println("this in output:"+num);
        System.out.println("કેમ છો");
        int mkj;
//        int @sarang;
//        int $sarnag;
//        int ^darang;
//        int &sarang;
//        int _sarabg;
//        int lol;
//        int skljd#;
//        int skjhfd@;
//        int aslkdfj_sadfjjsf;
//        int xyz$;
//        int @sarang;
        int $sarang = 34;
        int _sarnag = 45;
        int num1 = 03434;
        int num2 = 0x1f34;
        int num3 = 0b1101010000101010;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        int number = 23;
        double number1 = 34.3;
        double number2 = number;
        System.out.println((int)number1);
        System.out.println(number2);
        String name = "Sarang";
                if(name == "Sarang")  System.out.println("hello");
        String name1 = new String("sarang");
                if(name == name1)     System.out.println("jlol;");

//        int &sarnag;

        System.out.println($sarang);
        System.out.println(Math.floor(34.32432));
        sum();
        sum(34);
        //System is class
        //out is reference variable
        //out refers PrintStream
        //PrintStream class object is out
        //println method of PrintStream class
        Integer a =23;
        function1(a);
        reper r = new reper(23);
        System.out.println(a);
        System.out.println(r.val);
        function2(r);
        System.out.println(r.val);
        fuc();
//        String sout;
//        System.out.println(sout);
        System.out.println(num4);
    }
    static void fuc(String ...v)
    {
        System.out.println(Arrays.toString(v));
    }
    static void function1(Integer b){
        b = 45;
    }
    static void function2(reper r1){
        r1.val = 90;
    }
}
