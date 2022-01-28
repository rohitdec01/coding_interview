package leet_code.tree1;

import java.util.List;

public class BinaryTree {

    public static BinaryTreeNode create_Tree(List<Integer> list, Boolean isBst) {
        if (list.isEmpty()) {
            return null;
        }

        BinaryTreeNode binaryTreeNodeHead = null;

        for (Integer data : list) {
            if (isBst) { // BSt
                binaryTreeNodeHead = insertBST(binaryTreeNodeHead, data);
            } else { // not necessary BSt.
                binaryTreeNodeHead = insertBT(binaryTreeNodeHead, data);
            }
        }
        return binaryTreeNodeHead;
    }

    /*
        The Binary Search Tree (BST) insert is specialized use of binary tree. The concept lies behind is that all the
        element value less than the root node value insert left to the root node and the element value greater than the
        root node insert right to this root node.
     */
    private static BinaryTreeNode insertBST(BinaryTreeNode binaryTreeNode, Integer data) {
        if (binaryTreeNode == null) {
            return new BinaryTreeNode(data);
        }

        if (data < binaryTreeNode.data) {
            if (binaryTreeNode.left != null) {
                insertBST(binaryTreeNode.left, data);
            } else {
                binaryTreeNode.left = new BinaryTreeNode(data);
            }
        } else {
            if (binaryTreeNode.right != null) {
                insertBST(binaryTreeNode.right, data);
            } else {
                binaryTreeNode.right = new BinaryTreeNode(data);
            }
        }
        return binaryTreeNode;
    }

    public static BinaryTreeNode deleteNode(BinaryTreeNode root, int value) {
        if (root == null)
            return null;
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);
        } else { // got the node that has to be deleted.
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                BinaryTreeNode temp = root;
                // Finding minimum element from right
                BinaryTreeNode minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }

    // Get minimum element in binary search tree
    public static BinaryTreeNode minimumElement(BinaryTreeNode root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    /*
        Not Necessary BST but a BinaryTree
     */
    private static BinaryTreeNode insertBT(BinaryTreeNode binaryTreeNode, Integer data) {
        if (binaryTreeNode == null) {
            return new BinaryTreeNode(data);
        }

        if (binaryTreeNode.left == null) {
            binaryTreeNode.left = new BinaryTreeNode(data);
        } else if (binaryTreeNode.right == null) {
            binaryTreeNode.right = new BinaryTreeNode(data);
        } else if (binaryTreeNode.left != null) {
            insertBT(binaryTreeNode.left, data);
        } else if (binaryTreeNode.right != null) {
            insertBT(binaryTreeNode.right, data);
        }
        return binaryTreeNode;
    }

}
