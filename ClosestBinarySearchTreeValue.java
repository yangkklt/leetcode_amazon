/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue {
    private static double DELTA = 0.01;
    public int closestValue(TreeNode root, double target) {
        if ((root.left == null && root.right == null) || Math.abs(root.val - target) <= DELTA) {
            return root.val;
        }
        if (root.left == null) {
            int right = closestValue(root.right, target);
            return Math.abs(root.val - target) <= Math.abs(right - target) ? root.val : right;
        }
        if (root.right == null) {
            int left = closestValue(root.left, target);
            return Math.abs(root.val - target) <= Math.abs(left - target) ? root.val : left;
        }
        int left = closestValue(root.left, target);
        int right = closestValue(root.right, target);
        double delta1 = Math.abs(left - target);
        double delta2 = Math.abs(right - target);
        double delta3 = Math.abs(root.val - target);
        if (delta1 <= delta2 && delta1 <= delta3) {
            return left;
        }
        if (delta2 <= delta1 && delta2 <= delta3) {
            return right;
        }
        return root.val;
    }
}