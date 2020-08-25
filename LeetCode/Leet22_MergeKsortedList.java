/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode merged = new ListNode(-1);
        ListNode head = merged;
        
        for(ListNode l : lists){
            while(l != null){
                pq.add(l.val);
                l = l.next;
            }
        }
        
        while(!pq.isEmpty()){
            merged.next = new ListNode(pq.poll());
            merged = merged.next;
        }
        return head.next;
    }
}
// try 2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode n: lists){
            while(n != null){
                pq.add(n.val);
                n = n.next;
            }
        }
        ListNode res = new ListNode();
        ListNode ptr = res;
        while(pq.peek() != null){
            res.next = new ListNode(pq.poll());
            res = res.next;
        }
        return ptr.next;
    }
}

/// merge list one by one-
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        if(lists.length == 1) return lists[0];
        ListNode result = lists[0];
        ListNode head = result;
        for(int i=1; i<lists.length; i++){
            result = mergeLists(result, lists[i]);
            // System.out.println("");
        }
        return result;
    }
    static ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode();
        ListNode head = res; 
        while( l1 !=null && l2!=null){
            if(l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
            else if(l1.val == l2.val){
              
                res.next = new ListNode(l1.val);
                res = res.next;
                res.next = new ListNode(l2.val);
                
                l1 = l1.next;
                l2 = l2.next;
                res = res.next;
            }
            else {
              
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            }
        }
        if(l1 != null && l2 == null) res.next = l1;
        if(l1 == null && l2 != null) res.next = l2;
        
        // ListNode temp = head;
        // while(temp != null) {System.out.print(" "+ temp.val); temp=temp.next;}
        return head.next;
    }
}
