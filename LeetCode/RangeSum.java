class RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high, 0);
    }
    public int helper(TreeNode root, int low, int high, int sum){
        if(root == null) 
            return sum;
        sum=helper(root.left,low, high, sum);
        if(root.val >= low && root.val <= high ) {
            sum += root.val;
        }    
        sum=helper(root.right, low, high, sum);
        return sum;
    }
    
}
