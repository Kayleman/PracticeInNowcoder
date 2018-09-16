package exam;

import java.util.Date;

public class Example extends Date{
    private static final long serialVersionUID = 1L;
    private void fun() {
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new Example().fun();
    }
}
