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
