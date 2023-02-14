package OOPs.Collage.Practical4;
abstract class Dim {
    int dim1;
    int dim2;
    public Dim(int dim1,int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    abstract void show();
}
class Triangle extends Dim{
    public Triangle(int dim1,int dim2){
        super(dim1,dim2);
    }

    @Override
    void show() {
        System.out.println("this is class Triangle method :"+dim1+" "+dim2);
    }
}
class Rectangle extends Dim{
    public Rectangle(int dim1, int dim2) {
        super(dim1, dim2);
    }

    @Override
    void show() {
        System.out.print("this is class Rectangle method :"+dim1+" "+dim2);
    }
}

public class PracticaL_03 {
    public static void main(String[] args) {
        Triangle obj1 = new Triangle(12,6);
        Rectangle obj2 = new Rectangle(3,9);
        Dim ref;

        ref = obj1;
        ref.show();

        ref = obj2;
        ref.show();
    }
}