package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class rangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);

        Collections.sort(arr);

        int sum = 0;
        for(Integer i:arr){
            if (i>= L && i<= R){
                sum += i;
            }
        }

        return sum;
    }

    private void inorder(TreeNode root, ArrayList<Integer> arr){
        if (root == null){
            return;
        }

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
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
