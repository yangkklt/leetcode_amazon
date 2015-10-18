/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    private TreeNode lastVisited = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVisited == null) {
            lastVisited = root;
        } else {
            if (root.val <= lastVisited.val) {
                return false;
            }
            lastVisited = root;
        }
        return isValidBST(root.right);
    }
}