package com.patterns.dfs;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number
 * . Find the total sum of all the numbers represented by all paths.
 * Time complexity : O(N)
 * Space complexity : O(N)
 */
public class SumOfPathNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }

    public static int findSumOfPathNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int pathVal) {

        if (root == null) {
            return 0;
        }
        pathVal = pathVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pathVal;
        }

        return dfs(root.left, pathVal) + dfs(root.right, pathVal);
    }
}
