package leet_code.tree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /*
           Time Complexity:  O(min(N1, N2)), where N1, N2 are the lengths of root1 and root2.
           Space Complexity: O(min(H1, H2)), where H1, H2 are the heights of the trees of root1 and root2.
    */
    public boolean IsBTFlipEquivalent(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) // when null
            return true;
        if (root1 == null || root2 == null || root1.data != root2.data)
            return false;

        // check for all combination.
        return (IsBTFlipEquivalent(root1.left, root2.left) && IsBTFlipEquivalent(root1.right, root2.right) ||
                IsBTFlipEquivalent(root1.left, root2.right) && IsBTFlipEquivalent(root1.right, root2.left));
    }

    /*
        Time Complexity: O(N1+N2), where N 1,N 2 are the lengths of root1 and root2.
        Space Complexity: O(N1+N2). where H 1,H 2 are the heights of the trees of root1 and root2.)
     */
    public boolean IsBTFlipEquivalent2(BinaryTreeNode root1, BinaryTreeNode root2) {
        List<Integer> vals1 = new ArrayList();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(BinaryTreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.data);
            int L = node.left != null ? node.left.data : -1;
            int R = node.right != null ? node.right.data : -1;

            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }

            vals.add(null);
        }
    }

    public BinaryTreeNode mirror_tree(BinaryTreeNode root) {
        if (root == null) return root;
        //  post-order traversal of the binary tree.
        if (root.left != null)
            mirror_tree(root.left);

        if (root.right != null)
            mirror_tree(root.right);

        // swap the left and right nodes at current level.
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

}
