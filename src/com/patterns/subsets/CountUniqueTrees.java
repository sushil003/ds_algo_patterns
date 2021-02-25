package com.patterns.subsets;

/**
 * Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can
 * store values 1 to ‘n’.
 * Input: 2
 * Output: 2
 * Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.
 * Time complexity : O(N*2^N)
 * Space complexity : O(2^N)
 */
public class CountUniqueTrees {

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }

    public int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }
}
