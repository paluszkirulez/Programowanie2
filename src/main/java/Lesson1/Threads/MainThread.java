package Lesson1.Threads;

public class MainThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
       // myThread2.start();
       // myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread myThread1 = new Thread(myRunnable);
        myThread1.start();

    }
}
