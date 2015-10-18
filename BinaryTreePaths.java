/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }
    
    private void dfs(TreeNode root, String curr, List<String> res) {
        if (root == null) {
            return;
        }
        curr = curr.equals("") ? curr + root.val : curr + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(curr);
            return;
        }
        if (root.left != null) {
            dfs(root.left, curr, res);
        }
        if (root.right != null) {
            dfs(root.right, curr, res);
        }
    }
}