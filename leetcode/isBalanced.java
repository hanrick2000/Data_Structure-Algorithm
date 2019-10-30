package leetcode;

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int left = find(root.left);
        int right = find(root.right);

        return Math.abs(left - right) <= 1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int find(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(find(root.left),find(root.right))+1;
    }

    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
