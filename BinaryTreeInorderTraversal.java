/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal {
	// Morris
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode link = null;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                link = curr.left;
                while (link.right != null && link.right.val != curr.val) {
                    link = link.right;
                }
                if (link.right == null) {
                    link.right = curr;
                    curr = curr.left;
                } else {
                    res.add(curr.val);
                    link.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }


	// using stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
}