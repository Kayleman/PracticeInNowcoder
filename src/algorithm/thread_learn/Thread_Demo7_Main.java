package algorithm.thread_learn;


public class Thread_Demo7_Main implements Runnable {
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        Thread_Demo7_Main Th1 = new Thread_Demo7_Main();
        Th1.setName("world");
        Thread Th2 = new Thread(Th1);
        Th2.start();
    }
}
