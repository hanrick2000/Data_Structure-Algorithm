package leetcode;

import java.util.ArrayList;
import java.util.List;

public class hasPathSum {
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        return dfs(root,sum);
    }

    public boolean dfs(TreeNode root, int sum){
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }

        return  dfs(root.left,sum-root.val) || dfs(root.right,sum-root.val);
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
