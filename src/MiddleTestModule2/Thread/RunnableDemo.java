package MiddleTestModule2.Thread;

public class RunnableDemo implements Runnable{
    private Thread thread;
    private String threadName;

    public RunnableDemo(String name){
        threadName = name;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        for (int i = 4; i >0 ; i--) {
            System.out.println("Thread:" + threadName + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Start:" + threadName);
        if (thread == null) {
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
