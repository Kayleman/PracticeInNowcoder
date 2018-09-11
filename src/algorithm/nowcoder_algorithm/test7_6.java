package algorithm.nowcoder_algorithm;

public class test7_6 {
    public String treeToString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#");
            sb.append("!");
            return;
        } else {
            sb.append(root.val);
            sb.append("!");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }
}
