package other_algo.string;

import java.util.ArrayList;
import java.util.List;

public class _366_Find_Leaves_of_Binary_Tree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        while(root != null) {
            List<Integer> tempList = new ArrayList<>();
            root = dfs(root, tempList);
            result.add(tempList);
        }
        return result;
    }

    private TreeNode dfs(TreeNode treeNode,  List<Integer> tempList) {
        if(treeNode == null) {
            return null;
        }

        if(treeNode.left == null && treeNode.right == null) {
            tempList.add(treeNode.data);
            treeNode = null;
            return null;
        }

        treeNode.left = dfs(treeNode.left, tempList);
        treeNode.right = dfs(treeNode.right, tempList);
        return treeNode;
    }
}
