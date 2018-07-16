package algorithm.thread_learn;

class Thread_Demo1 extends Thread{
    private String name;
    public Thread_Demo1(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " Run:" + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Thread_Demo1_Main {
    public static void main(String[] args) {
        Thread_Demo1 Th1 = new Thread_Demo1("A");
//        Thread_Demo1 Th2 = new Thread_Demo1("B");
        Thread_Demo1 Th2 = Th1;
        Th1.start();
        Th2.start();
    }
}
