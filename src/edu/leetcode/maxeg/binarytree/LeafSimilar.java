package edu.leetcode.maxeg.binarytree;

import java.util.*;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class LeafSimilar {
    public static void main(String[] args) {
        LeafSimilar ls = new LeafSimilar();
        output(ls.leafSimilar(
                constructBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)),
                constructBinaryTree(Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8))));
        output(ls.leafSimilar(
                constructBinaryTree(Arrays.asList(1,2,3)),
                constructBinaryTree(Arrays.asList(1,3,2))));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = traverse(root1);
        List<Integer> leafs2 = traverse(root2);
        return leafs1.equals(leafs2);
    }

    private List<Integer> traverse(TreeNode node) {
        if (node.left == null) {
            if (node.right == null) { //is leaf
                return new LinkedList<>(Collections.singleton(node.val));
            } else {
                return traverse(node.right);
            }
        } else {
            List<Integer> result = traverse(node.left);
            if (node.right != null) {
                result.addAll(traverse(node.right));
            }
            return result;
        }
    }
}
