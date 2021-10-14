package 二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-collect
 * @description: 二叉树的中序遍历
 * @author: 52Hz
 * @create: 2021-10-14 10:51
 **/
public class Solution {

    /**
     * 思路：递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        centerOrder(root, result);
        return result;
    }

    private void centerOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        centerOrder(root.left, result);
        result.add(root.val);
        centerOrder(root.right, result);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}