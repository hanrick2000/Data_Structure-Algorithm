package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> arr = new ArrayList<>();
        if (root == null){
            return arr;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }

            arr.add(sum/cnt);
        }
        return arr;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
