package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.*;

import static edu.leetcode.maxeg.utils.BigInput.ZIGZAG_LIST;
import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class ZigZagPath {

    private enum Direction {
        LEFT,
        RIGHT
    }

    public static void main(String[] args) {
        ZigZagPath zzp = new ZigZagPath();
        output(zzp.longestZigZag(constructBinaryTree(ZIGZAG_LIST)));
        output(zzp.longestZigZag(constructBinaryTree(List.of(1))));
        output(zzp.longestZigZag(constructBinaryTree(Arrays.asList(1,null,1,1,1,null,null,1,1,null,1,null,null,null,1))));
        output(zzp.longestZigZag(constructBinaryTree(Arrays.asList(1,1,1,null,1,null,null,1,1,null,1))));
    }

    public int longestZigZag(TreeNode root) {
        Map<Integer, List<TreeNode>> nodes = new HashMap<>();
        extract(root, nodes, 0);
        int height = nodes.keySet().stream().max(Integer::compareTo).get();
        int max = 0;
        for (Integer level : nodes.keySet()) {
            for (TreeNode node : nodes.get(level)) {
                max = Math.max(maxZigZag(node, null), max);
                if (max >= height - level) return max;
            }
        }
        return max;
    }

    private int maxZigZag(TreeNode node, Direction direction) {
        if (node != null) {
            if (direction == null) {
                return Math.max(maxZigZag(node.left, Direction.LEFT), maxZigZag(node.right, Direction.RIGHT));
            } else {
                if (Direction.LEFT.equals(direction)) {
                    return 1 + maxZigZag(node.right, Direction.RIGHT);
                } else {
                    return 1 + maxZigZag(node.left, Direction.LEFT);
                }
            }
        } else {
            return 0;
        }
    }

    private void extract(TreeNode root, Map<Integer, List<TreeNode>> nodes, int depth) {
        if (root != null) {
            if (!nodes.containsKey(depth)) {
                nodes.put(depth, new LinkedList<>());
            }
            nodes.get(depth).add(root);
            extract(root.left, nodes, depth + 1);
            extract(root.right, nodes, depth + 1);
        }
    }
}
