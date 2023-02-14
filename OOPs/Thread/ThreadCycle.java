package OOPs.Thread;

class MyThrad extends Thread{

    public void run(){
        System.out.println("Thread 1 ...........");
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1);
        }
    }
}
public class ThreadCycle {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i+1);
            }
        });
        t1.start();
        MyThrad t2 =new MyThrad();
        t2.start();
        System.out.println();

    }
}
