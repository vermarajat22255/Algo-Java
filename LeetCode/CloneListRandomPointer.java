class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class CloneListRandomPointer {
    public Node copyRandomList(Node head) {
        // First pass create all nodes without pointers and store mapping of clone
        
        Node original_copy = head;
        LinkedHashMap<Node, Node> node_map = new LinkedHashMap<>();
        
        while(head != null){
            Node cloned = new Node(head.val);
            node_map.put(head, cloned);
            head = head.next;
        }
        head = original_copy;
        
	// map cloned nodes pointer
        
        for(Map.Entry<Node, Node> e: node_map.entrySet()){
            Node original = e.getKey();
            Node clone = e.getValue();
            clone.next = node_map.get(original.next);
            clone.random = node_map.get(original.random);    
        }
        return node_map.get(original_copy);
    }
}
