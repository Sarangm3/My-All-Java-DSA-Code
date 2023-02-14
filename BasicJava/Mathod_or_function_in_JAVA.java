package BasicJava;

public class Mathod_or_function_in_JAVA {
    static int func1(int x,int y)//a and b ni copy thay chhe
    //static ma koi object na banavo pade
            //main static chhe tethi static main ma static mathod upyog thay che
    {
        int z;
        if (x>y)
        {
            z=x+y;
        }
        else
        {
            z=(x+y)*5;
        }
        return z;
    }

    public static void main(String[] args) {
        int a,b;
        a=2;b=4;

//        //jyare mathod ma static na hoy tyare//
//        object banavu pade like
//        Mathod_or_function_in_JAVA obj= new Mathod_or_function_in_JAVA();
//        System.out.println(obj.func1(a,b));

        System.out.println(func1(a,b));

    }
}
