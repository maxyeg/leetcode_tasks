package edu.leetcode.maxeg.binarytree.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left);
        };
        sb.append(val);
        sb.append(" ");
        if (right != null) {
            sb.append(right);
        };
        return sb.toString();
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
