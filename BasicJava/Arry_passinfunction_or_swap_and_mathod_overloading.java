package BasicJava;


public class Arry_passinfunction_or_swap_and_mathod_overloading {


    //for swap and show function or mathod
    static void show (int [] arry)
    {
        for (int i=0;i<arry.length;i++)
        {
            System.out.print(arry[i]+" ");

        }
        System.out.println();
    }
    static void swap(int []arry)
    {
        int temp;
        for (int i=0;i<(arry.length)/2;i++)
        {
            temp=arry[i];
            arry[i]=arry[(arry.length)-1-i];
            arry[(arry.length)-1-i]=temp;

        }

    }


    //for mathod overloading
    static void foo()
    {
        System.out.println("your welcome 0 time");
    }
    static int foo(int number)
    {
        System.out.println("your welcomea "+ number +" time");
        return 1;
    }
//    //a rite na thay
//    static void foo(int number)
//    {
//        System.out.println("your welcomea "+"number "+"time");
//    }
    public static void main(String[] args) {

        int [] arry={23,34,56,77,88,99};
        System.out.println("before swap");
        show(arry);//pass reference or address
        swap(arry);
        System.out.println("after swap");
        show(arry);
        foo();
        foo(4);

    }
}
