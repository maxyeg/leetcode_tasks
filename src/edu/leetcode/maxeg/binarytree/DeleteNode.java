package edu.leetcode.maxeg.binarytree;

import edu.leetcode.maxeg.binarytree.common.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static edu.leetcode.maxeg.utils.Utils.constructBinaryTree;
import static edu.leetcode.maxeg.utils.Utils.output;

public class DeleteNode {
    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        output(dn.deleteNode(constructBinaryTree(Arrays.asList(5,3,6,2,4,null,7)), 7));
        output(dn.deleteNode(constructBinaryTree(Arrays.asList(5,3,6,2,4,null,7)), 5));
        output(dn.deleteNode(constructBinaryTree(Arrays.asList(5,3,6,2,4,null,7)), 8));
        output(dn.deleteNode(constructBinaryTree(Arrays.asList(5,3,6,2,4,null,7)), 0));
        output(dn.deleteNode(constructBinaryTree(Collections.emptyList()), 0));
        output(dn.deleteNode(constructBinaryTree(List.of(0)), 0));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.left != null) {
                insert(root.left, root.right);
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        TreeNode searched = search(root, key);
        if (searched != null) {
            if (searched.left != null && searched.left.val == key) {
                TreeNode tmp = searched.left.right;
                searched.left = searched.left.left;
                insert(root, tmp);
            } else if (searched.right != null) {
                TreeNode tmp = searched.right.left;
                searched.right = searched.right.right;
                insert(root, tmp);
            }
        }
        return root;
    }

    private void insert(TreeNode root, TreeNode newNode) {
        if (newNode != null) {
            //actual insert
            TreeNode ptr = root, prev = root;
            while (ptr != null) {
                if (ptr.val > newNode.val) {
                    prev = ptr;
                    ptr = ptr.left;
                } else {
                    prev = ptr;
                    ptr = ptr.right;
                }
            }
            if (prev.val > newNode.val) {
                prev.left = new TreeNode(newNode.val);
            } else {
                prev.right = new TreeNode(newNode.val);
            }
            insert(root, newNode.left);
            insert(root, newNode.right);
        }
    }

    private TreeNode search(TreeNode node, int key) {
        if (node == null) {
            return null;
        } else if ((node.left != null && node.left.val == key) || (node.right != null && node.right.val == key)) {
            return node;
        } else {
            if (key > node.val) {
                return search(node.right, key);
            } else {
                return search(node.left, key);
            }
        }
    }
}
