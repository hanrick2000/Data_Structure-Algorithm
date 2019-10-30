package leetcode;

import java.util.ArrayList;
import java.util.List;

public class generateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        return generateSubTrees(1,n);
    }

    private List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (start > end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftSubTrees = generateSubTrees(start,i-1);
            List<TreeNode> rightSubTrees = generateSubTrees(i+1,end);

            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
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
