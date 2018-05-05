package kayle.practice.nowcoder;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/*
* 题目描述:
* 请实现两个函数，分别用来序列化和反序列化二叉树
*
* 解题思路:
* 使用前序遍历来序列化二叉树，值之间用逗号分隔，null的节点用#来表示
*
* 反序列化的时候也一样，设置一个index来记录序列化的位置。
* 然后将str以逗号为分隔，分割成字符串数组，
* 初始化节点为null，如果序列值不为#，则新建node节点，并且为左右孩子反序列化
* */
public class SerializeDeserializeTree {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len) {
            return null;
        }

        String[] strArray = str.split(",");
        TreeNode node = null;
        if(!strArray[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}