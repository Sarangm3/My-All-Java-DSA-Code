package BasicJava;

class Circul
{
    private int R;//private is access modifiers
    private int area;
    private int perameter;

    public void setRedius(int n) {

        R=n;
    }
    public void setArea(int n) {
        area=n;
    }
    public void setperameter(int n) {
        perameter= n;
    }
    public int getRedius() {
        return R;
    }
    public int getPerameter() {
        if (area==3.14*R*2)
        {
            return perameter;
        }
        else
        {
            System.out.println("your parameter according is notcorrect");
            return 0;
        }
    }

    public int getArea() {
        if (area==(int)(3.14*R*R))
        {
            return area;
        }
        else
        {
            System.out.println("your area according Redius is not correct");
            return 0;
        }
    }
}



class Cylinder
{
   int R;
   int H;

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }
    public double Area()
    {
        return  Math.PI * R * R * H;
    }
    public double surfaceArea()
    {
        return 2*Math.PI *R * H + 2*Math.PI * R * R;
    }

}

public class CLASS {
    public static void main(String[] args) {

        Circul circul = new Circul();
//        circul.R=34 ;
//        circul.area= 3629;//thai sake nai karan ke access modifiers ma private chhe
        //ana mate getter and setter no upyog thay

        circul.setRedius(34);
        circul.setArea(3628);
        int area=circul.getArea();
        if (area!=0)
        System.out.println("your area is:"+area);

        System.out.println("\n for Cylinder:\n");
        Cylinder clnd =new Cylinder();
        clnd.setH(12);
        clnd.setR(9);

        System.out.println("Area of cylinder:"+clnd.Area());
        System.out.println("Area of cylinder:"+clnd.surfaceArea());

    }
}
