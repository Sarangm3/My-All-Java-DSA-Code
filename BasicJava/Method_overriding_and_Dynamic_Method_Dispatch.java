package BasicJava;

class Phone1
{
    public int num()
    {
        return 3;
    }
    public void camera()
    {
        System.out.println("camera of phone is 5mp");
    }
}
class SmartPhone1 extends Phone1
{
    @Override//symbol for we change base method or in this class method so error
    public void camera()//we rewrite old method
    {
        System.out.println("camera of phone is 108mp");
    }
    public void onPlayStore()
    {
        System.out.println("opeing play store..........");
    }

}
public class Method_overriding_and_Dynamic_Method_Dispatch {
    public static void main(String[] args) {

    Phone1 p = new Phone1();
    p.camera();

    SmartPhone1 sp = new SmartPhone1();
    sp.camera();

//    SmartPhone1 obj = new Phone1();//not possible
    Phone1 obj = new SmartPhone1();//we can use smartphone(overrindg methods only) and
        // phone mathod(all mathod (not overriding method))

    obj.camera();//make boject of phone or smartphone
        //yad rakhava mate smartphone ne phone kevay to smartphone camera avse

//        obj.onPlayStore(); //we can use smartphone method
        System.out.println("your Phone method:"+obj.num());
        //we can use phone mathod

    }
}
