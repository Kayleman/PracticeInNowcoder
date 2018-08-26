package algorithm.nowcoder_algorithm;

public class test3_2 {
    public static boolean checkIdentical(TreeNode A, TreeNode B) {
        String strA = treeSerial(A);
        String strB = treeSerial(B);
        int index = KMP(strA, strB);
        if(index != -1) {
            return true;
        } else {
            return false;
        }

    }

    public static String treeSerial(TreeNode root) {
        //使用先序遍历对树进行序列化
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("#,");
            return sb.toString();
        }

        sb.append(root.val + ",");
        sb.append(treeSerial(root.left));
        sb.append(treeSerial(root.right));
        return sb.toString();
    }

    public static void calNext(String pattern, int[] next) {
        int len = pattern.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if(k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public static int KMP(String str, String pattern) {
        int i = 0;
        int j = 0;
        int sLen = str.length();
        int pLen = pattern.length();

        int[] next = new int[pattern.length()];
        calNext(pattern, next);

        while(i < sLen && j < pLen) {
            if(str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
            if(j == pLen) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        System.out.println(treeSerial(root));

    }
}
