package leetcode;

public class searchBST {
    public TreeNode searchBST_1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode res = null;
        res = findSubTree(root,val);
        return res;

    }

    private TreeNode findSubTree(TreeNode root,int val){
        if (root == null){
            return null;
        }

        if (root.val == val){
            return root;
        }else if (root.val < val){
            return findSubTree(root.right,val);
        }else {
            return findSubTree(root.left,val);
        }

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
