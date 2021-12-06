package amazon.tree1;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    /*
        Given the root of a binary tree, display the node values at each level.
        Node values for all levels should be displayed on separate lines.
        Let’s take a look at the below binary tree. widget Level order
        traversal for this tree should look like:
        100 50 200 25 75 350
    */
    public static void levelOrderTraversal(BinaryTreeNode binaryTreeNode) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(binaryTreeNode);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.println(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    /*
        Given a Binary Tree, figure out whether it’s a Binary Search Tree.
        In a binary search tree, each node’s key value is smaller than the key
        value of all nodes in the right subtree, and are greater than the key
        values of all nodes in the left subtree i.e. L < N < RL<N<R.
    */
    public static boolean isBST(BinaryTreeNode binaryTreeNode, int min_value, int max_value) {
        if (binaryTreeNode == null) {
            return true;
        }

        if (binaryTreeNode.data < min_value || binaryTreeNode.data > max_value) {
            return false;
        }

        return isBST(binaryTreeNode.left, min_value, binaryTreeNode.data) &&
                isBST(binaryTreeNode.right, binaryTreeNode.data, max_value);
    }
}
