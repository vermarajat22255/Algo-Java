
public class Leet_HeightBinary {
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

    public int maxDepth(TreeNode root) {
        int leftC = 0, rightC = 0;
        return height(root, leftC, rightC);
    }

    public int height(TreeNode root, int leftC, int rightC) {
        if (root == null)
            return 0;
        leftC = height(root.left, leftC + 1, rightC);
        rightC = height(root.right, leftC, rightC + 1);
        return Math.max(leftC, rightC) + 1;
    }
}