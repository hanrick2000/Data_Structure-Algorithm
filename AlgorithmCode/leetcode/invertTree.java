package leetcode;


public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        invert(root);
        return root;

    }

    public void invert(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invert(root.left);
        invert(root.right);
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
