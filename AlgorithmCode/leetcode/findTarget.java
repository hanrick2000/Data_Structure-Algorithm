package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class findTarget {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == k){
                    return true;
                }
            }
        }
        return false;
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
