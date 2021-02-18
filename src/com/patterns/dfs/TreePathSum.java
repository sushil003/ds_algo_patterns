package com.patterns.dfs;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of
 * all the node values of that path equals ‘S’.
 * Time complexity : O(N)
 * Space complexity : O(N)
 */
public class TreePathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.val == sum && root.left == null && root.right == null)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
}
