
public class Leet_mergeSorted {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), copy = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            } else if (l1.val == l2.val) {
                head.next = new ListNode(l1.val);
                head = head.next;
                head.next = new ListNode(l2.val);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            head.next = new ListNode(l1.val);
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            head.next = new ListNode(l2.val);
            head = head.next;
            l2 = l2.next;
        }
        return copy.next;
    }
}