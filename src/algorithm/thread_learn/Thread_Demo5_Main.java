package algorithm.thread_learn;

//wait()

import sword_refers_to_offer.TreeNode;

import java.security.PrivateKey;

class Thread_Demo5 implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public Thread_Demo5(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class Thread_Demo5_Main {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread_Demo5 print_a = new Thread_Demo5("A", c, a);
        Thread_Demo5 print_b = new Thread_Demo5("B", a, b);
        Thread_Demo5 print_c = new Thread_Demo5("C", b, c);

        new Thread(print_a).start();
        Thread.sleep(100);  // make sure output ABC
        new Thread(print_b).start();
        Thread.sleep(100);
        new Thread(print_c).start();
        Thread.sleep(100);

    }
}
