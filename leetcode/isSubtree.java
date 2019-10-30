package leetcode;

public class isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }

        return dfs(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);

    }

    private boolean dfs(TreeNode s, TreeNode t){
        if (t == null && s==null){
            return true;
        }

        if (s == null || t == null){
            return false;
        }

        if (s.val != t.val){
            return false;
        }

        return dfs(s.right,t.right) && dfs(s.left,t.left);
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
