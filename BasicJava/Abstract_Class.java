package BasicJava;

abstract class parent{// class contain any abstract mathod then class name na agad abstract lage
    public parent()
    {
        System.out.println("hello");
    }
    public void sayHallo()
    {
        System.out.println("double hello");
    }

    abstract public void greet();//ani sub class ane bharse
    abstract public void greet1();//je sub class a bane barse nete concourse class kevay

}

class child extends parent{

    @Override
    public void greet ()
    {
        System.out.println("good morning");
    }
    @Override
    public void greet1()
    {
        System.out.println("good morning guys");
    }
}

abstract class child1 extends parent//this child class or sub class don't contain abstract method
    //that why we add abstract start
{
        public void name()
    {
        System.out.println("hello");
    }
}
public class Abstract_Class {
    public static void main(String[] args) {

//        parent p = new parent();-- error abstract class object na hoy
        child c = new child();
//        child1 c1 = new child1();--error abstract class object na hoy

    }
}
