package niuke;

public class Mirror {
    public void Mirror_1(TreeNode root) {
        if(root == null){
            return;
        }

        dfs(root);


    }

    private void dfs(TreeNode root){
        if (root == null){
            return;
        }

        if (root.left != null){
            dfs(root.left);
        }

        if (root.right != null){
            dfs(root.right);
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
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
