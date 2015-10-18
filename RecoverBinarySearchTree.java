/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    private TreeNode lastVisited;
    private TreeNode first;
    private TreeNode second;
    public void recoverTree(TreeNode root) {
        lastVisited = null;
        first = null;
        second = null;
        helper(root);
        if (first != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left);
        }
        if (lastVisited == null) {
            lastVisited = root;
        } else {
            if (root.val <= lastVisited.val) {
                if (first == null) {
                    first = lastVisited;
                }
                second = root;
            }
        }
        lastVisited = root;
        helper(root.right);
    }
}