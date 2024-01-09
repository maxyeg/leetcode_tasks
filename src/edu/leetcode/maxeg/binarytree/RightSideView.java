package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class RightSideView {
    public static void main(String[] args) {
        RightSideView rsv = new RightSideView();
        output(rsv.rightSideView(constructBinaryTree(Arrays.asList(1,2,3,null,5,null,4))));
        output(rsv.rightSideView(constructBinaryTree(Arrays.asList(1,null,3))));
        output(rsv.rightSideView(constructBinaryTree(Arrays.asList())));
        output(rsv.rightSideView(constructBinaryTree(Arrays.asList(1,2))));
    }

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, 1, map);
        list.addAll(map.values());
        return list;
    }

    private void traverse(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node == null) return;
        traverse(node.left, level + 1, map);
        traverse(node.right, level + 1, map);
        map.put(level, node.val);
    }
}
