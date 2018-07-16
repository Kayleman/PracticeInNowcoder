package algorithm.thread_learn;

class Thread_Demo3 extends Thread {
    private String name;
    public Thread_Demo3(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread start run!");
        for (int i = 0; i < 5; i++) {
            System.out.println("son thread " + name + " run: " + i);
            try {
                sleep((int)Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread end run!");
    }
}

// not use join()
//public class Thread_Demo3_Main {
//    public static void main(String [] args) {
//        System.out.println(Thread.currentThread().getName() + " thread start run!");
//        Thread_Demo3 Th1 = new Thread_Demo3("A");
//        Thread_Demo3 Th2 = new Thread_Demo3("B");
//        Th1.start();
//        Th2.start();
//        System.out.println(Thread.currentThread().getName() + " thread end run!");
//    }
//}

//use join()
public class Thread_Demo3_Main {
    public static void main(String [] args) {
        System.out.println(Thread.currentThread().getName() + " thread start run!");
        Thread_Demo3 Th1 = new Thread_Demo3("A");
        Thread_Demo3 Th2 = new Thread_Demo3("B");
        Th1.start();
        Th2.start();
        try {
            Th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread end run!");
    }
}
