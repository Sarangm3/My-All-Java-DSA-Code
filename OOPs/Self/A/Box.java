package OOPs.Self.A;

public class Box {
    int l;
    int w;
    int h;
    public Box(){
        super();
        System.out.println("creating box");
    }
    public Box(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }
    void print(){
        System.out.println(l+""+w+h);
    }
}
