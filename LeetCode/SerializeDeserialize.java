/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        // System.out.println(root.val+","+left+right);
        return root.val+","+left+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(nodes);
    }
    public TreeNode helper(Queue<String> nodes){
        String item = nodes.poll();
        if(item.equals("X")){
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(item));
        newNode.left = helper(nodes);
        newNode.right = helper(nodes);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
