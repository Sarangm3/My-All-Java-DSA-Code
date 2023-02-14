package OOPs.Collage.Practical4;

abstract class Robot {

}
class RobotA extends Robot{

}
class RobotB extends Robot implements Locomotion{
    @Override
    public void forward() {
        System.out.println("Forward of class RobotB");
    }

    @Override
    public void reverse() {
        System.out.println("Reverse of class RobotB");
    }

    @Override
    public void stop() {
        System.out.println("Stop of class RobotB");
    }
}
class RobotC extends Robot implements Locomotion,Sound{
    @Override
    public void forward() {
        System.out.println("Forward of class RobotC");
    }

    @Override
    public void reverse() {
        System.out.println("Reverse of class RobotC");
    }

    @Override
    public void stop() {
        System.out.println("Stop of class RobotC");
    }

    @Override
    public void beep() {
        System.out.print("Beep of class RobotC");
    }
}
class RobotA1 extends RobotA implements Sound{
    @Override
    public void beep() {
        System.out.println("Beep of class RobotA1");
    }
}
class RobotB1 extends RobotB implements Sound{
    @Override
    public void beep() {
        System.out.println("Beep of class RobotB1");
    }
}
class RobotB2 extends RobotB{

}
class RobotC1 extends RobotC{

}
interface Locomotion {
    void forward();
    void reverse();
    void stop();
}
interface Sound{
    void beep();
}
public class PracticaL_02 {
    //    A1,B1,C
    public static void main(String[] args) {
        RobotA1 obj1 = new RobotA1();
        RobotB1 obj2 = new RobotB1();
        RobotC obj3 = new RobotC();

        obj1.beep();
        obj2.beep();
        obj3.beep();
    }
}
