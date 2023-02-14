package OOPs.Collage.Practical3;

public class Practical_01 {
    static int Area(int l)
    {
        return l*l;
    }
    static int Area(int l,int b)
    {
        return l*b;
    }
    public static void main(String[] args) {
        System.out.print("Area of square: ");
        System.out.println(Area(3));
        System.out.print("Area of rectangle: ");
        System.out.print(Area(3,4));
    }
}
