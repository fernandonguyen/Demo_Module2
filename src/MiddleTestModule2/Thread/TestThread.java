package MiddleTestModule2.Thread;

public class TestThread {

    static class Table{
        synchronized void printTable(int n){//synchronized method
            for(int i=1;i<=5;i++){
                System.out.println(n*i);
                try{
                    Thread.sleep(400);
                }catch(Exception e){System.out.println(e);}
            }

        }
    }

    static class MyThread1 extends Thread{
        Table t;
        MyThread1(Table t){
            this.t=t;
        }
        public void run(){
            t.printTable(5);
        }

    }

    static class MyThread2 extends Thread{
        Table t;
        MyThread2(Table t){
            this.t=t;
        }
        public void run(){
            t.printTable(100);
        }
    }

    public static void main(String[] args) {
//        RunnableDemo runnable1 = new RunnableDemo("Thread 1");
//
//        RunnableDemo runnable2 = new RunnableDemo("Thread 2");
//        runnable1.start();
//        runnable2.start();
//        ThreadDemo t1 = new ThreadDemo("T1");
//        t1.start();
//        ThreadDemo t2 = new ThreadDemo("T2");
//        t2.start();

        Table table = new Table();


//        MyThread1 myThread1 = new MyThread1(table);
//        MyThread2 myThread2 = new MyThread2(table);
//        myThread1.start();
//        myThread2.start();
        Thread thread = new Thread() {
            public void run(){
                table.printTable(1);
            }
        };
        thread.start();

        Thread thread2 = new Thread() {
            public void run(){
                table.printTable(10);
            }
        };
        thread2.start();
    }
}
