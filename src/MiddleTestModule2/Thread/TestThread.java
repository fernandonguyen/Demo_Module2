package MiddleTestModule2.Thread;

public class TestThread {
    public static void main(String[] args) {
//        RunnableDemo runnable1 = new RunnableDemo("Thread 1");
//        runnable1.start();
//        RunnableDemo runnable2 = new RunnableDemo("Thread 2");
//        runnable2.start();
        ThreadDemo t1 = new ThreadDemo("T1");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("T2");
        t2.start();
    }
}
