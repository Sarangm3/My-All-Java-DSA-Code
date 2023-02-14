package OOPs.Thread;

class MyThread extends Thread {
    int start;
    int end ;
    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }
    }
}
public class Practical_01 {

    public static void main(String[] args) {
        int range = 1000;
        int numberofthreads = range / 100;
//        System.out.println(args[0]);
//        System.out.println(args[1]);

        MyThread [] Thread = new MyThread[numberofthreads];

        for (int i = 0; i < numberofthreads; i++) {
            Thread[i] = new MyThread(i*100,i*100+100);
            Thread[i].start();
        }
    }
}

