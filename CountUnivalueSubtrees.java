/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        return helper(root).num;
    }
    
    private Res helper(TreeNode root) {
        if (root == null) {
            return new Res(0, true);
        }
        if (root.left == null && root.right == null) {
            return new Res(1, true);
        }
        if (root.left == null) {
            Res right = helper(root.right);
            return root.val == root.right.val && right.areSame ? new Res(helper(root.right).num + 1, true) : new Res(helper(root.right).num, false);
        }
        if (root.right == null) {
            Res left = helper(root.left);
            return root.val == root.left.val && left.areSame ? new Res(helper(root.left).num + 1, true) : new Res(helper(root.left).num, false);
        }
        Res left = helper(root.left);
        Res right = helper(root.right);
        return (root.val == root.left.val && root.val == root.right.val && left.areSame && right.areSame) ? new Res(left.num + right.num + 1, true) : new Res(left.num + right.num, false);        
    }
    
    class Res {
        int num;
        boolean areSame;
        public Res() {
            num = 0;
            areSame = true;
        }
        public Res(int num, boolean areSame) {
            this.num = num;
            this.areSame = areSame;
        }
    }
}