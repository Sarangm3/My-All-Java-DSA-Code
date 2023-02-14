package OOPs.Collage.Practical4;

class A {
    int a;
    public A(int a){
        this.a = a;
        System.out.println("Constructor of A");
    }
}
class B extends A{
    int b; int c;
    public B(int a,int b,int c){
        super(a);
        this.b = b;
        this.c = c;
        System.out.println("Constructor of B");
    }
}
class C extends B{
    int d; int e; int f;
    public C(int a,int b,int c, int d, int e, int f){
        super(a,b,c);
        this.d = d;
        this.e = e;
        this.f = f;
        System.out.println("Constructor of C");
    }
}
class D extends C{
    public D(int a,int b,int c, int d, int e, int f){
        super(a,b,c,d,e,f);
        System.out.print("Constructor of D");
    }
}
public class PracticaL_01 {
    public static void main(String[] args) {
        D obj = new D(1,2,3,4,5,6);
    }
}
