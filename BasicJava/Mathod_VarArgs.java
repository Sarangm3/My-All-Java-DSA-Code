package BasicJava;

public class Mathod_VarArgs {
    static int foo(int ...arry)
    {
        int sum=0;
        //know you use variable like arry
        for (int a:arry)
        {
            sum+=a;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("your number sum is:"+foo(1,3,4,5));
        System.out.println("your number sum is:"+foo(1,3));
        System.out.println("sum of nothing is:"+foo());
    }
}
