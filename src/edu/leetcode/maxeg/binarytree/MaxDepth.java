package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();
        output(md.maxDepth(constructBinaryTree(Arrays.asList(1,null,2))));
        output(md.maxDepth(constructBinaryTree(Arrays.asList(3,9,20,null,null,15,7))));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }
}
