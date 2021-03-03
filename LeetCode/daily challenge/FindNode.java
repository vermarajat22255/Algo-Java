/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class FindNode {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans = cloned;
        return helper(target, ans);
    }
    public TreeNode helper(TreeNode target, TreeNode curr){
        if(curr!= null && curr.val == target.val) return curr;
        if(curr.left != null){
            TreeNode l1 = helper(target, curr.left); 
            if ( l1!=null && l1.val== target.val)
                return l1; 
        }
        if(curr.right!=null){
            TreeNode l2 = helper(target, curr.right);
            if (l2!= null && l2.val == target.val)
                return l2;
        }
        return curr;
    }
}
