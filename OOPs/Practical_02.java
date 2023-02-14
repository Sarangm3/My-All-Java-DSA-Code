package OOPs;

public class Practical_02 {
        static void d() throws Exception {
        }
        static void c() throws Exception {
            d();
        }
        static void b(int A[]) throws Exception {
            try {
                System.out.println(A[7]);
                c();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
        static void a(int A[]) throws Exception {
            b(A);}
        public static void main(String args[]) throws Exception {
            int A[] = { 5,2,9,4,1,14};
            a(A);}
}


