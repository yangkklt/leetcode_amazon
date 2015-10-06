/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftChild = upsideDownBinaryTree(root.left);
        root.left = null;
        TreeNode rightMost = rightMost(leftChild);
        rightMost.right = root;
        rightMost.left = root.right;
        root.right = null;
        return leftChild;
    }
    private TreeNode rightMost(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
}