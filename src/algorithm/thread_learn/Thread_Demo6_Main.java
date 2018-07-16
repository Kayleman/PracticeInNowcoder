package algorithm.thread_learn;

public class Thread_Demo6_Main extends Thread{
    private String name;
    public Thread_Demo6_Main(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        Thread Th = new Thread_Demo6_Main("world");
        Th.start();
    }
}
