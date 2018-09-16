package exam;



import java.util.Scanner;

public class IQYI_2_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfFood = input.nextInt();
        int numOfDay = input.nextInt();
        int numOfIndex = input.nextInt();
        int[] foodArray = new int[numOfFood];

        int i = 0;
        while (i < numOfFood) {
            foodArray[i] = input.nextInt();
            i++;
        }

        int j = 0;
        while (j<numOfDay) {
            String eatOrBuy = input.next();
            int whichDay = input.nextInt();
            if(eatOrBuy.equals("B")) {
                foodArray[whichDay-1]--;
            }else {
                if(eatOrBuy.equals("A")) {
                    foodArray[whichDay-1]++;
                }
            }
            j++;
        }
        int k = foodArray[numOfIndex-1];
        foodArray = sort1(foodArray);
        for(int index=0;index<foodArray.length;index++) {
            if(foodArray[index]==k) {
                System.out.println((index+1));
                return;
            }
        }
        return;

    }
    public static int[] sort1(int[] a) {
        int t;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length-i-1;j++) {
                if(a[j] <a[j+1]) {
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a;
    }

}