package OOPs;

interface camera{
    void takesnap();
    void recordvideo();
    //now some how you want method but already have many class on this interface
    //now you want add method on all class
    //that why we use "default mathod"
    private void greet(){//private method in default method onlys
        System.out.println("good moring");
    }
    default void record4kvideo()
    {
        System.out.println("recording 4k video");
        greet();
    }
}
interface wifi{
    String [] getNetworks();
    void connetToNetworks();
}

class sellphone1{
    void callNumber(int number)
    {
        System.out.println("calling"+number);
    }
    void pickCall()
    {
        System.out.println("connecting...");
    }
}

class smartphone3 extends sellphone1 implements camera,wifi
{
//    public void record4kvideo()//you can overriding default method
//    {
//        System.out.println("recording start");
//    }
    public void takesnap()
    {
        System.out.println("take snap....");
    }
    public void recordvideo()
    {
        System.out.println("video record now...");
    }

    public String [] getNetworks(){
        String [] name = {"sarang3","sachin8","hello"};
        return name;
    }
    public void connetToNetworks(){
        System.out.println("networks are connet plz wait done!..");
    }
}
public class Interfaces_Default_Methods_and_Polymorphism_in_Interfaces {
    public static void main(String[] args) {

        smartphone3 iphone = new smartphone3();

        String []n =iphone.getNetworks();
        for (String nam: n ) {
            System.out.println(nam);
        }
        iphone.record4kvideo();


        //for polymorphism...
//       camera c = new smartphone3();
//       cm.getNetworks()--->reference is monkey which does not have speak method
        // we use this for use only camera in smartphone
        System.out.println("\npolymorphism..");
        camera cm= new smartphone3();
//        cm.getNetworks();-->give me errore
        cm.record4kvideo();

    }
}
