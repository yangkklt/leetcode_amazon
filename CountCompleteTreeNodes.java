/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    private int count;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 1;
        TreeNode curr = root;
        while (curr.left != null) {
            leftHeight++;
            curr = curr.left;
        }
        int rightHeight = 1;
        curr = root;
        while (curr.right != null) {
            rightHeight++;
            curr = curr.right;
        }
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}