package exam;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DD_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] min_m = new int[m];
        List<Integer> list = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++){
            int temp = scanner.nextInt();
            list.add(i, temp);
        }




        while (m -- > 0){
            min = Collections.min(list);
            int min_index = list.indexOf(min);
            int count = 0;
            if(min_index == 0) {
                count = list.get(0) + list.get(1);
                list.set(0,count);
                list.remove(1);
            } else if(min_index == list.size() - 1) {
                count = list.get(min_index - 1) + list.get(min_index);
                list.set(min_index,count);
                list.remove(min_index - 1);
            } else {
                if(list.get(min_index - 1) > list.get(min_index + 1)) {
                    count = list.get(min_index) + list.get(min_index + 1);
                    list.set(min_index,count);
                    list.remove(min_index + 1);
                } else {
                    count = list.get(min_index) + list.get(min_index - 1);
                    list.set(min_index,count);
                    list.remove(min_index - 1);
                }
            }


        }
        System.out.println(Collections.min(list));

    }
}