package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.*;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        output(lca.lowestCommonAncestor(
                constructBinaryTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4)), 5, 1
        ));
        output(lca.lowestCommonAncestor(
                constructBinaryTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4)), 5, 4
        ));
        output(lca.lowestCommonAncestor(
                constructBinaryTree(Arrays.asList(1,2)), 1, 2
        ));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode pnode = null, qnode = null;
        pnode = search(root, p);
        qnode = search(root, q);
        return lowestCommonAncestor(root, pnode, qnode);
    }

    private TreeNode search(TreeNode root, int p) {
        if (root != null) {
            if (root.val == p) {
                return root;
            } else {
                TreeNode res = search(root.left, p);
                if (res == null) res = search(root.right, p);
                return res;
            }
        } else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        search(root, p, path1);
        search(root, q, path2);
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) {
            i++;
        }
        return search(root, path1.get(i - 1));
    }

    private boolean search(TreeNode root, TreeNode p, List<Integer> path1) {
        if (root != null) {
            path1.add(root.val);
            if (root.val == p.val) {
                return true;
            } else {
                boolean left = search(root.left, p, path1), right = false;
                if (!left) {
                    right = search(root.right, p, path1);
                    if (!right) {
                        path1.remove(path1.size() - 1);
                    }
                }
                return left || right;
            }
        } else {
            return false;
        }
    }
}
