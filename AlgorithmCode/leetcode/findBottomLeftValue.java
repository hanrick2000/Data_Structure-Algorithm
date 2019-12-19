package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue {
    public int findBottomLeftValue_1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null){
                queue.add(node.right);
            }
            if (node.left != null){
                queue.add(node.left);
            }

        }
        return node.val;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
