/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode ptr= head.next;
        
        head.next = swapPairs(head.next.next);
        ptr.next = head;
        return ptr;
    }
}
