package algorithm.thread_learn;

class Thread_Demo4 extends Thread {
    public Thread_Demo4(String name) {
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println("" + this.getName() + "-------" + i);
            //while i == 30 , this thread will fall back CPU to free
            if(i == 30) {
                this.yield();
            }
        }
    }
}

public class Thread_Demo4_Main {
    public static void main(String[] args) {
        Thread_Demo4 Th1 = new Thread_Demo4("A");
        Thread_Demo4 Th2 = new Thread_Demo4("B");
        Th1.start();
        Th2.start();
    }
}
