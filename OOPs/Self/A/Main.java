package OOPs.Self.A;

public class Main {
    public static void main(String[] args) {
        Boxweight obj1 = new Boxweight(1,2,3,4);
        Boxprice obj2 = new Boxprice(1,2,3,4,5);
        Box obj = new Box(2,2,2);

        Box obj3 = new Boxweight(10,20,30,40);
        System.out.println(obj3.w);
        obj3.print();//run time polymorphism
        // print Boxweight sout but in property not allow this concept of override
        //in this case Box class just check print contain by them or not(parent class:which think can excess)
        //then dynamically print of Boxweight class is run.(child class: value and method)
        //same in var

//        System.out.println(obj3.weight); not possible only contain box var but value of boxweight class

        Boxprice obj4 =new Boxprice();

        obj.print();
        System.out.println(obj.h+""+obj.l+obj.w);
        obj1.print();
        System.out.println(obj1.h+""+obj1.l+obj1.w+obj1.weight);
        obj2.print();
        System.out.println(obj2.h+""+obj2.l+obj2.w);
    }
}
