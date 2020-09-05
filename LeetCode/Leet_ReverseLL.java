
public class Leet_ReverseLL {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseListIt(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, current = head, buffer = head.next;
        while (current != null) {
            buffer = current.next;
            current.next = prev;
            prev = current;
            current = buffer;
        }
        return prev;
    }
    public ListNode reverseListRec(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode listHead = reverseListRec(head.next);
    head.next.next = head;
    head.next = null;
    return listHead;
    }
}