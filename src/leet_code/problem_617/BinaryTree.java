package leet_code.problem_617;

import java.util.List;

public class BinaryTree {

    public static BinaryTreeNode create_Tree(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        BinaryTreeNode binaryTreeNodeHead = null;

        for (Integer data : list) {
                binaryTreeNodeHead = insertBT(binaryTreeNodeHead, data);
        }
        return binaryTreeNodeHead;
    }

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
