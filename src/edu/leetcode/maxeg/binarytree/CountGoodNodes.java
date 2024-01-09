package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.Arrays;
import java.util.List;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class CountGoodNodes {
    public static void main(String[] args) {
        CountGoodNodes cgn = new CountGoodNodes();
        output(cgn.goodNodes(constructBinaryTree(Arrays.asList(2,null,4,10,8,null,null,4))));
        output(cgn.goodNodes(constructBinaryTree(Arrays.asList(3,1,4,3,null,1,5))));
        output(cgn.goodNodes(constructBinaryTree(Arrays.asList(3,3,null,4,2))));
        output(cgn.goodNodes(constructBinaryTree(List.of(1))));
    }

    public int goodNodes(TreeNode root) {
        return 1 + count(root.val, root.left) + count(root.val, root.right);
    }

    private int count(int max, TreeNode node) {
        if (node != null) {
            if (node.val >= max) {
                return 1 + count(node.val, node.left) + count(node.val, node.right);
            } else {
                return count(max, node.left) + count(max, node.right);
            }
        } else {
            return 0;
        }
    }
}
