package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class PathsSum3 {
    public static void main(String[] args) {
        PathsSum3 pathsSum3 = new PathsSum3();
        output(pathsSum3.pathSum(constructBinaryTree(Arrays.asList(1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000)), 0));
        output(pathsSum3.pathSum(constructBinaryTree(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1)), 8));
        output(pathsSum3.pathSum(constructBinaryTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1)), 22));
    }

    public int pathSum(TreeNode root, int targetSum) {
        List<TreeNode> nodes = new LinkedList<>();
        extract(root, nodes);
        int result = 0;
        for (TreeNode node : nodes) {
            result += count(node, targetSum);
        }
        return result;
    }

    private void extract(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            nodes.add(root);
            extract(root.left, nodes);
            extract(root.right, nodes);
        }
    }

    private int count(TreeNode root, long targetSum) {
        int result = 0;
        if (root != null) {
            if (root.val == targetSum) {
                result++;
            }
            result += count(root.left, targetSum - root.val);
            result += count(root.right, targetSum - root.val);
        }
        return result;
    }
}
