package leetcode;

public class isUnivalTree {
    public int val = 0;
    public boolean isUnivalTree(TreeNode root) {
        val = root.val;

        return issame(root.left)&&issame(root.right);
    }
    public boolean issame(TreeNode node){
        if (node == null){
            return true;
        }
        if (node.val != val){
            return false;
        }


        return issame(node.left)&&issame(node.right);
    }
}
