
public class SwapNodesPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next.next;
        head.next.next = head;
        head = head.next;
        head.next.next = swapPairs(temp);
        return head;
    }
}