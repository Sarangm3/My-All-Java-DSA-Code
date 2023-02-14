package OOPs.Thread;

class MYTheard1 extends Thread{
    @Override
    public void run() {
        int i=0;
        while(i<300)
        {
            System.out.println("First :"+i);
            i++;
        }
    }
}
class MYTheard2 extends Thread{
    @Override
    public void run() {
        int i=0;
        while(i<300)
        {
            System.out.println("Second :"+ i);
            i++;
        }
    }
}
class thread4 implements Runnable{
    @Override
    public void run() {
        int i=0;
        while(i<300)
        {
            System.out.println("thread 4: "+i);
            i++;
        }
    }
}
public class ThreadL {
    public static void main(String[] args) {
        MYTheard1 t1 = new MYTheard1();
        MYTheard2 t2 = new MYTheard2();
        Thread t4 = new Thread(()->{
            System.out.println("Thread4");
            System.out.println(Thread.currentThread().getState());
        });
        System.out.println("start");
        t1.start();
        t2.start();
        System.out.println("hello");
        thread4 t3 = new thread4();
        Thread t3luad = new Thread(t3);
        t3luad.start();
        System.out.println(Thread.currentThread().getState());
        t4.start();
        System.out.println(Thread.currentThread().getName());


    }
}
