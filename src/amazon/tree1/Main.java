package amazon.tree1;

import java.util.Arrays;

/*
        Given the root of a binary tree, display the node values at each level.
        Node values for all levels should be displayed on separate lines.
        Let’s take a look at the below binary tree. widget Level order
        traversal for this tree should look like:
        100 50 200 25 75 350
    */
public class Main {

    public static void main(String[] argv) {
        boolean isBST = true;
        BinaryTreeNode rootBSt = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 350), isBST);
        BinaryTree.deleteNode(rootBSt, 200);
        // Tree.levelOrderTraversal(rootBSt);

        BinaryTreeNode rootTree = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 350), !isBST);
        System.out.println(Tree.isBST(rootTree, Integer.MIN_VALUE, Integer.MAX_VALUE)); // BST

        BinaryTreeNode rootTree2 = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 35), isBST);
        System.out.println(Tree.isBST(rootTree2, Integer.MIN_VALUE, Integer.MAX_VALUE)); // NOT BST
    }
}
