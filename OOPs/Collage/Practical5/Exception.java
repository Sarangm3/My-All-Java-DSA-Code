package OOPs.Collage.Practical5;

public class Exception {

    public static void main(String[] args) {

        //ArithmeticException
        try{
            int num = 100/0;
        }
        catch (ArithmeticException e)
        {
            System.out.println(e);
        }

        //ArrayIndexOutOfBoundsException
        try
        {
            int [] a = new int[5];
            a[100] = 34;
        }
        catch (ArrayIndexOutOfBoundsException xyz)
        {
            System.out.println(xyz);
        }
        int [] array = new int[10];
//        insertAtIndex(array,-1,23);
    }
//    static void insertAtIndex(int [] array,int i, int num) throws Exception
//    {
//        if(i<0)
//        {
//            throw new Exception("index is less then 0 don't exist in array");
//        }
//    }

}
