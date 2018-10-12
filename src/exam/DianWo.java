package exam;

public class DianWo {


    public static void main(String[] args) {
        for(int i= 0; i < 10; i++) {
            new Thread(()-> System.out.println("Hello, DWD")).start();
        }
        System.out.println("Done All DWD");
    }
}

