package OOPs.Self.A;

public class Box1 {
    public int l;
    int w;
    int h;
    public Box1(){
        super();
        System.out.println("creating box");
    }
    public Box1(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }
    void print(){
        System.out.println(l+""+w+h);
    }
}
