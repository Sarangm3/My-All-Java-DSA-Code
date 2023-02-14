package BasicJava;

interface Bicycle{
    int a=45;//property
    void applyBrake(int decrement);
    void speedUp(int increment);
}
interface HornBicycle{

    void blowHornk3g();
    void blowHornmhn();
}

class AvonBicycle implements Bicycle,HornBicycle{ // we use more then one interface but not allow in abstract

    void blowHorn()
    {
        System.out.println("pee pep");
    }
    public void applyBrake(int decrement) //public lakhavu jaruri chhe
    {
    System.out.println("apply Break "+decrement+" done!");
    }
    public void speedUp(int increment)
    {
        System.out.println("speed Up "+increment+" done!");
    }

    public void blowHornk3g() {
        System.out.println("Kabhi khushi kabhi gum pe peee pe pee");
    }
    public void blowHornmhn()
    {
        System.out.println("main hoon naa po poo po poo ");
    }
}


//for inheritance in interfaces
    interface sampleInterfaces{
    void mathod1();
    void mathod2();
}
interface childSmapleInterfaces extends sampleInterfaces{
    void mathod3();
    void mathod4();
}
class sampleClass implements childSmapleInterfaces{

    public void mathod1()
    {
        System.out.println("mathod1");
    }
    public void mathod2()
    {
        System.out.println("mathod2");
    }
    public void mathod3()
    {
        System.out.println("mathod3");
    }
    public void mathod4()
    {
        System.out.println("mathod4");
    }
}

public class Interfaces_and_Inheritance_in_Interfaces {
    public static void main(String[] args) {

        AvonBicycle cycle1 = new AvonBicycle();

        cycle1.applyBrake(2);
        cycle1.speedUp(5);

        //You can create properties in Interfaces as they are final
        System.out.println("a="+cycle1.a);
        //you can't change the value of a becoz it's value is final
//        cycle1.a=344; --error

        cycle1.blowHorn();
        cycle1.blowHornmhn();
        cycle1.blowHornk3g();

        //for inheritance in interfaces
        sampleClass sc = new sampleClass();
        sc.mathod1();
        sc.mathod2();
        sc.mathod3();
        sc.mathod4();
    }
}
