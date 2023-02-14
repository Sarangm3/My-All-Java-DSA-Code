package BasicJava;


import java.util.Scanner;

class  Employee1{
    int id;
    int salary;
    String name;//attributes
        public void printDetails()
        {
            System.out.println("my id is:"+id);
            System.out.println("my id is:"+name);
        }
        public int getSalary()
        {
            return salary;
        }

}
public class Custom_class {
    public static void main(String[] args) {
        System.out.println("this is custom class");
        Employee1 herry = new Employee1() ;//instantiating a new Employee Object
        Employee1 john = new Employee1() ;//instantiating a new Employee Object


        //Setting Attributes
        herry.id=3;
        herry.name="herry";
        herry.salary=33;

        john.id=6;
        john.salary=9;
        john.name="john surname";

        //printing the Attributes
          herry.printDetails();
          john.printDetails();
            int salary = john.getSalary();
        System.out.println("salary of john is:"+salary);
//        System.out.println(herry.id);
//        System.out.println(herry.name)



        Scanner sc= new Scanner(System.in);
        System.out.println();
        int a= sc.nextInt();
        sc.nextLine();
        String name= sc.nextLine();

        System.out.println(a);
        System.out.println(name);

    }
}
