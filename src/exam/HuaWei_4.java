package exam;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuaWei_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] allRight = new int[4];
        int[] halfRight = new int[4];
        while (scanner.hasNextInt()){
            for(int i = 0; i < 4; i++) {
                allRight[i] = scanner.nextInt();
            }

            for(int i = 0; i < 4; i++){
                halfRight[i] = scanner.nextInt();
            }
            int allRightNum = 0;
            int halfRightNum = 0;
            List Arest = new ArrayList();
            List Brest = new ArrayList();
            for(int i = 0; i < 4; i++){
                if (allRight[i] == halfRight[i]){
                    allRightNum ++;
                }else{
                    Arest.add(allRight[i]);
                    Brest.add(halfRight[i]);
                }
            }
            for (int i = 0; i < Brest.size(); i++){
                if (Arest.contains(Brest.get(i))){
                    halfRightNum ++;
                }
            }

            System.out.println(allRightNum + "A" + halfRightNum + "B");
        }
    }
}
