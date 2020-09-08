package LeetCode;

public class Leet_SymmetricTree {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }
    static boolean checkSymmetric( TreeNode t1, TreeNode t2 ){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val && checkSymmetric(t1.right, t2.left) && checkSymmetric(t1.left, t2.right));
    }
}