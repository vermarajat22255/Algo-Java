

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
class DuplicateFromLL {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode senital = new ListNode(0, head);
        ListNode pred = senital;
        while(head != null){
            // if the values are same keep skipping the nodes
	    if(head.next  != null && head.val == head.next.val){
                while(head.next  != null && head.val == head.next.val){
                    head = head.next;
                }
		// set the predecessor to the next non duplicate node of head
                pred.next = head.next;
            }else{
		// if no duplicates found set the pred to pred.next 
                pred = pred.next;
            }
            head = head.next;
        }
        return senital.next;
    }
}
