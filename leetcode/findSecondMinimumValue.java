package leetcode;

import java.beans.IntrospectionException;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class findSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> hashSet = new HashSet<>();

        dfs(root,hashSet);

        int min = Integer.MAX_VALUE;
        int minres = Integer.MAX_VALUE;

        if (hashSet.size() < 2){
            return -1;
        }

        for (Integer i: hashSet){
            if (minres > i){
                if (min > i){
                    minres = min;
                    min = i;
                }else {
                    minres = i;
                }
            }

        }

        return minres;
    }

    private void dfs(TreeNode root, HashSet<Integer> hashSet){
        if (root == null){
            return;
        }

        hashSet.add(root.val);

        if (root.left != null){
            dfs(root.left,hashSet);
        }

        if (root.right != null){
            dfs(root.right,hashSet);
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
