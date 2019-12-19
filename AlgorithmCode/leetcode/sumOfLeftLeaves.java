package leetcode;

import java.util.ArrayList;

public class sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null){
            return 0;
        }
        dfs(root,arr);

        int sum = 0;
        for(Integer i:arr){
            sum += i;
        }

        return sum;
    }

    private void dfs(TreeNode root, ArrayList arr){
        if (root == null){
            return;
        }

        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                arr.add(root.left.val);
            }
        }

        dfs(root.left,arr);
        dfs(root.right,arr);
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
