package MiddleTestModule2.Thread;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ThreadDemo extends Thread{
    private Thread thread;
    private String threadName;

    ThreadDemo( String name) {
        this.threadName = name;
        System.out.println("Creating: " + name);
    }

    @Override
    public void run() {
        System.out.println("Runnig: " + threadName);
        try {
            for (int i =4 ; i > 0; i--) {
                System.out.println("Thead:" + threadName + "-" + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread:"+ threadName + " Interrupted");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (thread == null) {
            thread = new Thread (this, threadName);
            thread.start ();
        }
    }
}
