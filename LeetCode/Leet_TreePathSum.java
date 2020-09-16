package LeetCode;

import java.util.ArrayList;

public class Leet_TreePathSum {

//   Definition for a binary tree node.
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
 
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> al = new ArrayList<>();
        if(root == null) return 0;
        visit(root, "", al);
        System.out.println(al);
        return getSum(al);
    }
    public void visit(TreeNode root, String path, ArrayList<String> paths){
        path += root.val;
        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }
        if(root.left != null){
            visit(root.left, path, paths);
        }
        if(root.right != null){
            visit(root.right, path, paths);
        }
    }
    public int getSum(ArrayList<String> paths){
        int sum=0;
        for(int i=0; i<paths.size(); i++){
            sum += Integer.parseInt(paths.get(i), 2);
        }
        return sum;
    }
}