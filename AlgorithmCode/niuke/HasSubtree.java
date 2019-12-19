package niuke;

public class HasSubtree {
    public boolean HasSubtree_1(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }

        return isSubtree(root1,root2) || HasSubtree_1(root1.left,root2) || HasSubtree_1(root1.right,root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }

        if (root1.val != root2.val){
            return false;
        }

        return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
