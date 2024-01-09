package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class MaxLevelSum {
    public static void main(String[] args) {
        MaxLevelSum mls = new MaxLevelSum();
        output(mls.maxLevelSum(constructBinaryTree(Arrays.asList(1,7,0,7,-8,null,null))));
        output(mls.maxLevelSum(constructBinaryTree(Arrays.asList(989,null,10250,98693,-89388,null,null,null,-32127))));
    }

    private void traverse(TreeNode node, int level, Map<Integer, Long> map) {
        if (node == null) return;
        traverse(node.left, level + 1, map);
        traverse(node.right, level + 1, map);
        if (!map.containsKey(level)) {
            map.put(level, (long) node.val);
        } else {
            map.put(level, map.get(level) + node.val);
        }
    }

    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1;
        long maxSum = root.val;
        Map<Integer, Long> map = new HashMap<>();
        traverse(root, 1, map);
        for (int level : map.keySet()) {
            if (map.get(level) > maxSum) {
                maxSum = map.get(level);
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
