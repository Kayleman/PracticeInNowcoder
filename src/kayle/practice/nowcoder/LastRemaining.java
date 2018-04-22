package kayle.practice.nowcoder;

import java.util.LinkedList;

public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }

        int outIndex = 0;
        while(list.size() > 1) {
            outIndex = (outIndex + m - 1) % list.size();
            list.remove(outIndex);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}
