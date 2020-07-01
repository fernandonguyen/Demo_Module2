package MiddleTestModule2.Thread;

public class TestThread2 {
    static int budget = 1000;

    static class Bank {
        void getBudget(int number) throws InterruptedException {
            if (budget > 0) {
                budget -= 10;
                System.out.println(number + " budget "+budget);
               // Thread.sleep(50);
            } else {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class MyThread1 extends Thread{
        TestThread2.Bank t;
        int number;
        MyThread1(TestThread2.Bank t, int number){
            this.t=t;
            this.number = number;
        }
        public void run(){
            try {
                t.getBudget(number);
                //Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

//    static class MyThread2 extends Thread{
//        TestThread2.Bank t;
//        MyThread2(TestThread2.Bank t){
//            this.t=t;
//        }
//        public void run(){
//            try {
//                t.getBudget("Thread2");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        TestThread2.Bank table = new TestThread2.Bank();
//        MyThread1 myThread1 = new MyThread1(table);
//        MyThread2 myThread2 = new MyThread2(table);
//        myThread1.start();
//
        int count = 0;
        while (true){
            count++;
            MyThread1 myThread1 = new MyThread1(table,count);
            myThread1.start();
        }
    }
}
