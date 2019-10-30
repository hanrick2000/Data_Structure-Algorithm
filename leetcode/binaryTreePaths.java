package leetcode;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;

        dfs(root,res,"");
        return res;
    }

    public void dfs(TreeNode root, List<String> res, String s){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            res.add(s + root.val);
        }

        if (root.left != null){
            dfs(root.left,res,s+root.val + "->");
        }
        if (root.right != null){
            dfs(root.right,res,s+root.val + "->");
        }
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
