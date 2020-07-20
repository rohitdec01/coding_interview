package other_algo.tree1;

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
        The Binary Tree (BST) insert is specialized use of binary tree. The concept lies behind is that all the element value
        less than the root node value insert left to the root node and the element value greater than the root node insert
        right to this root node.
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
        } else if (binaryTreeNode.right == null) {
            insertBT(binaryTreeNode.right, data);
        }
        return binaryTreeNode;
    }

}
