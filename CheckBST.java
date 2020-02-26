/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        inorder(root);
        return checkTree(root,min,max);
    }
    public void inorder(TreeNode root){
        if(root!=null){
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
        }
    }
    public boolean checkTree(TreeNode root, long min, long max){
        if(root!=null){
        if(root.val >=max || root.val <= min) return false;
        return checkTree(root.left, min, root.val) && checkTree(root.right,root.val, max);
        }
        return true;
        
    }
}
