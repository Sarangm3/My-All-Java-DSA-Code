package BasicJava;

public class Increment {
    public static void main(String[] args) {
        int a1=1,a2;
        System.out.println(a1++);//first i use and then increment
        System.out.println(a1);
        a1=1;
        System.out.println(++a1);//first increment then use
        System.out.println(a1);
        //same as
        a2=a1++;//first assing then increment
        System.out.println(a2);
        System.out.println(a1);
        a1=0;
        a2=++a1;//first increment then increment
        System.out.println(a2);
        System.out.println(a1);
        //but all time a1 are increment
    }
}
