package BasicJava;

class c3{
    public int x=5;      //-->class,package,subclass,world
    protected int a=23;  //-->class,package,subclass
    int b=23;            //-->class,package
    private int c=25;    //-->class
    public void method1(){
        System.out.println(x);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
class c6 extends c3{
    public void method2() {
        System.out.println(x);
        System.out.println(a);
//        System.out.println(b);-->error
//        System.out.println(c);--->error
    }
}


//onther pakage sub class/////
class c9 extends Access_modifiers1{
    public void method6()
    {
        System.out.println(x);
        System.out.println(a);
//        System.out.println(b);-->error
//        System.out.println(c);--> error

    }
}
public class Access_modifiers {
    public static void main(String[] args) {

        c3 n = new c3();
        //same class////////
        n.method1();

        System.out.println();
        //same package-->use in all package/////
        System.out.println(n.x);
        System.out.println(n.a);
        System.out.println(n.b);
        //System.out.println(n.c);-->error

        System.out.println();
        c6 n1 = new c6();
        c9 n4 = new c9();
        //use in subclass///////
        n1.method2();
        n4.method6();

        System.out.println();
        Access_modifiers1 n2= new Access_modifiers1();
        //use in world
        System.out.println(n2.x);
    }
}

