package LeetCode;

import java.util.ArrayList;

public class Leet_PathSums {
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

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;
        ArrayList<Integer> paths = new ArrayList<>();
        int pathSum = 0;

        populatePath(root, pathSum, paths);
        // System.out.println(paths);
        return paths.contains(sum);
    }

    public void populatePath(TreeNode root, int pathSum, ArrayList<Integer> paths) {
        pathSum += root.val;
        if (root.left == null && root.right == null) {
            paths.add(pathSum);
            return;
        }
        if (root.left != null) {
            populatePath(root.left, pathSum, paths);
        }
        if (root.right != null) {
            populatePath(root.right, pathSum, paths);
        }
    }
}