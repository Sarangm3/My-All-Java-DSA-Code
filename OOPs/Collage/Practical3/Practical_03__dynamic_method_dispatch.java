package OOPs.Collage.Practical3;

class Students {
    int [] roll_no;
    String [] name;
    String [] city;
    int size;
    public Students(int [] roll_no,String [] name,String [] city,int size) {
        this.roll_no = roll_no;
        this.city = city;
        this.name = name;
        this.size = size;
    }
    public void Search(int roll_no){
        for (int i = 0; i < size; i++) {
            if (roll_no==this.roll_no[i])
            {
                System.out.println(roll_no+" "+name[i]+" "+city[i]);
            }
        }
    }
    public void Search(String str)
    {
        for (int i = 0; i < size; i++) {
            if (str.equals(name[i]) || str.equals(city[i]))
            {
                System.out.println(roll_no[i]+" "+name[i]+" "+city[i]);
            }
        }
    }
}
public class Practical_03__dynamic_method_dispatch {
    public static void main(String[] args) {
        int [] roll_no = {1,2,3,4,5};
        String [] name = {"Sachin","Jay","Sarang","Rahul","Harry"};
        String [] city = {"Gandhidham","Ahmedabad","Gandhidham","Rajkot","Ahmedabad"};

        Students classroom1 = new Students(roll_no,name,city, roll_no.length);
        classroom1.Search("Sarang");
        classroom1.Search(5);
    }
}
