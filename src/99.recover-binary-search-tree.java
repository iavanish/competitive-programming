/*
 * https://leetcode.com/problems/recover-binary-search-tree/
 */

public class Solution {

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode left = max(root.left);
        TreeNode right = min(root.right);
        if(left != null && right != null && root.val < left.val && right.val < root.val) {
            swap(left, right);
            return;
        }
        if(left != null && root.val < left.val) {
            swap(root, left);
            return;
        }
        if(right != null && right.val < root.val) {
            swap(root, right);
            return;
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }

    private TreeNode min(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = min(root.left);
        TreeNode right = min(root.right);
        if(left != null && right != null) {
            if(left.val < root.val && left.val < right.val) {
                return left;
            }
            else if(right.val < root.val && right.val < left.val) {
                return right;
            }
            return root;
        }
        if(left != null) {
            if(left.val < root.val) {
                return left;
            }
            return root;
        }
        if(right != null) {
            if(right.val < root.val) {
                return right;
            }
        }
        return root;
    }

    private TreeNode max(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = max(root.left);
        TreeNode right = max(root.right);
        if(left != null && right != null) {
            if(left.val > root.val && left.val > right.val) {
                return left;
            }
            else if(right.val > root.val && right.val > left.val) {
                return right;
            }
            return root;
        }
        if(left != null) {
            if(left.val > root.val) {
                return left;
            }
            return root;
        }
        if(right != null) {
            if(right.val > root.val) {
                return right;
            }
        }
        return root;
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }

}
