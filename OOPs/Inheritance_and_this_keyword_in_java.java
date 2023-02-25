package OOPs;

class phone
{
    public int x;

    public int getX() {
        return x;
    }

    public void setX(int x) //int x is this.x
    {
        //answer at starting part
        /////////////////////////|/////////this.////////////////////////
        this.x = x;//if not use  |this then compiler confused and print 0
        //this means we say that |x of this mathod(function)
    }
}

class smartPhone extends phone
{
    public int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}



//FOR CONSTRUCTORS OF INHERITANCE
class Animal
{
    public Animal()
    {
        System.out.println("i am constructor of animal");
    }
    //overload constructor
    Animal(int x)
    {
        System.out.println("i am constructor of animal and x is :"+x);
    }

}
class Dog extends Animal
{
    Dog()
    {
        super(4);
        System.out.println("this construct of dog with Animal");
    }
    Dog(int x,int y)
    {
        super (x);//this argument of x give animal construct(int any) contain int any = x
        System.out.println("this construct of dog and y is :"+y);
    }
}
class Bulldog extends Dog
{
    Bulldog()
    {
        System.out.println("this construct of bulldog ");
    }
    Bulldog(int x,int y,int z)
    {
        super(x,y);
        System.out.println("this construct of bulldog and value of z is:"+z);
    }
}
public class Inheritance_and_this_keyword_in_java {
    public static void main(String[] args) {


        //creating an object of phone
        phone p = new phone();
        p.setX(369);
//        p.setY(3454); skya nathi karan ke phone ma smartphone function and variable na hoy
        System.out.println(p.getX());


        System.out.println();
        //creating an object of smartphone
        smartPhone sp = new smartPhone();
        sp.setX(3);
        sp.setY(45);//smartphone undar phone and smartphone bane na function and variable hoy
        System.out.println(sp.getX());
        System.out.println(sp.getY());




        //code for constructor
        System.out.println("\n\nfor constructor:\n");

        //for animal
//        Animal animl = new Animal();
        Animal animl = new Animal(3);

        //for dog
        Dog D = new Dog();
//        Dog D = new Dog(6);

        //for bulldog
        System.out.println();
        Bulldog bdog= new Bulldog(12,13,14);
        //this constructor start at Bull dog and read super() and go
        //out side bull dog class and find super(arg)argument in parent class
        //know parent class = dog na constructor ne open kar se
        //dog na constructor super () joi ne super in argument ne teni parent class
        //= animal na constructor jeni koi argument hoy tene print karse pachhi
        //dog constructor read thase last ma bull dog no


    }
}
