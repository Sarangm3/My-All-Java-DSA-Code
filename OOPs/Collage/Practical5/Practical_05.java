package OOPs.Collage.Practical5;

import java.lang.Exception;

class ExceptionClass extends Exception{
        public String toString(){
            return "Number digit is not 3";
        }
}

class Student {
    int roll_number;
    String phone_number;
    String name, address, course;

    Student(int roll, String phone, String name, String address, String course) {
        this.roll_number = roll;
        this.phone_number = phone;
        this.address = address;
        this.name = name;
        this.course = course;
    }

    public void display() throws ExceptionClass {
        int n = this.roll_number;
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        if (count == 3) {
            System.out.println("Roll_Number : " + roll_number + "\nName : "
                    + name + "\nPhone-number : " + phone_number + "\nAddress : " + address +
                    "\nCourse : " + course);
        } else {
            throw new ExceptionClass();
        }
    }
}
public class Practical_05 {
        public static void main(String args[]) throws ExceptionClass {
            Student st1=new Student(120,"9687456721","sarang","Ahmedabad","CE");
            Student st2=new Student(222,"9687450721","nischal","surat","IT");
            Student st3=new Student(3333,"9825673412","jay","rajkot","EC");

            System.out.println("Student 1:");
            st1.display();

            System.out.println("Student 2:");
            st2.display();

            System.out.println("Student 3:");
            st3.display();
        }
}

