package BasicJava;
import java.util.Scanner;
import java.util.SplittableRandom;

public class String_and_String_function_in_JAVA {
    public static void main(String[] args) {

        String name= "DSA";//java ma string no ek char change na thay.
        //string change na thay copy kari biji string ma stor kari string change thay
        System.out.println("your name is:" + name);
        //print like C
        System.out.printf("your string is:%s\n",name);
        Scanner s=new Scanner(System.in);
        System.out.print("enter new name:");
        name = s.nextLine();
        System.out.printf("your string is:%s\n",name);
        /////////////string function///////////////

        //for string length
        System.out.println("string length:"+name.length());

        //for all stirng in lowercase
        System.out.println(name.toLowerCase());
        //for all string in uppaercase
        System.out.println(name.toUpperCase());

        //for delete all space in string
        String new_string="          hello how are you               ";
        System.out.println(new_string.trim());

        //for substring
        System.out.println(name.substring(3));  //string 3,4,5 to end
        System.out.println(name.substring(3,5));//string index 3,4

        //for replays char
        System.out.println(name.replace('a','b'));//oldchar and newchar kya nai ave
        System.out.println(name.replace("rang","regama"));//target and replacement kya nai ave

        //for check in  your string start with this string
        System.out.println(name.startsWith("sar"));
        System.out.println(name.startsWith("Sar"));
        //for check in your string end with this string
        System.out.println(name.endsWith("rang"));
        System.out.println(name.endsWith("G"));

        //for return char which index you get
        System.out.println(name.charAt(3));
        //for check string or char in string and return index
        System.out.println(name.indexOf("ang"));//pelo char return karese
        //for check string or char from index you mention and then check after {//}or before this index
        System.out.println(name.indexOf('a',3));
        System.out.println(name.indexOf("an",1));//if not exist in string then return -1
        System.out.println(name.indexOf('e',2));
        //from{//} for last
        System.out.println(name.lastIndexOf("an"));//check from end and return your enter string first char or char index
        System.out.println(name.lastIndexOf('a',2));

        //for check string equal too entered string
        System.out.println(name.equals("DSA"));
        System.out.println(name.equals("Sarang"));
        System.out.println(name.equalsIgnoreCase("Sarang"));


        System.out.println("\"hello\"\th\n\\ono\b");
    }
}
