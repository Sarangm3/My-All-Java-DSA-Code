package DSA.BasicMath;
 public class a2 {
     static int count(int n){
         int count=0;
         for (int i=5;i<=n;i=i*5)
         {
             count=count + n/i;
         }
         return count;
     }

     public static void main(String[] args) {
         int n=100;
         System.out.println(count(n));
     }
 }


