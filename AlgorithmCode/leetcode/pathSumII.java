package leetcode;

import java.util.ArrayList;
import java.util.List;

public class pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>  res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        if (root == null){
            return res;
        }

        dfs(root,sum,res,temp);

        return res;
    }

    public void dfs(TreeNode root,int sum,List<List<Integer>> res,ArrayList<Integer> temp){
        if (root == null){
            return;
        }
        temp.add(root.val);

        if (root.left == null && root.right == null){
            if (root.val == sum){
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        if (root.left != null){
            dfs(root.left,sum-root.val,res,temp);
            temp.remove(temp.size()-1);
        }
        if (root.right != null){
            dfs(root.right,sum-root.val,res,temp);
            temp.remove(temp.size()-1);
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
