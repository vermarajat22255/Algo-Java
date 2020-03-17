/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(-1);
        ListNode ptr = merged;
        while(l1!=null && l2 != null){
            if(l1.val <= l2.val){
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            merged = merged.next;
        }
        if(l1 == null && l2 != null) merged.next = l2;
        if(l1 != null && l2 == null) merged.next = l1;
        return ptr.next;
    }
}
