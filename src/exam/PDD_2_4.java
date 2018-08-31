package exam;


import java.util.*;


public class PDD_2_4 {
    private static boolean isTrue = true;
    private static TreeSet<String> wordTree = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int limit = scanner.nextInt();

        List<Set<Character>> ansList = new ArrayList<>();
        Set<String> calculate = new HashSet<>();
        int i = 0;
        while (i < num) {
            String nextString = scanner.next();
            calculate.add(nextString);
            int j = 0;
            while (j < limit) {
                if (i == 0) {
                    Set<Character> littleSet = new TreeSet<>();
                    littleSet.add(nextString.charAt(j));
                    ansList.add(littleSet);
                } else {
                    ansList.get(j).add(nextString.charAt(j));
                }
                j++;
            }
            i++;
        }

        for (Character character : ansList.get(0)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(character);
            deepFirstSearch(stringBuffer, ansList, 1, calculate, limit);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (isTrue)
            System.out.println("-");
        else
            System.out.println(wordTree.first());

    }

    public static void deepFirstSearch(StringBuffer stringBuffer, List<Set<Character>> ansList,
                                       int find, Set<String> calculate, int limit) {
        if (!isTrue) {
            return;
        }
        if (find > limit)
            return;
        else if (find == limit) {
            if (!calculate.contains(stringBuffer.toString())) {
                wordTree.add(stringBuffer.toString());
                isTrue = false;
            }
        } else {
            Set<Character> set = ansList.get(find);
            for (Character character : set) {
                stringBuffer.append(character);
                deepFirstSearch(stringBuffer, ansList, find + 1, calculate, limit);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }
}