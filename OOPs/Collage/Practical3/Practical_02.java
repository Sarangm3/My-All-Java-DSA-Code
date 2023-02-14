package OOPs.Collage.Practical3;

class Area{
    public Area(int l)
    {
        System.out.println(l*l);
    }
    public Area(int l,int b)
    {
        System.out.println(l*b);
    }
}
public class Practical_02 {

    public static void main(String[] args) {
        System.out.print("Area of square: ");
        Area square = new Area(3);

        System.out.print("Area of rectangle: ");
        Area rectangle = new Area(3,4);
    }
}
