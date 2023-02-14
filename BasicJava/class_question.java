package BasicJava;

class Square {
    int side;
    public int area()
    {
        return side*side;
    }
    public int perimeter()
    {
        return 4*side;
    }

}

class emp
{
    int salary;
    String name;

    public int getsalary()
    {
        return salary;
    }
    public String getname()
    {
        return name;
    }
    public void setName(String s)
    {
        name=s;
    }

}
public class class_question {
    public static void main(String[] args) {
//    //problem 1
//        emp herry=new emp();
//        herry.salary=34;
//        herry.setName("code with herry");
//
//        System.out.println("salary is:"+herry.getsalary());
//        System.out.println("name is:"+herry.getname());

        //problem 2
        Square sq = new Square() ;
        sq.side=2;
        System.out.println("side is:"+sq.side);
        System.out.println("area of square is:"+sq.area());
        System.out.println("perimeter of square is:"+sq.perimeter());

    }
}
