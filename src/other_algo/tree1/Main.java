package other_algo.tree1;

import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {
        boolean isBST = true;
        BinaryTreeNode rootBSt = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 350), isBST);
        // Tree.levelOrderTraversal(rootBSt);

        BinaryTreeNode rootTree = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 350), !isBST);
        System.out.println(Tree.isBST(rootTree, Integer.MIN_VALUE, Integer.MAX_VALUE)); // BST

        BinaryTreeNode rootTree2 = BinaryTree.create_Tree(Arrays.asList(100, 50, 200, 25, 75, 35), isBST);
        System.out.println(Tree.isBST(rootTree2, Integer.MIN_VALUE, Integer.MAX_VALUE)); // NOT BST
    }
}
