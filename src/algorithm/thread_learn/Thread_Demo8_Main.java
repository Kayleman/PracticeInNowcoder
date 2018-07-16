package algorithm.thread_learn;

class Data {
    public int value = 0;
}

class Work {
    public void process(Data data, int... numbers) { //...表示不定长参数
        for (int n: numbers) {
            data.value += n;
        }
    }
}
public class Thread_Demo8_Main extends Thread{
    private Work work;
    public Thread_Demo8_Main(Work work) {
        this.work = work;
    }
    public void run() {
        java.util.Random random = new java.util.Random();
        Data data = new Data();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        work.process(data, n1, n2, n3); //回调函数
        System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+"
        + String.valueOf(n3) + "=" + data.value);
    }

    public static void main(String[] args) {
        Thread Th = new Thread_Demo8_Main(new Work());
        Th.start();
    }
}
