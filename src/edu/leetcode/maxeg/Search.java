package edu.leetcode.maxeg;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.Arrays;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class Search {
    public static void main(String[] args) {
        Search s = new Search();
        output(s.searchBST(constructBinaryTree(Arrays.asList(4,2,7,1,3)), 2));
        output(s.searchBST(constructBinaryTree(Arrays.asList(4,2,7,1,3)), 5));
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
