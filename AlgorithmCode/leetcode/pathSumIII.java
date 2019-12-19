package leetcode;

public class pathSumIII {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return  res;
    }

    public void dfs(TreeNode root,int sum){
        if (root == null){
            return;
        }

        if (sum - root.val == 0) res+=1;
        dfs(root.left, sum-root.val);
        dfs(root.right, sum-root.val);
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
