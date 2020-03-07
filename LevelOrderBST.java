	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    static Queue<Node> q = new LinkedList<>();

	public static void levelOrder(Node root) {
      if(root == null) return ;
      q.add(root);
      
      while(q.peek()!=null){
        Node n = q.poll();
        System.out.print(n.data+" ");
        if(n.left != null) q.add(n.left);
        if(n.right != null) q.add(n.right);
      }

    }
