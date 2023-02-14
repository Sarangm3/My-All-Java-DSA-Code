package OOPs.Self.A;

public class Boxweight extends Box {
    int weight;
    public Boxweight(){
        super();
        System.out.println("load weight in box");
    }
    public Boxweight (int weight,int l,int h,int w)
    {
        super(l,w,h);
        this.weight = weight;
    }
    void print(){
        System.out.println(l+""+w+h+weight);
    }
}
