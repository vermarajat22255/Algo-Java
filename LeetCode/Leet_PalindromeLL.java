
public class Leet_PalindromeLL {

    // Definition for singly-linked list.
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

    // 1 2 3 4 3 2 1
    // reverse Half of the linkedList and run two pointers?
    // 1<-2<-3 4->3->2->1

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        ListNode prev = null, buffer = curr.next;

        for (int i = 0; i < (count / 2); i++) {
            buffer = curr.next;
            curr.next = prev;
            prev = curr;
            curr = buffer;
        }

        if (count % 2 != 0 && buffer.next != null)
            buffer = buffer.next;

        while (prev != null && buffer != null) {
            if (prev.val != buffer.val)
                return false;
            prev = prev.next;
            buffer = buffer.next;
        }
        if ((prev == null && buffer != null) || (prev != null && buffer == null))
            return false;
        return true;
    }

    /*
     * /////////////////////////////////////////////////////////////////////////////
     * ///////////// O(n) Space Complexity
     * /////////////////////////////////////////////////////////////////////////////
     * ////////////
     */

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        String s = "";
        while (head != null) {
            s = s + head.val + ";";
            head = head.next;
        }
        String arr[] = s.split(";");
        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}