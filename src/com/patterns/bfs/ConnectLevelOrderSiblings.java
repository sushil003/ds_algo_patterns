package com.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor. The last node of each level should
 * point to a null node.
 * Time complexity : O(N)
 * Space complexity : O(N)
 */
public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        TreeNodeBFS root = new TreeNodeBFS(12);
        root.left = new TreeNodeBFS(7);
        root.right = new TreeNodeBFS(1);
        root.left.left = new TreeNodeBFS(9);
        root.right.left = new TreeNodeBFS(10);
        root.right.right = new TreeNodeBFS(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

    public static void connect(TreeNodeBFS root) {
        if (root == null)
            return;

        Queue<TreeNodeBFS> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNodeBFS previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNodeBFS currentNode = queue.poll();
                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }
}
