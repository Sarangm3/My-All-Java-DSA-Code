package BasicJava;

class MyMainEmployee{
    private int id;
    private String name;

    //constructor e mathod jevu hoy tenu name class nu name same hoy
    public MyMainEmployee(){
        id = 3;
        name = "Your-Name-Here";
    }//constructors for help to set value of variable

    //avirite constructors banavi pachhi object banav ti vakhate value api sakay
    public MyMainEmployee(String myName, int myId){
        id = myId;
        name = myName;
    }
    //contractor ne call na karvanu hoy te object banav ta value madijay id and name ne
    public MyMainEmployee(String myName){
        id = 1;
        name = myName;
    }
    //contractor  ne over load kari sakay
    //same name but argument alag
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setId(int i){
        this.id = i; //this. nakari toy chale
    }
    public int getId(){
        return id;
    }
}


class Rectangle{
    private int L;
    private int B;
    public Rectangle(int l, int b) {
        L = l;
        B = b;
    }

    public Rectangle() {
        L = 4;
        B = 5;
    }

    public double Area()
    {
        return L*B;
    }
    public double  surfaceArea()
    {
        return 2*(L+B);
    }

}

public class Constructors_in_Java {

    public static void main(String[] args) {
        //MyMainEmployee harry = new MyMainEmployee("ProgrammingWithHarry", 12);
        MyMainEmployee harry = new MyMainEmployee();
        //harry.setName("CodeWithHarry");
        //harry.setId(34);
        System.out.println(harry.getId());
        System.out.println(harry.getName());

        Rectangle rng =new Rectangle();
        System.out.println("\n\nfor Rectangle:");
        System.out.println("area is"+rng.Area());
        System.out.println("area is"+rng.surfaceArea());

    }
}