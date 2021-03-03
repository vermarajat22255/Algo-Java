/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Leet430_FlattenLinkedList {
    /*
     1 -- NULL
     |
     2 -- NULL
     |
     3 -- NULL
     o/p 1 2 3
    */
    public Node flatten(Node head) {
        if(head == null ) return null;
        Node cpy = head;
        helper(head);
        return cpy;
    }
    public Node helper(Node head){
        if(head.child == null && head.next == null)
            return head;
        if(head.child == null && head.next != null){
            return helper(head.next);
        }else{
            Node temp = head.next;
            head.child.prev = head;
            head.next = head.child;
            head.child = null;
            Node last_child = helper(head.next);
            if (temp != null){
                last_child.next = temp;
                temp.prev = last_child;
                head = temp;
            }
            return helper(head);
        }
        
    }
}
