package OOPs.Self.A;

public class java implements Car,Human{ // class to interface implements but intf intf we use extend
    int age;
    String name;
    int salary;
    boolean married;

    @Override
    public void carType() {
        System.out.println("sedan"); //Xuv track
    }

    @Override
    public void EngineType() {
        System.out.println("petrol");
    }

    @Override
    public void age() {
        System.out.println("0");
    }

//    public java(int age, String name, int salary, boolean married) {
//        this.age = age;
//        this.name = name;
//        this.salary = salary;
//        this.married = married;
//    }

    public static void main(String[] args) {
        System.out.println("hello");
        main2();
    }
    public  static void main2()
    {
        java obj = new java();
        System.out.println("hello2");
        obj.main(new String[0]);
    }


}
