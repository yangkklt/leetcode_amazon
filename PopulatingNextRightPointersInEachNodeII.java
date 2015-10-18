/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode leftMost = root;
        while (leftMost != null) {
            TreeLinkNode previous = leftMost;
            while (previous != null && previous.left == null && previous.right == null) {
                previous = previous.next;
            }
            if (previous == null) {
                return;
            }
            leftMost = previous.left != null ? previous.left : previous.right;
            TreeLinkNode curr = leftMost;
            while (previous != null) {
                if (previous.left == curr) {
                    if (previous.right != null) {
                        curr.next = previous.right;
                        curr = curr.next;
                    }
                        previous = previous.next;
                    
                } else if (previous.right == curr) {
                    previous = previous.next;
                } else {
                    if (previous.left == null && previous.right == null) {
                        previous = previous.next;
                    } else {
                        curr.next = previous.left != null ? previous.left : previous.right;
                        curr = curr.next;
                    }
                }
            }
        }
    }
}