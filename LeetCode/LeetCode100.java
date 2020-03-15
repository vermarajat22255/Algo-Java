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
    ArrayList<Integer> s1 = new ArrayList<>();
    ArrayList<Integer> s2 = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        get(p,s1);
        get(q,s2);
        System.out.println(s1);
        return s1.equals(s2);
    }
    public void get(TreeNode x, ArrayList<Integer> s){
        if(x == null ) {
            s.add(null);
            return;
        }
        
        s.add(x.val);
        get(x.left,s);
        get(x.right,s);
    }
}
//////////////////////recursive///////////////
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q == null || p== null && q!=null) return false;
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
