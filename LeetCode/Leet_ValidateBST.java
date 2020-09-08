
public class Leet_ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, -Double.MIN_VALUE, Double.MAX_VALUE);

    }

    public boolean inOrder(TreeNode root, double min, double max) {
        // System.out.println(root.val+" min ->"+min+" max --> "+max);
        if (root != null) {

            System.out.println((min >= root.val) + " kese " + min + " root" + root.val);
            if (min >= root.val || root.val >= max)
                return false;

            return inOrder(root.left, min, root.val) && inOrder(root.right, root.val, max);
        }
        return true;
    }
}