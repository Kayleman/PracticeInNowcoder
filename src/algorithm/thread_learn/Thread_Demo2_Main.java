package algorithm.thread_learn;

class Thread_Demo2 implements Runnable {
    private String name;
    public Thread_Demo2(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " Run:" + i);
            try {
                Thread.sleep((int) Math.random() *10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Thread_Demo2_Main {
    public static void main(String[] args) {
        new Thread(new Thread_Demo2("C")).start();
        new Thread(new Thread_Demo2("D")).start();
    }
}
