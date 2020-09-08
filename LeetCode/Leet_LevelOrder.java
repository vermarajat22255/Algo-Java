package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet_LevelOrder {
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
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return al;
        queue.add(root);
        ArrayList x = new ArrayList();
        x.add(root.val);
        al.add(x);
        
        while(!queue.isEmpty())
            queue = getNodes(queue, al);
        return al;
        
    }
    static Queue getNodes(Queue<TreeNode> queue, ArrayList<List<Integer>> al){
        ArrayList<Integer> temp = new ArrayList<>();            
        Queue<TreeNode> next = new LinkedList<>();
        
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t.left != null ) {
                temp.add(t.left.val);
                next.add(t.left);
            }
            if(t.right != null ) {
                temp.add(t.right.val);
                next.add(t.right);
            }
        }
        if(temp.size() > 0 ) al.add(temp);
        return next;
    }
}