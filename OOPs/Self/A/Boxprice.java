package OOPs.Self.A;

public class Boxprice extends Boxweight {
    int price;
    public Boxprice()
    {
        super();
        System.out.println("giveing price for box");
    }
    public Boxprice(int price,int weight,int l,int h,int w)
    {
        super(weight,l,h,w);

        this.price=price;
    }
    void print(){
        System.out.println(""+l+""+w+""+h+""+weight+price);
    }
}
