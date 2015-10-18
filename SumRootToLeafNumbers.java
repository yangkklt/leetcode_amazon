/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int currRes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += currRes * 10 + root.val;
            return;
        }
        if (root.left != null) {
            helper(root.left, currRes * 10 + root.val);
        }
        if (root.right != null) {
            helper(root.right, currRes * 10 + root.val);
        }
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int currRes) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return currRes * 10 + root.val;
        }
        return sumNumbers(root.left, currRes * 10 + root.val) + sumNumbers(root.right, currRes * 10 + root.val);
    }
}